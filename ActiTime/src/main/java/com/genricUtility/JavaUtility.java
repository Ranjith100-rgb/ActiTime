package com.genricUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{		
	Random ran=new Random();
	Date date=new Date();
	
	public int getRandom()
	{
		int r=ran.nextInt(3000);
		return r;
	}
	
	public String getDate()
	{
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sim.format(date);
		return formattedDate;
	}
	
	public String getDateBasedOnRequirment()
	{
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, 30);
		Date date1 = cal.getTime();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sim.format(date1);
		return formattedDate;
	}

}
