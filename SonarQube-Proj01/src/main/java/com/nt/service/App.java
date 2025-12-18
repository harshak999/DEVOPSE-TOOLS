package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class App {

 private static Logger logger=Logger.getLogger("com/nt/service/App.java");	
	public void m1()
	{
		logger.info("App.m1()");
		
	}
	
	
	public void m2()
	{
		logger.info("App.m2()");
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(10);list.add(20);
		
		list.add(null);
		
		list.add(101);
		logger.info("End of m2()");
		
	}
	
	public static void main(String[] args) {
		logger.info("Start of  main(-) method");
        
        
        App app=new App();
        app.m1();
		app.m2();
		logger.info("End of  main(-) method");
    }
}
