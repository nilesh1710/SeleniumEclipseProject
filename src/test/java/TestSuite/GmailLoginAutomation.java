package TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class GmailLoginAutomation { 
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException   {
        // Set up ChromeDriver using WebDriverManager
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Tiu User/eclipse-workspace/KredSafe/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

        driver.get("https://mail.google.com/");
        
        WebElement emailField = driver.findElement(By.id("identifierId"));
        emailField.sendKeys("hcheeti@tiuconsulting.com");
        
        WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
        nextButton.click();

        Thread.sleep(10000);
        WebElement passwordField = driver.findElement(By.name("Passwd"));
        passwordField.sendKeys("sTGV@8777*");
        nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
        nextButton.click();
        
        Thread.sleep(20000);
        WebElement emailKredSafe = driver.findElement(By.xpath("//*[@id=\":1v\"]"));
        emailKredSafe.click();
        
        Thread.sleep(10000);
        
        
        
        WebElement emailsKrdeSafe = driver.findElement(By.xpath("//div[1]/div[2]/div/table/tbody/tr[1]/td[2]"));
        emailsKrdeSafe.click();
        
        try {
			if (emailsKrdeSafe.isDisplayed()) {
				emailsKrdeSafe.click();
			}
		} catch (NoSuchElementException e) {

		}
        
        Thread.sleep(5000);
        
        
        WebElement registerButon = driver.findElement(By.xpath("//tbody/tr/td[1]/a[contains(@href,'https://dev.kredsafe.net/register')]"));
        registerButon.click();
      
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        
        // Pause for manual action
        System.out.println("Please perform manual action and press Enter to continue...");
        new java.util.Scanner(System.in).nextLine();
        
        driver.quit();
    }
}