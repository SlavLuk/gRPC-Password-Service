package ie.gmit.ds;

import ie.gmit.health.UserHealthCheck;
import ie.gmit.resources.UserApiResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;


public class UserApiApplication extends Application<UserApiConfig>{

	public static void main(String[] args) throws Exception {

		//start server
		new UserApiApplication().run(args);
		
	}

	@Override
	public void run(UserApiConfig configuration, Environment environment) throws Exception {
		
		final UserApiResource resource = new UserApiResource("localhost",9090);
		environment.jersey().register(resource);
		final UserHealthCheck healthCheck = new UserHealthCheck();
		environment.healthChecks().register("example", healthCheck);
	}

}
