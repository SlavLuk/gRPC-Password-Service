package ie.gmit.ds;

import java.util.Map;

import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;

import ie.gmit.ds.UserPasswordServiceGrpc.UserPasswordServiceImplBase;
import io.grpc.stub.StreamObserver;

public class UserPasswordServiceImpl extends UserPasswordServiceImplBase {

	@Override
	public void hash(UserRequest request, StreamObserver<UserResponse> responseObserver) {

		UserResponse.Builder response = UserResponse.newBuilder();

		try {
			// User's inputs		
			int userId = request.getUserId();
			// convert string into char array
			char[] bytePassword = request.getPassword().toCharArray();
			// generate a hashed password with salt
			byte[] salt = Passwords.getNextSalt();
			byte[] hashedPassword = Passwords.hash(bytePassword, salt);

			// build response object
			response.setUserId(userId)
					.setHashedPassword(ByteString.copyFrom(hashedPassword))
					.setSalt(ByteString.copyFrom(salt));
					
			responseObserver.onNext(response.build());
			
		} catch (Exception e) {
			
			responseObserver.onNext(response.getDefaultInstanceForType());

		}
		responseObserver.onCompleted();
	}

	@Override
	public void validate(UserValidationRequest request, StreamObserver<BoolValue> responseObserver) {

		try {
			// User's inputs	
            char[] bytePassword = request.getPassword().toCharArray();
            byte[] hashedPassword = request.getHashedPassword().toByteArray();
            byte[] salt = request.getSalt().toByteArray();

            // Validate password
            if(Passwords.isExpectedPassword(bytePassword, salt, hashedPassword)){
            	
                responseObserver.onNext(BoolValue.newBuilder().setValue(true).build());
            }
            
            else{
                responseObserver.onNext(BoolValue.newBuilder().setValue(false).build());
            }
			
		} catch (RuntimeException e) {
			
			responseObserver.onNext(BoolValue.newBuilder().setValue(false).build());
		}
		responseObserver.onCompleted();
	}

}
