package main.model;

public class Business {
	
	private String name;
	private String id;
	
	public Business(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getID() {
		return id;
	}
	
	public String toString() {
		return("Business ID:   " + id + "\n" + "Business name: " + name);
	}
}
