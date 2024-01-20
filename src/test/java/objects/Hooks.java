package objects;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import libraries.ReusableLib;

public class Hooks extends ReusableLib{
	@BeforeTest
	public static void before() throws InterruptedException {
		openApplication();
	}
	
	@AfterTest
	public static void after() {
		quitDriver();
	}
}
