package com.example.restinProject.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Property")
public class Property {

	@Id
	private String id;
	private String img;
	private String title;
	private String price;
	private String type;
	private String rules;
	private String amenities;
	private String location;
	private Boolean bestSeller;
	public String getId() {
		return id;
	}
	
	
	
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Property(String id, String img, String title, String price, String type, String rules,
			String amenities, String location,Boolean bestSeller) {
		super();
		this.id = id;
		this.img = img;
		this.title = title;
		this.price = price;
		this.type = type;
		this.rules = rules;
		this.amenities = amenities;
		this.location = location;
		this.bestSeller = bestSeller;
	}






	public String getRules() {
		return rules;
	}



	public void setRules(String rules) {
		this.rules = rules;
	}



	public void setId(String id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getAmenities() {
		return amenities;
	}
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}



	public Boolean getBestSeller() {
		return bestSeller;
	}



	public void setBestSeller(Boolean bestSeller) {
		this.bestSeller = bestSeller;
	}

	


	
}

