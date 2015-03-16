package test.model;

import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import main.model.Business;
import student.TestCase;

public class BusinessTest extends TestCase {
	private String jsonData;
	private Business business;

	public void setUp() throws ParseException {
		jsonData = "{"
				 +   "\"id\": \"dummy_business\""
				 +   "\"is_claimed\": \"true\""
				 +   "\"is_closed\": \"true\""
				 +   "\"name\": \"Dummy business\""
				 +   "\"image_url\": \"http://csconley.com/headshot.jpg\""
				 +   "\"url\": \"http://csconley.com\""
				 +   "\"mobile_url\": \"http://mobile.csconley.com\""
				 +   "\"display_phone\": \"+1-800-999-9999\""
				 +   "\"review_count\": \"20\""
				 +   "\"categories\": ["
				 +      "["
				 +         "\"Web\","
				 +         "\"Internet\""
				 +      "],"
				 +      "["
				 +         "\"App\","
				 +         "\"Application\""
				 +      "]"
				 +   "]"
				 +   "\"rating\": \"3.14\","
				 +   "\"snippet_text\": \"Text about the business will be here.\""
				 + "}";
		business = new Business(jsonData);
	}
	
	public void testGetId() {
		assertEquals("dummy_business", business.getId());
	}
	
	public void testGetIsClaimed() {
		assertTrue(business.getIsClaimed());
	}
	
	public void testGetIsClosed() {
		assertTrue(business.getIsClosed());
	}

	public void testGetName() {
		assertEquals("Dummy business", business.getName());
	}
	
	public void testGetImageURL() {
		assertEquals("http://csconley.com/headshot.jpg", business.getImageURL());
	}
	
	public void testGetURL() {
		assertEquals("http://csconley.com", business.getURL());
	}
	
	public void testGetMobileURL() {
		assertEquals("http://mobile.csconley.com", business.getMobileURL());
	}
	
	public void testGetPhoneNumber() {
		assertEquals("+1-800-999-9999", business.getPhoneNumber());
	}
	
	public void testGetReviewCount() {
		assertEquals(20, business.getReviewCount());
	}
	
	public void testGetCategories() {
		ArrayList<String> mock = new ArrayList<String>();
		mock.add("Web");
		mock.add("App");
		assertEquals(mock, business.getCategories());
	}
	
	public void testGetRating() {
		assertEquals(3.14, business.getRating(), 0.00000001);
	}
	
	public void testGetSnippetTExt() {
		assertEquals("Text about the business will be here.", business.getSnippetText());
	}
}
