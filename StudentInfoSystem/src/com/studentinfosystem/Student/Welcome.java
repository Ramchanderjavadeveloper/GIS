package com.studentinfosystem.Student;

import java.io.IOException;

import com.studentinfosystem.bean.Bean;

public class Welcome    {

	public void process() {
		Bean bean=new Bean();
		System.out.println("Welcome Student");
		Runtime rs = Runtime.getRuntime();
		 
	    try {
	      rs.exec("notepad");
	      
	    }
	    catch (IOException e) {
	      System.out.println(e);
	    }
		
		// TODO Auto-generated method stub
	
	}

}
