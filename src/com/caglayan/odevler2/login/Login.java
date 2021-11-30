package com.caglayan.odevler2.login;

import java.util.Scanner;

/**
 * Console user authorization class
 * @author cagla
 *
 */
public class Login {
	private int userID;
	private int attempt;
	private String userName;
	private String eMail;
	private String password;
	
	
	public Login(int userID, int attempt, String userName, String eMail, String password) {
		this.userID = userID;
		this.attempt = attempt;
		this.userName = userName;
		this.eMail = eMail;
		this.password = password;
	}

	/**
	 * Checks the accuracy of the entered informations
	 * @param userName
	 * @param password
	 * @return userID if params correct else returns -1
	 */
	public int checkUserInfo(String userName, String password) {
		if (this.userName == userName && this.password == password) {
			return this.userID;
		}
		else{
			attempt--;
			return -1;
		}
	}
	
	/**
	 * Gets userName and password from console 
	 * @return LoginInfo class which have userName and password from user input
	 */
	private LoginInfo getUserInput() {
		Scanner scanner = new Scanner(System.in);
		String userName, password;
		System.out.println("Kullanıcı adı girin : ");
		userName = scanner.nextLine();
		System.out.println("Şifre girin : ");
		password = scanner.nextLine();
		scanner.close();
		
		return new LoginInfo(userName, password);
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public int getUserID() {
		return userID;
	}

	public int getAttempt() {
		return attempt;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Login [userID=" + userID + ", attempt=" + attempt + ", userName=" + userName + ", eMail=" + eMail
				+ ", password=" + password + "]";
	}
}
