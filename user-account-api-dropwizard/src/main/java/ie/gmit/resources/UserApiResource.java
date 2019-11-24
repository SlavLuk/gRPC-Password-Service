package ie.gmit.resources;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.grpconnector.GrpcClient;
import ie.gmit.model.UserInput;
import ie.gmit.model.UserOutput;
import ie.gmit.model.UserToString;

import javax.ws.rs.*;

//User API implementation

@Path("/users")
public class UserApiResource {

	private Map<Integer, UserOutput> userMap = new HashMap<>();
	private GrpcClient client;

	public UserApiResource(String host,int port) {

		client = new GrpcClient(host, port);
	}

	// get all users
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Collection<UserToString> getAllUsers() {
		
				Map<Integer,UserToString> asString = new HashMap<>();
					
				if (userMap.size() == 0) {

					throw new WebApplicationException("No valid users");
					
				}else {
									
					  // using for-each loop for iteration over Map.entrySet() 
			        for (Map.Entry<Integer,UserOutput> entry : userMap.entrySet()) {
			        	
			        	//converting hashed password and salt to strings
			        	UserToString toString = new UserToString();
			        	UserOutput out = userMap.get(entry.getKey());
			        	
			        	toString.setUserId(out.getUserId());
			        	toString.setUserName(out.getUserName());
			        	toString.setEmail(out.getEmail());
			        	toString.setHashedPassword(out.getHashedPassword().toStringUtf8());
			        	toString.setSalt(out.getSalt().toStringUtf8());
			        	
			        	asString.put(entry.getKey(), toString);
			        }
			        
			        
			        return asString.values();
			        	
			        }
			            
		
	}

	// get a user with specified id
	@GET
	@Path("/{userId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UserToString getUserById(@PathParam("userId") int userId) {

		
		UserToString toString = new UserToString();
		
		if (!userMap.containsKey(userId)) {

			throw new WebApplicationException(Response.Status.NOT_FOUND);
			
		}else {
			
			//converting hashed password and salt to strings
			UserOutput out = userMap.get(userId);
			
			toString.setUserId(userId);
			toString.setEmail(out.getEmail());
			toString.setUserName(out.getUserName());
			toString.setHashedPassword(out.getHashedPassword().toStringUtf8());
			toString.setSalt(out.getSalt().toStringUtf8());
			
		
			
			return toString;
			
		}

	

	}

	// create a new user and get a hashed password and salt
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.TEXT_PLAIN)
	public String createUser(UserInput user) {

		// user's request parameters
		int userId = user.getUserId();
		String userName = user.getUserName();
		String email = user.getEmail();
		String password = user.getPassword();
		
		UserOutput out = new UserOutput();
		
		out.setUserName(userName);
		out.setEmail(email);
		
		
		
		try {
			
			//call to GRPC server hash method 
				client.getHashedPassword(userId,password,userMap,out);
			

			
		} catch (Exception e) {
			
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		
		}

		return "User successfully created.";
	}

	@POST
	@Path("/login")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.TEXT_PLAIN)
	public String validateUser(UserInput in) {

		//get user's details id and password
    	int userId = in.getUserId();
		String userPass = in.getPassword();
		
		boolean response = false;

		UserOutput out = userMap.get(userId);
		
		
		
		try {
			
			//call to GRPC server validate method 
			response = 	client.validationRequest( userPass, out.getHashedPassword(), out.getSalt(),response);
			
			if(response) {
				
				return "Successfully logged in";
				
			}else {
				
				return "Sorry,Invalid password or username";
			}
			
			
		} catch (Exception e) {

			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		
	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String updateExistingUser(UserInput in) {
		
		UserOutput out = new UserOutput();
		
		try {
				
				if(userMap.containsKey(in.getUserId())) {
					
					out.setUserName(in.getUserName());
					out.setEmail(in.getEmail());
			
					client.getHashedPassword(in.getUserId(),in.getPassword(),userMap,out);
					
					return "User susseccfully updated.";
				}else {
					
					return "Sorry,Invalid user.";
				}
				
		}catch (Exception e) {

			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		
		
		
		
}
	@DELETE
	@Path("/{userId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUserById(@PathParam("userId") int userId) {
		
		if(userMap.containsKey(userId)) {
			
			//delete user
			userMap.remove(userId);
		}else {
			
			throw new WebApplicationException(Response.Status.NOT_FOUND);
			
		}
		
		
		
		return "User susseccfully deleted";
	
	}
}