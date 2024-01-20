package functions;

import libraries.ReusableLib;

public class HomePage extends ReusableLib {

	String productsTab = "//a[text()='Products']";
	String processDiscoveryLink = "//a[@href='/products/process-discovery']";
	String requestDemoButton = "//a[@title='Request demo']";

	public void navigateToProcessDiscovery() {
		mouseHover(productsTab);
		explicitWait(processDiscoveryLink);
		clickElement(processDiscoveryLink);
	}
	
	public void navigateToRequestDemo() {
		clickElement(requestDemoButton);
	}
}