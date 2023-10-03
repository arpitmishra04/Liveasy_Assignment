package com.Assignment.Livesy.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Assignment.Livesy.entities.Load;
import com.Assignment.Livesy.services.LoadService;


@RestController
public class MyControllers {

	
	@Autowired
	 LoadService load_service;
	
	 @PostMapping("/load")
	    public String addLoad(@RequestBody Load load) {
	       
	        return load_service.addLoad(load);
	    }
	 
	 @GetMapping("/load")
	    public List<Load> getLoadsByShipperId(@RequestParam String shipperId) {
	        return load_service.getLoadsByShipperId(shipperId);
	    }
	 
	 @GetMapping("/load/{loadId}")
	    public Optional<Load> getLoadById(@PathVariable UUID loadId) {
	        return load_service.getLoadById(loadId);
	    }
	 
	 @PutMapping("/load/{loadId}")
	    public String updateLoad(@PathVariable UUID loadId, @RequestBody Load updatedLoad) {
	        
		 return load_service.updateLoad(loadId, updatedLoad);
	      
	    }
	 @DeleteMapping("/load/{loadId}")
	    public String deleteLoad(@PathVariable UUID loadId) {
	        
		 return load_service.deleteLoad(loadId);
	    }

}
