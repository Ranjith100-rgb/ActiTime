package com.actiTime.testcase;



import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genricUtility.BaseClass;

@Listeners(com.genricUtility.ListenerImplementation1.class)
public class DemoTest extends BaseClass{
	
	@Test
	public void test1()
	{
		System.out.println("Hi! Welcome to Jenkins");
		System.out.println("Bye");
		System.out.println("Welcome Back");
	}

}
