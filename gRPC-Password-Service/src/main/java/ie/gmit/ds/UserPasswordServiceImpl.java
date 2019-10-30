package ie.gmit.ds;

import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;

import ie.gmit.ds.UserPasswordServiceGrpc.UserPasswordServiceImplBase;
import io.grpc.stub.StreamObserver;

public class UserPasswordServiceImpl extends UserPasswordServiceImplBase {

	@Override
	public void hash(UserRequest request, StreamObserver<UserResponse> responseObserver) {

		UserResponse.Builder response = UserResponse.newBuilder();

		try {
			// User
			String password = request.getPassword();
			int userId = request.getUserId();
			char[] charArrayPass = password.toCharArray();

			byte[] salt = Passwords.getNextSalt();
			byte[] hashedPassword = Passwords.hash(charArrayPass, salt);


			response.setHashedPassword(ByteString.copyFrom(hashedPassword))
					.setSalt(ByteString.copyFrom(salt))
					.setUserId(userId);

			responseObserver.onNext(response.build());
		} catch (Exception e) {

			responseObserver.onNext(response.getDefaultInstanceForType());

		}
		responseObserver.onCompleted();
	}

	@Override
	public void validate(UserValidationRequest request, StreamObserver<BoolValue> responseObserver) {

		super.validate(request, responseObserver);
	}

}
