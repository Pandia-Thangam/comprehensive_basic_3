package functions;

import java.util.HashMap;
import java.util.Map;

import libraries.ReusableLib;

public class RequestDemoPage extends ReusableLib {

	String firstNameTxt = "//*[@id='LblFirstName']";
	String lastNameTxt = "//*[@id='LblLastName']";

	
	public Map<String, String> getFirstAndSecondNameLabels() {
		Map<String, String> names = new HashMap<>();
		explicitWait(firstNameTxt);
		names.put("FirstName", getTextFromElemeent(firstNameTxt));
		explicitWait(lastNameTxt);
		names.put("LastName", getTextFromElemeent(lastNameTxt));
		return names; 
	}
}
