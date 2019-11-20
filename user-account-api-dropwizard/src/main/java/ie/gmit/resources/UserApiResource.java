package ie.gmit.resources;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.core.MediaType;

import com.google.protobuf.ByteString;
import com.sun.research.ws.wadl.Response;

import ie.gmit.ds.UserPasswordServiceGrpc;
import ie.gmit.ds.UserRequest;
import ie.gmit.ds.UserResponse;
import ie.gmit.model.User;
import io.grpc.*;

import javax.ws.rs.*;

@Path("/users")

public class UserApiResource {

	private final ManagedChannel channel;
	private final UserPasswordServiceGrpc.UserPasswordServiceStub asyncPasswordService;
	private HashMap<Integer, User> userMap = new HashMap<>();
	private final UserPasswordServiceGrpc.UserPasswordServiceBlockingStub syncPasswordService;
	private UserResponse response;

	public UserApiResource() {

		channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		asyncPasswordService = UserPasswordServiceGrpc.newStub(channel);
		syncPasswordService = UserPasswordServiceGrpc.newBlockingStub(channel);

	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Collection<User> getArtists() {

		return userMap.values();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User createUser(User user) {

		int userId = user.getUserId();
		String userName = user.getUserName();
		String email = user.getEmail();
		String password = user.getPassword();

		UserRequest request = UserRequest.newBuilder().setUserId(userId).setPassword(password).build();
		response = syncPasswordService.hash(request);

		User u = new User();
		u.setUserId(userId);
		u.setUserName(userName);
		u.setEmail(email);
		u.setHashedPassword(String.valueOf(response.getHashedPassword()));
		u.setSalt(String.valueOf(response.getSalt()));

		userMap.put(userId, u);

		return userMap.get(userId);
	}

	public void shutdown() throws InterruptedException {

		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	// Get info on a speci c user
	// Update user details
	// Delete a user
	// List all users
	// Login a user
}
