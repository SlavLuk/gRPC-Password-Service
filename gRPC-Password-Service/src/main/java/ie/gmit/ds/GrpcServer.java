package ie.gmit.ds;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.*;

public class GrpcServer {
	
		private Server grpcServer;
	    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());
	    private static final int PORT = 50551;
	
	 private void start() throws IOException {
		 
	        grpcServer = ServerBuilder.forPort(PORT)
	                .addService(new UserPasswordServiceImpl())
	                .build()
	                .start();
	        logger.info("Server started, listening on " + PORT);

	    }

	 
	    /**
	     * Await termination on the main thread since the grpc library uses daemon threads.
	     */
	    private void blockUntilShutdown() throws InterruptedException {
	        if (grpcServer != null) {
	            grpcServer.awaitTermination();
	        }
	    }

	public static void main(String[] args) throws InterruptedException, IOException {
	
		 final GrpcServer server = new GrpcServer();
		 server.start();
		 server.blockUntilShutdown();

	}

}
