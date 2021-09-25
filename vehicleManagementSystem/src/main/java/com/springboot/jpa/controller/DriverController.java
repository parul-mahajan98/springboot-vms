package com.springboot.jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.exception.ResourceNotFoundException;
import com.springboot.jpa.model.Driver;

import com.springboot.jpa.repository.DriverRepository;
@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class DriverController {

	@Autowired
	private DriverRepository driverRepository;
	
	@GetMapping("/drivers")
	public List<Driver> getAllDrivers(){
		return driverRepository.findAll();
	}
	
	@PostMapping("/drivers")
	public Driver createDriver(@RequestBody Driver driver) {
		return driverRepository.save(driver);
	}
	
	@GetMapping("/drivers/{id}")
	public ResponseEntity<Driver> getDriverById(@PathVariable int id) {
		Driver driver = driverRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Driver does not exist with id : "+id));
		return ResponseEntity.ok(driver);
	}
	
	@PutMapping("/drivers/{id}")
	public ResponseEntity<Driver> updateDriver(@PathVariable int id,@RequestBody Driver driverDetails){
		Driver driver = driverRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Driver does not exist with id : "+id));
        driver.setFirstname(driverDetails.getFirstname());
        driver.setLastname(driverDetails.getLastname());
        driver.setDob(driverDetails.getDob());
        driver.setAddress(driverDetails.getAddress());
       
        driver.setLicense_Number(driverDetails.getLicense_Number());
        driver.setLicense_expiry_date(driverDetails.getLicense_expiry_date());
		Driver updatedDriver = driverRepository.save(driver);
		return ResponseEntity.ok(updatedDriver);
	}
	
	@DeleteMapping("/drivers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDriver(@PathVariable int id){
		Driver driver = driverRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Driver does not exist with id : "+id));

		driverRepository.delete(driver);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
