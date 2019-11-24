package ie.gmit.grpconnector;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.protobuf.ByteString;
import ie.gmit.ds.UserPasswordServiceGrpc;
import ie.gmit.ds.UserRequest;
import ie.gmit.ds.UserResponse;
import ie.gmit.ds.UserValidationRequest;
import ie.gmit.model.UserOutput;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class GrpcClient {

	private final ManagedChannel channel;
	private final UserPasswordServiceGrpc.UserPasswordServiceStub asyncPasswordService;
	private final UserPasswordServiceGrpc.UserPasswordServiceBlockingStub syncPasswordService;
	private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());


	public GrpcClient(String host, int port) {

		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		asyncPasswordService = UserPasswordServiceGrpc.newStub(channel);
		syncPasswordService = UserPasswordServiceGrpc.newBlockingStub(channel);

	}

	public void getHashedPassword(int userId, String userPassword, final Map<Integer, UserOutput> userMap,
			final UserOutput out) throws Exception {

		StreamObserver<UserResponse> responseObserver = new StreamObserver<UserResponse>() {
			@Override
			public void onNext(UserResponse value) {

				out.setUserId(value.getUserId());
				out.setHashedPassword(value.getHashedPassword());
				out.setSalt(value.getSalt());

				userMap.put(value.getUserId(), out);

			}

			@Override
			public void onError(Throwable t) {

				Status status = Status.fromThrowable(t);

				logger.log(Level.WARNING, "RPC Error: {0}", status);
			}

			@Override
			public void onCompleted() {

				logger.info("Finished validation");

			}
		};

		asyncPasswordService.hash(UserRequest.newBuilder().setUserId(userId).setPassword(userPassword).build(),
				responseObserver);


	}

	public boolean validationRequest(String password,ByteString hashedPassword,ByteString salt,boolean response) throws Exception {

		UserValidationRequest request = UserValidationRequest
								.newBuilder()
								.setPassword(password)
								.setHashedPassword(hashedPassword)
								.setSalt(salt)
								.build();
		
		return response = syncPasswordService.validate(request).getValue();
		
	
	}

}
