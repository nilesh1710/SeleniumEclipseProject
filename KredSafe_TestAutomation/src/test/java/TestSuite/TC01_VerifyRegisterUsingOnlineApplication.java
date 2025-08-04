package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.KredSafe.TestBase.TestBase;
import com.KredSafe.User.RegisterPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC01_VerifyRegisterUsingOnlineApplication extends TestBase {

	public static final Logger log = Logger.getLogger(TC01_VerifyRegisterUsingOnlineApplication.class.getName());

	/*
	 * @BeforeClass public static void startTest() {
	 * 
	 * test = extent.startTest("TC01_VerifyRegisterUsingOnlineApplication");
	 * 
	 * }
	 */

	@BeforeMethod
	public void setup(Method result) throws IOException {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		init();

	}

	@Test(priority = 1, enabled = true)
	public void registerUserUsingOnlineApplication() throws InterruptedException, IOException, MessagingException {
		log.info("<===========Started Verifying RegisterUsingOnlineApplication===========> ");
		openAppUrl();
		RegisterPage rp = new RegisterPage(driver);
		rp.registerUser(OR.getProperty("emailID"));
		
	}
	
	@Test(priority = 2, enabled = true)
	public void registerUsingYopmail() throws InterruptedException, IOException, MessagingException {
		log.info("<===========Started Verifying RegisterUsingOnlineApplication===========> ");
		openUserEmailUrl();
		RegisterPage rp = new RegisterPage(driver);
		rp.accessYopmailForOnlineRegister(OR.getProperty("emailID"));
		rp.createAnAccount(OR.getProperty("firstName"), OR.getProperty("lastName"),
				OR.getProperty("createAccountPassword"), OR.getProperty("createAccountCPassword"),
				OR.getProperty("mobileNumber")); 
		
		rp.subscriptionPlans();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		get_result(result);

	}

}
