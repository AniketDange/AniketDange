package orengehrm;

import org.openqa.selenium.By;
import utils.Apputils;

public class Loginpage extends Apputils
{
	
public void login(String username, String passwd)
{
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	driver.findElement(By.id("txtPassword")).sendKeys(passwd);
	driver.findElement(By.className("button")).click();
	
}
public boolean isAdminModulisDisply()
{
	if (driver.findElement(By.linkText("Admin")).isDisplayed())
	    {
		return true; 
	    }else 
		return false;
}
public boolean isemployeeModulisDisply()
{
	if(driver.findElement(By.linkText("Admin")).isDisplayed())
		{
		return false;
		}else
		return true;
}
public boolean errermassegisDisply()
{
String errermasseg = driver.findElement(By.id("spanMessage")).getText();
if (errermasseg.toLowerCase().contains("invalid credentials"))
		{
	    return true;
		}else 
		return false;
	} 

public void logout()
{
driver.findElement(By.partialLinkText("Welcome")).click();
driver.findElement(By.linkText("Logout")).click();
}
}
