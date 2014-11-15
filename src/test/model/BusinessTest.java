package test.model;

import org.json.simple.parser.ParseException;

import main.model.Business;
import student.TestCase;

public class BusinessTest extends TestCase {
	private String jsonData;
	private Business business;

	public void setUp() throws ParseException {
		jsonData = "{"
				 +   "\"name\": \"Dummy business\","
				 +   "\"image_url\": \"http://csconley.com\""
				 + "}";
		business = new Business(jsonData);
	}

	public void testGetName() {
		assertEquals("Dummy business", business.getName());
	}
	
	public void testGetImageURL() {
		assertEquals("http://csconley.com", business.getImageURL());
	}
}
