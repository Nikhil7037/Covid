package com.example.demo.Nikhildemo1.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Hello {
	
	@RequestMapping("/hello")
	public List sayHi()
	{
	 List list=new ArrayList();
	 list.add("Nik");
	 list.add("Mkk");
	 return Arrays.asList(list);
	 
	}
	
	@RequestMapping("/data")
	public List fetch() throws SQLException, ClassNotFoundException
	{
		 List list=new ArrayList();
		 list.add("Test1");
		 list.remove("Test1");
		 list.remove("Nik");
		 String s1=null;
		 String s2=null;
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con;
		 con= DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/test?useSSL=false","root","Temp@123");  
		 System.out.println(con.toString());
		con.setAutoCommit(false);	
		 Statement stmt=con.createStatement(); 
		 ResultSet rs=stmt.executeQuery("select * from covid"); 
		 String s=null;;
		while(rs.next())
		{
			//list.add(rs.getString(1));
		    //list.add(rs.getString(2));
		   
		    //list.add(rs.getString(3));
			s=rs.getString(1);
		    s1=rs.getString(2);
		    s2=rs.getString(3);
		    list.add(s);
		    list.add(s1);
		    list.add(s2);
		//list.add(s);
		//list.add(s2);
		//list.add(s1);
		//System.out.println(s);
		  //System.out.println(rs.getInt(1));
		    System.out.println(s+ " "+s2+" "+s1);
		}	 
		 //System.out.println(rs.getString(2)+"  "+rs.getString(1)+" "+rs.getString(3));
		  try { con.close(); }catch(Exception e)
		  { 
			  e.printStackTrace(); }
		  con.close();
		  
		return Arrays.asList(list);
	}
	
	
	@RequestMapping("/delete")
	public void delete() throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con;
		 con= DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/test?useSSL=false","root","Temp@123");  
		
		con.setAutoCommit(false);	
		String country="test";
		 String sql=("delete from covid where country=?"); 
		  PreparedStatement stmt=con.prepareStatement(sql) ;
		  stmt.setString(1, country);
		
		 int row=stmt.executeUpdate() ;
		//stmt.executeBatch();
		System.out.println(row);
		con.commit();
		 //System.out.println(rs.getString(2)+"  "+rs.getString(1)+" "+rs.getString(3));
		  try { con.close(); }catch(Exception e)
		  { 
			  e.printStackTrace(); }
		  con.close();
		  
		//return Arrays.asList(list);
	}
	
	@RequestMapping("/update")
	public void update() throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con;
		 con= DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/test?useSSL=false","root","Temp@123");  
		
		con.setAutoCommit(false);	
		String country="Afghanistan";
		 String sql=("update covid set country ='test' where country=?"); 
		  PreparedStatement stmt=con.prepareStatement(sql) ;
		  stmt.setString(1, country);
		
		 int row=stmt.executeUpdate() ;
		//stmt.executeBatch();
		System.out.println(row);
		con.commit();
		 //System.out.println(rs.getString(2)+"  "+rs.getString(1)+" "+rs.getString(3));
		  try { con.close(); }catch(Exception e)
		  { 
			  e.printStackTrace(); }
		  con.close();
		  
		//return Arrays.asList(list);
	}
	
	
	@RequestMapping("/data2")
	public List fetchvaccinedata() throws SQLException, ClassNotFoundException
	{
		 List list=new ArrayList();
		
		 String s1=null;
		 String s2=null;
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con;
		 con= DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/test?useSSL=false","root","Temp@123");  
		 System.out.println(con.toString());
		con.setAutoCommit(false);	
		 Statement stmt=con.createStatement(); 
		 ResultSet rs=stmt.executeQuery("select * from vaccines"); 
		 String s=null;;
		while(rs.next())
		{
			//list.add(rs.getString(1));
		    //list.add(rs.getString(2));
		   
		    //list.add(rs.getString(3));
			s=rs.getString(1);
		    s1=rs.getString(2);
		    s2=rs.getString(3);
		    list.add(s);
		    list.add(s1);
		    list.add(s2);
		//list.add(s);
		//list.add(s2);
		//list.add(s1);
		//System.out.println(s);
		  //System.out.println(rs.getInt(1));
		   // System.out.println(s+ " "+s2+" "+s1);
		}	 
		 //System.out.println(rs.getString(2)+"  "+rs.getString(1)+" "+rs.getString(3));
		  try { con.close(); }catch(Exception e)
		  { 
			  e.printStackTrace(); }
		  con.close();
		  
		return Arrays.asList(list);
	}
	
	
	
	

}
