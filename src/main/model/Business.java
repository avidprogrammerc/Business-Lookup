package main.model;

/**
 * This class wraps the Yelp business result into an object
 * 
 * @author Chris Conley
 *
 */
public class Business {

	private String id;
	private String name;
	private String image_url;
	private String url;
	private String phone;
	private int review_count;
	private double rating;

	public Business(String id, String name, String image_url, String url,
			String phone, int review_count, double rating) {
		this.id = id;
		this.name = name;
		this.image_url = image_url;
		this.url = url;
		this.phone = phone;
		this.review_count = review_count;
		this.rating = rating;
	}

	public String getID() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getImageURL() {
		return image_url;
	}
	
	public String getURL() {
		return url;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public int getReviewCount() {
		return review_count;
	}
	
	public double getRating() {
		return rating;
	}

	public String toString() {
		return ("Business ID:   " + id + "\n" + "Business name: " + name);
	}
}
