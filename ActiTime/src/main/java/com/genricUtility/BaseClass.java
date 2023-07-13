package com.genricUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.actiTime.POM.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 

{
	public static WebDriver rdriver;
	public WebDriver driver=null;
	
	public FilePathUtility fLib=new FilePathUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public DataBaseUtility dLib=new DataBaseUtility();
	public WebUtility wLib= new WebUtility();
	String BROWSER;
	String URL;
	String ENV_FILE_PATH;
	String TEST_SCRIPT_EXCEL_FILE_PATH;
	
	
	@BeforeSuite
	public void getDBconnection() throws SQLException
	{
		dLib.connectToDB();
		System.out.println("DataBase has been connected");
	
	}
	
	@BeforeClass
	public void LaunchBrowser() throws Throwable
	{
		String ENV_FILE_PATH = fLib.getFilePathFromPropertyFile("EnviConfigData");
		BROWSER = fLib.getDataFromPropertyFile(ENV_FILE_PATH, "browser");
		URL =fLib.getDataFromPropertyFile(ENV_FILE_PATH, "url");
		if(BROWSER.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(URL);
		rdriver=driver;
	}
	
	@BeforeMethod
	public void LoginToApp() throws Throwable
	{
		
		String TEST_SCRIPT_EXCEL_FILE_PATH = fLib.getFilePathFromPropertyFile("testScriptData");
		String USERNAME = eLib.getDataFromExcel(TEST_SCRIPT_EXCEL_FILE_PATH, "Sheet1", "tc_01", "username");
		String PASSWORD = eLib.getDataFromExcel(TEST_SCRIPT_EXCEL_FILE_PATH, "Sheet1", "tc_01", "password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToAppWithValidCredentials(USERNAME, PASSWORD);
	}
	
	@AfterMethod
	public void LogOutOfApp()
	{
		System.out.println("Logged out of the application successfully");
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void CloseDB() throws SQLException
	{
		dLib.closeDB();
	}

}
