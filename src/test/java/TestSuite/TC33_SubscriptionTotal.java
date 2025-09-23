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

import edu.emory.mathcs.backport.java.util.concurrent.TimeoutException;



public class TC33_SubscriptionTotal extends TestBase {
	public static final Logger log = Logger.getLogger(TC33_SubscriptionTotal.class.getName());

	//@BeforeClass
	//public static void startTest() {

	//	test = extent.startTest("TC18_Restoreprofiledata");

	//}
	
	@FindBy(xpath = "/html/body/div[3]/aside/div/div[2]/nav/ul/li[2]/a")
	WebElement personalDetails;

	@BeforeMethod
	public void setup(Method result) throws IOException {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		init();
		
	
	}
	@Test(priority = 1, enabled = true)
	public void SubsctionToatl() throws IOException, InterruptedException, AWTException, TimeoutException {
		

		log.info("<===========Started Verifying RegisterUsingOnlineApplication===========> ");
		openAppUrl();
		ClientLoginPage clp = new ClientLoginPage(driver);
		//clp.clientSignIn(OR.getProperty("emailID18"), OR.getProperty("createAccountPassword18"));
		clp.clientSignIn("sep9@yopmail.com", "Nilesh@2025");

	//RegisterPage clp2 = new RegisterPage(driver);
		wait_for_page_load(5);
		waitInSeconds(10);
		//clp2.accessYopmaiforOTP();
		//clp2.verifyOTPFunctionality(OR.getProperty("OTPSource"),OR.getProperty("clientSignIn"));
		clp.Subscriptiontotal();
		
	}
	@AfterMethod
	public void afterMethod(ITestResult result) {
		get_result(result);
	}
	}
	