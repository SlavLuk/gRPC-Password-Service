package ie.gmit.ds;


import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;

import io.grpc.*;
import io.grpc.stub.StreamObserver;

public class GrpcClient {

	private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());
	private final ManagedChannel channel;
	private final UserPasswordServiceGrpc.UserPasswordServiceStub asyncPasswordService;
	private final UserPasswordServiceGrpc.UserPasswordServiceBlockingStub syncPasswordService;
	private UserResponse response;
	private Menu menu = new Menu();
	private User user;
	private ByteString hashedPasspord;
	private ByteString salt;
	private Map<Integer,User> userMap = new HashMap<>();
	public GrpcClient(String host, int port) {

		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		syncPasswordService = UserPasswordServiceGrpc.newBlockingStub(channel);
		asyncPasswordService = UserPasswordServiceGrpc.newStub(channel);
	}

	public void userRequest() throws Exception {
		user = menu.getInput();
		UserRequest request = UserRequest.newBuilder().setUserId(user.getUserId()).setPassword(user.getPassword())
				.build();
		response = syncPasswordService.hash(request);

		hashedPasspord = response.getHashedPassword();

	
		
		salt = response.getSalt();
		
		
	}

	public void validationRequest() throws Exception {
		
	
		user = menu.getInput();
		
		StreamObserver<BoolValue> responseObserver = new StreamObserver<BoolValue>() {
			@Override
			public void onNext(BoolValue value) {
					
				
					
					if (value.getValue()) {

						System.out.println("Successfully validated ");
						
					
					} else {
						System.out.println("Invalid password or username ");
					}
			
				//	onCompleted();
			}

			@Override
			public void onError(Throwable t) {

				Status status = Status.fromThrowable(t);

				logger.log(Level.WARNING, "RPC Error: {0}", status);
			}

			@Override
			public void onCompleted() {

				logger.info("Finished validation");
				// End program
				System.exit(0);
			}
		};

		asyncPasswordService.validate(UserValidationRequest.newBuilder().setPassword(user.getPassword())
				.setHashedPassword(hashedPasspord).setSalt(salt).build(), responseObserver);

	}

	public void shutdown() throws InterruptedException {

		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public static void main(String[] args) throws InterruptedException {

		GrpcClient client = new GrpcClient("localhost", 9090);

		try {
			
			client.userRequest();
			client.validationRequest();
			
		} catch (Exception e) {
			
			 logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());

		} finally {
			// Don't stop process, keep alive to receive async response
			Thread.currentThread().join();
		}
	}

}
