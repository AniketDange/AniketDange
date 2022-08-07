package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Apputils 
{
	public static WebDriver driver = new ChromeDriver();
	public static String url = "http://orangehrm.qedgetech.com";

	public static void launchapp()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
	}
	
	
	public static void closeapp()
	{
		driver.close();
	}
}
