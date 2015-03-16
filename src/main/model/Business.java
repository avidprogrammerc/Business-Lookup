package main.model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class wraps the Yelp business result into an object
 * 
 * @author Chris Conley
 *
 */
public class Business {

	private JSONObject jsonObject;

	public Business(String jsonData) throws ParseException {
		jsonObject = (JSONObject) new JSONParser().parse(jsonData);
	}
	
	public String getId() {
		if (jsonObject.get("id") != null) {
			return jsonObject.get("id").toString();
		} else {
			return null;
		}
	}
	
	public boolean getIsClaimed() {
		if (jsonObject.get("is_claimed") != null) {
			return (jsonObject.get("is_claimed").toString().equals("true"));
		} else {
			return false;
		}
	}
	
	public boolean getIsClosed() {
		if (jsonObject.get("is_closed") != null) {
			return (jsonObject.get("is_closed").toString().equals("true"));
		} else {
			return false;
		}
	}

	public String getName() {
		if (jsonObject.get("name") != null) {
			return jsonObject.get("name").toString();
		} else {
			return null;
		}
	}
	
	public String getImageURL() {
		if (jsonObject.get("image_url") != null) {
			return jsonObject.get("image_url").toString();
		} else {
			return null;
		}
	}
	
	public String getURL() {
		if (jsonObject.get("url") != null) {
			return jsonObject.get("url").toString();
		} else {
			return null;
		}
	}
	
	public String getMobileURL() {
		if (jsonObject.get("mobile_url") != null) {
			return jsonObject.get("mobile_url").toString();
		} else {
			return null;
		}
	}
	
	public String getPhoneNumber() {
		if (jsonObject.get("display_phone") != null) {
			return jsonObject.get("display_phone").toString();
		} else {
			return null;
		}
	}
	
	public int getReviewCount() {
		if (jsonObject.get("review_count") != null) {
			return Integer.parseInt(jsonObject.get("review_count").toString());
		} else {
			return -1;
		}
	}
	
	public double getRating() {
		if (jsonObject.get("rating") != null) {
			return Double.parseDouble(jsonObject.get("rating").toString());
		} else {
			return -1;
		}
	}
	
	public String getSnippetText() {
		if (jsonObject.get("snippet_text") != null) {
			return jsonObject.get("snippet_text").toString();
		} else {
			return null;
		}
	}
	
	public String toString() {
		return ("id: " + getId() + "\n" +
				"is_claimed: " + getIsClaimed() + "\n" +
				"is_closed: " + getIsClosed() + "\n" +
				"name: " + getName() + "\n" +
				"image URL: " + getImageURL() + "\n" +
				"url: " + getURL() + "\n" +
				"mobile_url: " + getMobileURL() + "\n" +
				"phone number: " + getPhoneNumber() + "\n" +
				"number of reviews: " + getReviewCount() + "\n" +
				"rating: " + getRating() + "\n" +
				"snippet text: " + getSnippetText());
	}
}
