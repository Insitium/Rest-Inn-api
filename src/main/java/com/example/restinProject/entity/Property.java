package com.example.restinProject.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Property")
public class Property {

	@Id
	private String id;
	private String image;
	private String title;
	private String price;
	private String type;
	private String houseRules;
	private String ameneties;
	private String location;
	private Boolean bestSeller;
	public String getId() {
		return id;
	}
	
	
	
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Property(String id, String image, String title, String price, String type, String houseRules,
			String ameneties, String location,Boolean bestSeller) {
		super();
		this.id = id;
		this.image = image;
		this.title = title;
		this.price = price;
		this.type = type;
		this.houseRules = houseRules;
		this.ameneties = ameneties;
		this.location = location;
		this.bestSeller = bestSeller;
	}



	public void setId(String id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getHouseRules() {
		return houseRules;
	}
	public void setHouseRules(String houseRules) {
		this.houseRules = houseRules;
	}
	public String getAmeneties() {
		return ameneties;
	}
	public void setAmeneties(String ameneties) {
		this.ameneties = ameneties;
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

