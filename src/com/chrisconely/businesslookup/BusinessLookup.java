package com.chrisconely.businesslookup;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

			Business bus = new Business(business.get("name").toString(),
					business.get("id").toString());
			
			list.insertAtEnd(bus);
		}
		
		list.traverse();
	}
}