package main.model;

import java.util.NoSuchElementException;

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

	public String getName() {
		if (jsonObject.get("name") != null) {
			return jsonObject.get("name").toString();
		} else {
			throw new NoSuchElementException("This business does not have a name.");
		}
	}
	
	public String getImageURL() {
		if (jsonObject.get("image_url") != null) {
			return jsonObject.get("image_url").toString();
		} else {
			throw new NoSuchElementException("This business does not have an image url.");
		}
	}
	
	public String toString() {
		return ("Name: " + getName() + "\n" +
				"Image URL: " + getImageURL());
	}
}
