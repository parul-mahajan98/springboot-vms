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
import com.springboot.jpa.model.Vehicle;
import com.springboot.jpa.repository.VehicleRepository;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class VehicleController {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@GetMapping("/vehicles")
	public List<Vehicle> getAllVehicles(){
		return vehicleRepository.findAll();
	}
	
	@PostMapping("/vehicles")
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	
	@GetMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable int id) {
		Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicle does not exist with id : "+id));
		return ResponseEntity.ok(vehicle);
	}
	
	@PutMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable int id,@RequestBody Vehicle vehicleDetails){
		Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicle does not exist with id : "+id));
        vehicle.setVehicle_Name(vehicleDetails.getVehicle_Name());
        vehicle.setVehicle_Model(vehicleDetails.getVehicle_Model());
        vehicle.setVehicle_Year(vehicleDetails.getVehicle_Year());
        vehicle.setChassis_Number(vehicleDetails.getChassis_Number());
        vehicle.setRegistration_Number(vehicleDetails.getRegistration_Number());
        vehicle.setFuel_Type(vehicleDetails.getFuel_Type());
		Vehicle updatedVehicle = vehicleRepository.save(vehicle);
		return ResponseEntity.ok(updatedVehicle);
	}
	
	@DeleteMapping("/vehicles/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteVehicle(@PathVariable int id){
		Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicle does not exist with id : "+id));

		vehicleRepository.delete(vehicle);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
