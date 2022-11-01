package com.example.carapi.controller;

import com.example.carapi.model.Vehicle;
import com.example.carapi.service.VehicleService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> findAllVehicles(){
        return new ResponseEntity<>(vehicleService.findAllVehicles(), HttpStatus.OK );
    }

    @GetMapping(path = "/cost")
    public ResponseEntity<Object> findVehicleCost(@RequestBody ObjectNode json){
        String VIN = json.get("VIN").asText();
        String INO = json.get("INO").asText();

        if(VIN == null || INO == null){
            return new ResponseEntity<>("Invalid data", HttpStatus.BAD_REQUEST);
        }

        Double cost = vehicleService.findCost(VIN, INO);

        if(cost == null){
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cost, HttpStatus.OK);
        }

    }

    @PostMapping(path = "add")
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle){

        if(vehicle.getVin() == null
                || vehicle.getName() == null
                || vehicle.getIno() == null
                || vehicle.getCost() == null){
            return new ResponseEntity<>("Vehicle could not be added", HttpStatus.BAD_REQUEST);
        }

        return vehicleService.createVehicle(vehicle);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable(name = "id") Integer id){
        return vehicleService.deleteVehicle(id);
    }

}
