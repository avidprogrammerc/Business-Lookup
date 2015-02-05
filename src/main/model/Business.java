package main.model;

import java.util.ArrayList;

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
	
	public ArrayList<String> getCategories() {
		if (jsonObject.get("categories") != null) {
			ArrayList<String> retVal = new ArrayList<String>();
			String json = jsonObject.get("categories").toString();
			String[] vals = json.split(",");
			for (int i = 0; i < vals.length; i+=2) {
				retVal.add(vals[i].replaceAll("[^a-zA-Z]", ""));
			}
			return retVal;
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
				"review count: " + getReviewCount() + "\n" +
				"categories: " + getCategories());
	}
}
