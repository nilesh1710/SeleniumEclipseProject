package TestSuite;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.KredSafe.TestBase.TestBase;
import com.KredSafe.User.ClientLoginPage;
import com.KredSafe.User.RegisterPage;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;

public class TC19_ChangepasswordbyExcel extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC19_ChangepasswordbyExcel.class.getName());
	private static final String By = null;

	//@BeforeClass
//	public static void startTest() {

	//	test = extent.startTest("TC19_ChangepasswordbyExcel");

	//}


	@BeforeMethod
	public void setup(Method result) throws IOException {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		init();

	}
	
	@Test(priority = 1, enabled = true)
	public void clientLogin() throws IOException, InterruptedException, AWTException {

		log.info("<===========Started Verifying RegisterUsingOnlineApplication===========> ");
		openAppUrl();
		ClientLoginPage clp = new ClientLoginPage(driver);
		clp.clientSignIn("ts1234@yopmail.com", "Nilesh@2025");
		RegisterPage rp = new RegisterPage(driver);
		//rp.accessYopmaiforOTP();
		//rp.verifyOTPFunctionality(OR.getProperty("OTPSource"), null);
		
	}
	
	
	@DataProvider(name = "exceldata") String[][] dataprovidefunc() throws
	  BiffException, IOException {
	  
	  String[][] obj = getData("KredSafe_Login_Data.xlsx", "Sheet2"); 
	  return obj;
	  
	  }
	 
	
	@Test(dataProvider = "exceldata", priority = 2, enabled = true)
	public void verifyLoginFunctionality(String oldpassword , String newpassword,String confirmpassword,String errormessage) throws IOException, InterruptedException, AWTException {

		log.info("<===========Started Verifying Login Functionality===========> ");
		//openAppUrl();
		ClientLoginPage clp = new ClientLoginPage(driver);
		clp.Changepassword(oldpassword,newpassword,confirmpassword,errormessage);
		
	}


	@AfterMethod	
	public void afterMethod(ITestResult result) {
		get_result(result);

	}


}