package ie.gmit.ds;

import java.util.Scanner;

public class Menu {
	
    private User user = User.getInstance();

	private Scanner scan = new Scanner(System.in);
	
	public User getInput() {
		
		System.out.println("Please enter id : ");
		
		user.setUserId(scan.nextInt());
		
		System.out.println("Please enter password : ");
		
		user.setPassword(scan.next());
		
		return user;
		
	}


}
