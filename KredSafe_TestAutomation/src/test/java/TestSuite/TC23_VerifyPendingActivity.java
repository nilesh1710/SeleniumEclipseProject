package TestSuite;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.KredSafe.TestBase.TestBase;
import com.KredSafe.User.ClientLoginPage;
import com.KredSafe.User.RegisterPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC23_VerifyPendingActivity extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC04_OTP.class.getName());
	private static final String By = null;

	//@BeforeClass
	//public static void startTest() {

	//	test = extent.startTest("TC23_VerifyPendingActivity");

	//}	
	@FindBy(xpath = "/html/body/div[3]/nav/ul[1]/li[2]/span/img")
	WebElement menuclick;
	
	@FindBy(xpath = "/html/body/div[3]/aside/div/div[2]/nav/ul/li[6]/a")
	WebElement formclick;
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
		clp.clientSignIn(OR.getProperty("emailID3"), OR.getProperty("createAccountPassword3"));
		//clp.clientSignIn("nh910@yopmail.com", "Nilesh@2025");
		RegisterPage rp = new RegisterPage(driver);
		//rp.accessYopmaiforOTP();
		//rp.verifyOTPFunctionality(OR.getProperty("OTPSource"), null);
		waitInSeconds(10);
		ClientLoginPage clp1 = new ClientLoginPage(driver);
		clp1.Pendingactivity();
		//RegisterPage clp2 = new RegisterPage(driver);
	   // clp2.FormPlans();
	
	}


	@AfterMethod	public void afterMethod(ITestResult result) {
		get_result(result);

	}


}