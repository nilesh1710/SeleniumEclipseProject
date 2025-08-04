package TestSuite;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.KredSafe.TestBase.TestBase;
import com.KredSafe.User.ClientLoginPage;
import com.KredSafe.User.RegisterPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC26_VerifyStepstoComplete extends TestBase {

	public static final Logger log = Logger.getLogger(TC26_VerifyStepstoComplete.class.getName());
	private static final String By = null;

	//@BeforeClass
	//public static void startTest() {

	//	test = extent.startTest("TC26_VerifyStepstoComplete");

	//}

	@BeforeMethod
	public void setup(Method result) throws IOException {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		init();

	}

	@Test(priority = 1, enabled = true)
	public void stepsToComplete() throws IOException, InterruptedException, AWTException {

		log.info("<=========== Started Verifying stepsToComplete ===========> ");
		openAppUrl();
		ClientLoginPage clp = new ClientLoginPage(driver);
		clp.clientSignIn("ts053376@yopmail.com", "Nilesh@2025");
		clp.stepsToComplete("173556789");
	}
	@Test(priority = 2, enabled = true)
	public void stepsToCompleteAll() throws IOException, InterruptedException, AWTException {

		log.info("<=========== Started Verifying stepsToComplete ===========> ");
		openAppUrl();
		ClientLoginPage clp = new ClientLoginPage(driver);
		clp.clientSignIn("ts053376@yopmail.com", "Nilesh@2025");
		clp.stepsToComplete("173556789");
	}
	@AfterMethod
	public void afterMethod(ITestResult result) {
		get_result(result);

	}

}

