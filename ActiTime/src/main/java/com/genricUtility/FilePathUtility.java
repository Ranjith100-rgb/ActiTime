package com.genricUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FilePathUtility 
{
	public String getFilePathFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./config/FilePathDataFromPropertyFile.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		return data;
	}
	
	public String getDataFromPropertyFile(String FilePath,String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(FilePath);
		Properties pObj=new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		return data;
	}
}
