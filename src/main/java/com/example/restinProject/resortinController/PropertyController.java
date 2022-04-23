package com.example.restinProject.resortinController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restinProject.entity.Property;
import com.example.restinProject.resortinservice.PropertyService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	
	@GetMapping("/properties")
	public List<Property> getAllProperties(){
		return propertyService.getAllProperties();
	}
	
	
	@GetMapping("/properties/bestSeller")
	public ResponseEntity<ArrayList<Property>> getBestsellerProperties() {
		
		ArrayList<Property> bestsellers = propertyService.getBestsellers();
		
		if (bestsellers!=null) {
			return new ResponseEntity<ArrayList<Property>>(bestsellers, HttpStatus.OK);
		} else {
			return new ResponseEntity<ArrayList<Property>>(bestsellers, HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping("/properties/type")
	public ResponseEntity<ArrayList<Property>> getUniqueProperty(){
		ArrayList<Property> uniqueProperty = propertyService.getBestsellers();
		if(uniqueProperty!=null) {
			return new ResponseEntity<ArrayList<Property>>(uniqueProperty,HttpStatus.OK);
		}else {
			return new ResponseEntity<ArrayList<Property>>(uniqueProperty,HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/properties/{propertyId}")
	public ResponseEntity<Property> getProperty(@PathVariable String propertyId){

	if(propertyService.getProperty(propertyId)!=null) {
		return new ResponseEntity<Property>(propertyService.getProperty(propertyId), HttpStatus.OK);
	}else {
		return new ResponseEntity<Property>(new Property(),HttpStatus.NOT_FOUND);
	}
	}
	@DeleteMapping("/properties/{propertyId}")
	public ResponseEntity<String> deleteProperty(@PathVariable String propertyId){
		Property p = propertyService.getProperty(propertyId);
		if(p!= null) {
			propertyService.deleteProperty(propertyId);
			return new ResponseEntity<String>("property deleted: "+propertyId, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No Property with this Id exists: "+propertyId, HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/properties/title-type/{title}")
	public ResponseEntity<List<Property>> getPropertyByTitle(@PathVariable String title){
		List<Property> p = propertyService.getPropertyByTitle(title);
		if(p!=null) {
			return new ResponseEntity<List<Property>>(p, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Property>>(p, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/properties")
	public ResponseEntity<Property> addProperty(@RequestBody Property property){
		Property p = propertyService.createProperty(property);
		return new ResponseEntity<Property>(p, HttpStatus.CREATED);
	}
	@PutMapping("/properties/{propertyId}")
	public ResponseEntity<Property> updateProperty(@RequestBody Property property, @PathVariable String propertyId){
		property.setId(propertyId);
		Property p = propertyService.getProperty(propertyId);
		Property prop = propertyService.createProperty(property);
		if(p!=null) {
			return new ResponseEntity<Property>(prop, HttpStatus.OK);
		}else {
			return new ResponseEntity<Property>(prop,HttpStatus.CREATED);
		}
	}
}	
