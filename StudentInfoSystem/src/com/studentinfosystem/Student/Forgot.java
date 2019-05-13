package com.studentinfosystem.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.studentinfosystem.bean.Bean;

public class Forgot {
	Scanner scanner=new Scanner(System.in);
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs;
	int ch;
	
	public void process() {
		// TODO Auto-generated method stub
		try {
				Bean bean=new Bean();
				System.out.println("****************************");
				System.out.println("	 Forgot Password ");
				System.out.println("****************************");
				System.out.println("Enter Your Email id");
				bean.setEmail(scanner.nextLine());
				
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfosystem", "root", "root");
			
			String sql ="SELECT * FROM student WHERE Email =  ?";
			ps=con.prepareStatement(sql);
			ps.setString(1,bean.getEmail());
			
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				System.out.println(rs.getString(3));
				System.out.println("do you want continue to Login press 1");
				ch=scanner.nextInt();
				if(ch==1)
				{
					
					Login login=new Login();
					login.process();
				}
				else
				{
					System.out.println("Thanks For Visit");
				}
			}else
			{
				System.out.println("User not exists!!!");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
