package com.chrisconley.businesslookup;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import main.data_structures.LinkedList;
import main.model.Business;
import main.yelp_api.YelpAPI;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class BusinessLookup {
	public static class YelpAPICLI {
		@Parameter(names = { "-q", "--term" }, description = "Search Query Term")
		public String term = YelpAPI.DEFAULT_TERM;

		@Parameter(names = { "-l", "--location" }, description = "Location to be Queried")
		public String location = YelpAPI.DEFAULT_LOCATION;
	}

	public static void main(String[] args) {
		LinkedList<Business> list = new LinkedList<Business>();

		YelpAPICLI yelpApiCli = new YelpAPICLI();
		new JCommander(yelpApiCli, args);

		YelpAPI yelpApi = new YelpAPI(main.yelp_api.YelpAPI.CONSUMER_KEY,
				main.yelp_api.YelpAPI.CONSUMER_SECRET,
				main.yelp_api.YelpAPI.TOKEN, main.yelp_api.YelpAPI.TOKEN_SECRET);
		JSONArray businesses = YelpAPI.queryAPI(yelpApi, yelpApiCli);

		for (int i = 0; i < businesses.size(); i++) {
			JSONObject business = (JSONObject) businesses.get(i);
			
			String id = "";
			if (business.get("id") != null) {
				id = business.get("id").toString();
			}
			
			JSONObject businessResponse = new JSONObject();
			businessResponse.put(i, yelpApi.searchByBusinessId(id));
			

			boolean is_claimed;
			boolean is_closed;
			String name;
			String image_url;
			String url;
			String mobile_url;
			String display_phone;
			int review_count;
			String[][] categories;
			double distance;
			double rating;
			String rating_img_url;
			String rating_img_url_small;
			String rating_img_url_large;
			String snippet_text;
			String snippet_image_url;
			List display_address;

			if (business.get("name") != null)
				name = business.get("name").toString();
			if (business.get("image_url") != null)
				image_url = business.get("image_url").toString();
			if (business.get("url") != null)
				url = business.get("url").toString();
			if (business.get("display_phone") != null)
				display_phone = business.get("display_phone").toString();
			if (business.get("location") != null) {
				JSONObject json = (JSONObject) JSONValue.parse(business.get(
						"location").toString());
				display_address = (List<String>) json.get("display_address");
			}


			// Business bus = new Business(business.get("id").toString(),
			// business
			// .get("name").toString(), business.get("image_url")
			// .toString(), business.get("url").toString(), business.get(
			// "display_phone").toString(),
			// Integer.parseInt(business.get("review_count")
			// .toString()),
			// Double.parseDouble(business.get("rating").toString()));
			//
			// list.insertAtEnd(bus);
		}

		list.traverse();
	}
}