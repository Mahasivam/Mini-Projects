package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity=500;
	private int defaultPasswordLength=10;
	private String alternativeEmail;
	private String companySuffix = "sivindustries.com";
	
	// Here I'm just creating constructor to receive firstName and lastName
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("Email Created:" + this.firstName + " " + this.lastName);
		
		// Call a method to ask for department and return the department
		this.department = SetDepartment();
		//System.out.println("Department:" +this.department);
		
		// generate random password
		this.password = randomPassword(defaultPasswordLength);
		//System.out.println("Your Password is: " + this.password);
		
		// combine elements to generate emailID
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		//System.out.println("Your EmailID: " + this.email);
	}
	// Create a method to ask for department
	public String SetDepartment() {
		System.out.println("New worker: " + firstName + ". Department Codes:\n1 Sales \n2 Development \n3 Accounting \n0 none\nEnter the department");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if (deptChoice == 1) {return "sales";}
		else if (deptChoice == 2) {return "dev";}
		else if (deptChoice == 3) { return "acc";}
		else {return "";}
	}

	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
		char[] password = new char[length];
			for(int i=0; i<length; i++) {
				int rand = (int) (Math.random() * passwordSet.length()); 
				password[i] = passwordSet.charAt(rand);
			}
			return new String(password);
	}
	
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// get alternative email
	public void setAlternateEmail(String altEmail) {
		this.alternativeEmail = altEmail;
	}
	
	// change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getAlternateEmail() {return alternativeEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "Display Name: " + firstName + "" + lastName +
				"\nCompany Email: " + email +
				"\nMailBoxCapacity: " + mailboxCapacity + "mb";
	}
}
