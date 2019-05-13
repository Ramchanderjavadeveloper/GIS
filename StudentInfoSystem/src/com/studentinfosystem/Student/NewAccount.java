package com.studentinfosystem.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.*;

import com.studentinfosystem.bean.Bean;

public class NewAccount {
	public String Email, S_password, S_Name, Address;
	public int Phone;
	Connection con = null;
	PreparedStatement ps = null;
	Scanner scanner = new Scanner(System.in);

	public void process() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfosystem", "root", "root");
			Bean bean = new Bean();
			
			System.out.println("****************************");
			System.out.println("	 Registration Form");
			System.out.println("****************************");
			System.out.println("Email=");
			bean.setEmail(scanner.nextLine());
			System.out.println("Student Password=");
			bean.setS_password(scanner.next());
			System.out.println("Student Name=");
			bean.setS_Name(scanner.next());
			System.out.println("Phone=");
			bean.setPhone(scanner.next());
			System.out.println("Address=");
			bean.setAddress(scanner.next());
			
			
			

			String sql = "insert into student values(default,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, bean.getEmail());
			ps.setString(2, bean.getS_password());
			ps.setString(3, bean.getS_Name());
			ps.setString(4, bean.getPhone());
			ps.setString(5, bean.getAddress());
			ps.executeUpdate();
			
			System.out.println("Your Account Created Please Login");
			Login login=new Login();
			login.process();
			con.close();

		} catch (Exception e) {
			
			e.printStackTrace();

		}

	}

}
