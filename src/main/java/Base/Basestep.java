package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public  class Basestep 
{
	public static WebDriver driver;
	@Parameters({ "browser", "URL" })
	
	@BeforeTest(alwaysRun=true)
	public static void openBrowser(String browser, String URL) {
		try {
			if (browser.equals("Firefox")) 
			{
				//System.setProperty("webdriver.gecko.driver", "D:\\workspace\\aceturtle_Project\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.print("url"+URL);
				driver.get(URL);
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","D:\\workspace\\aceturtle_Project\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.get(URL);
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver","D:\\workspace\\aceturtle_Project\\drivers\\chromeLastetdriver\\IEDriverServer.exe");
				
				driver = new InternetExplorerDriver();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				
				driver.get(URL);
			}
			driver.manage().window().maximize();
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}
}