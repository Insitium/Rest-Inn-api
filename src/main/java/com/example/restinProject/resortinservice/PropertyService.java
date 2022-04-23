package com.example.restinProject.resortinservice;

import java.util.List;
import java.util.ArrayList;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restinProject.repository.PropertyDao;
import com.example.restinProject.entity.Property;

@Service
public class PropertyService {
	@Autowired
	PropertyDao propertyDao;

	ArrayList<String> uniqueChecker = new ArrayList<>();

	
	public List<Property> getAllProperties(){
		return propertyDao.findAll();
	}
	
	public Property getProperty(String propertyId) {
		Optional<Property> property= propertyDao.findById(propertyId);
		if(property.isPresent()) {
			return property.get();
		}else {
			return null;
		}
	}
	
	public ArrayList<Property> getUniqueProperty(){
		ArrayList<Property> uniqueProperties = new ArrayList<>();

		for(Property p:propertyDao.findAll()) {
			if(uniqueChecker.contains(p.getType())==false) {
				uniqueProperties.add(p);
				uniqueChecker.add(p.getType());
			}
		}
		if(uniqueProperties!=null) {
			return uniqueProperties;
		}
		return null;
	}
public ArrayList<Property> getBestsellers() {
		
		ArrayList<Property> bestsellers = new ArrayList<>();
		
		for(Property p:propertyDao.findAll())
		{
			if( p.getBestSeller())
			{
				bestsellers.add(p);
			}
		}
		
		 if(bestsellers!=null)
			 return bestsellers;
		 else
			 return null;
		
	}

	public void deleteProperty(String propertyId) {
		propertyDao.deleteById(propertyId);
	}
	public Property createProperty(Property property) {
		return propertyDao.save(property);
	}
	public List<Property> getPropertyByTitle(String title){
		List<Property> property = new ArrayList<>();
		for(Property p: propertyDao.findAll())
		{
			if(p.getTitle().equals(title) || p.getType().equals(title)) {
				property.add(p);
			}
		}
		return property;
	}
}

