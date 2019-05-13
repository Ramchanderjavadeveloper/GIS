package com.studentinfosystem.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentPanel {

	Scanner scanner = new Scanner(System.in);
	Connection con = null;
	PreparedStatement ps = null;
	int ch;

	public void student() {
		try {
			System.out.println("*************************************************");
			System.out.println("         Student Information System");
			System.out.println("*************************************************");
			System.out.println("1. Login");
			System.out.println("2. Create New Account");
			System.out.println("3. Forgot Account");
			ch = scanner.nextInt();
			if (ch == 1) {
				Login login = new Login();
				login.process();
			} else if (ch == 2) {
				NewAccount newaccount = new NewAccount();
				newaccount.process();
			} else if (ch == 3) {
				Forgot forget = new Forgot();
				forget.process();
			} else {
				System.out.println("Enter A valid input");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
