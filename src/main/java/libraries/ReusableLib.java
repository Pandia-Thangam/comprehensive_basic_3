package libraries;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableLib {

	public static WebDriver driver;

	public static void openApplication() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.get("https://www.automationanywhere.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	public static void acceptCookiesIfShown() {
		try {
			if (driver.findElement(By.id("onetrust-accept-btn-handler")).isDisplayed()) {
				driver.findElement(By.id("onetrust-accept-btn-handler")).click();
			}
		} catch (Exception e) {
			System.out.println("Error with acession Accept cookies element");
		}
	}

	public static void quitDriver() {
		driver.quit();
	}

	public static void clickElement(String ele) {
		try {
			driver.findElement(By.xpath(ele)).click();
		} catch (Exception e) {
			System.out.println("Element not found");
		}
	}

	public static void mouseHover(String ele) {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath(ele))).build().perform();
			;
		} catch (Exception e) {
			System.out.println("Element not found");
		}
	}

	public static void explicitWait(String ele) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(ele)));
		} catch (Exception e) {
			System.out.println("Wait element not found");
		}
	}

	public static String getURLOfPage() {
		String URL = null;
		try {
			URL = driver.getCurrentUrl();
		} catch (Exception e) {
			System.out.println("Could not retrieve the URL of the page");
		}

		return URL;
	}

	public static String getTextFromElemeent(String ele) {
		String elementString = null;
		try {
			return driver.findElement(By.xpath(ele)).getText();
		} catch (Exception e) {
			System.out.println("Element not found");
		}
		return elementString;
	}

}
