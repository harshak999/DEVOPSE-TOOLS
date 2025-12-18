package com.nt.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmplyeeSelectTest {
//Logger object
private static Logger logger=LoggerFactory.getLogger(EmplyeeSelectTest.class);	
	
//Query
private static final String qury="SELECT *FROM EMPLOYEE";

	public static void main(String[] args) throws Exception {

		logger.debug("starty of main(-)");
		
		try(//establish the connection
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SYSTEM","harshak");)
		{
			logger.debug("Connection  with db s/w  is  establish");
			try(//create PreparedSatement obj
					PreparedStatement ps=con.prepareStatement(qury))
			{
				logger.debug("PreparedStaetement  obj Created");
				try(//execute the Query
						ResultSet rs=ps.executeQuery();){
					logger.debug("ResultSet obj is  created");
					//the process  the ResultSet object
					while(rs.next()) {
						System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
					}//while 
					
					logger.warn("It  better  to process the  resulSet  data Directly   with  getXxx() method");
					logger.debug("ResultSet Obj  is processed");
				}//try3
			}//try2
		} //try1

		
		catch(SQLException se) {//To handle  known Exception
			logger.error("DB problem ::"+se.getMessage());
			se.printStackTrace();
		}
		catch(Exception e) {//To handle  known Exception
			logger.error("Unknown DB problem ::"+e.getMessage());
			e.printStackTrace();
		}
	}//main

}//class
