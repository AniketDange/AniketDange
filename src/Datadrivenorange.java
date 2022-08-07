import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import orengehrm.Loginpage;
import utils.Apputils;

public class Datadrivenorange extends Apputils
{
	String datafile ="C:\\Aniket.march-22\\DATA driven-test\\testdata\\username123Book1.xlsx";
	String datasheet= "validusername";
	@Test
 public void checkadminmodul() throws IOException
 {   
        Loginpage lp = new Loginpage();
        String username,passwd;
		int rowcount = XLUtils.getRowcount("datafile", "datasheet");
		
		
		for(int i=1; i<=rowcount;i++)
		{
			username=XLUtils.getStringCelldata(datafile, datasheet, i, 0);
			passwd= XLUtils.getStringCelldata(datafile, datasheet, i, 1);
			lp.login(username, passwd);
		boolean res =lp.isAdminModulisDisply();
		Assert.assertTrue(res);
		if(res)
		{
			XLUtils.setcellvalue(datafile, datasheet, i, 2, "Pass");
			XLUtils.fillgreencolor(datafile, datasheet, i, 2);
			
		}else
		{
			XLUtils.setcellvalue(datafile, datasheet, i, 2, "Fail");
			XLUtils.fillgreencolor(datafile, datasheet, i, 2);
		
		}

		lp.logout();
		}
		
 }
	
}
	 

		
