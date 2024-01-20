package automationAnywhere;

import libraries.ReusableLib;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import functions.HomePage;
import functions.RequestDemoPage;

import java.util.Map;

import org.testng.Assert;

public class automationAnywhereTests extends ReusableLib {

	private static String processDiscoveryURL = "https://www.automationanywhere.com/products/process-discovery";
	private static String requestDemoURL = "https://www.automationanywhere.com/request-live-demo";
	private static String firstNameLabel = "*First Name";
	private static String lastNameLabel = "*Last Name";

	static HomePage homePage = new HomePage();
	static RequestDemoPage requestDemoPage = new RequestDemoPage();
	private static final Logger LOGGER = Logger.getLogger(automationAnywhereTests.class);

	@BeforeMethod
	public static void before() throws InterruptedException {
		openApplication();
		acceptCookiesIfShown();
	}

	@Test
	public static void processDiscoveryTestCase() throws InterruptedException {
		homePage.navigateToProcessDiscovery();
		LOGGER.info("Navigated to Process Discovery page");
		Assert.assertEquals(getURLOfPage(), processDiscoveryURL, "Navigated URL does not match");
		LOGGER.info("Assertion for Process Discovery page URL Passed");
	}

	@Test
	public static void requestDemoTestCase() throws InterruptedException {
		homePage.navigateToRequestDemo();
		LOGGER.info("Navigated to Request Demo page");
		Assert.assertEquals(getURLOfPage(), requestDemoURL, "Navigated URL does not match");
		LOGGER.info("Assertion for Request Demo page URL Passed");
		Map<String, String> firstLastName =  requestDemoPage.getFirstAndSecondNameLabels();
		Assert.assertEquals(firstLastName.get("FirstName"), firstNameLabel, "First Name label is not matching");
		Assert.assertEquals(firstLastName.get("LastName"), lastNameLabel, "Last Name label is not matching");
		LOGGER.info("Assertions for First and Last names labels Passed");
	}

	@AfterMethod
	public static void after() {
		quitDriver();
	}
}