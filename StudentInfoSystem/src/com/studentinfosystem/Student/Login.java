package com.studentinfosystem.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.Scanner;

import com.studentinfosystem.bean.Bean;

public class Login {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs;
	Scanner scanner = new Scanner(System.in);
	String Email, S_password;
	boolean login = false;

	public void process() {
		// TODO Auto-generated method stub

		try {
			Bean bean = new Bean();
			System.out.println("****************************");
			System.out.println("	     Login");
			System.out.println("****************************");
			System.out.println("Email");
			bean.setEmail(scanner.nextLine());
			System.out.println("Password");
			bean.setS_password(scanner.next());

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfosystem", "root", "root");
			String sql = "select Email from student where Email=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, bean.getEmail());
			rs = ps.executeQuery();
			if (rs.next()) {
				String checkEmail = rs.getString(1);
				String checkPassword = rs.getString(2);

				if ((checkEmail.equals(bean.getEmail())) && (checkPassword.equals(bean.getS_password()))) {
					Welcome welcome = new Welcome();
					welcome.process();
				} else {
					System.out.println("invalid login");
				}
			} else {
				System.out.println("User not exists!!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
