package com.example.carapi.service;

import com.example.carapi.model.Vehicle;
import com.example.carapi.repository.VehicleRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findAllVehicles(){
        return vehicleRepository.findAll();
    };

    public ResponseEntity<String> createVehicle(Vehicle vehicle){

        Vehicle v = vehicleRepository.findVehicleByVINAndINO(vehicle.getVin(), vehicle.getIno());
        if(v == null){
            vehicleRepository.save(vehicle);
            return new ResponseEntity<>("Vehicle added", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Vehicle already exists", HttpStatus.CONFLICT);
        }
    }

    public Double findCost(String VIN, String INO){
        return vehicleRepository.findCostByVINAndINO(VIN, INO);
    }

    public ResponseEntity<String> deleteVehicle(Integer id){

        if(vehicleRepository.findById(id).isPresent()){
            vehicleRepository.deleteById(id);
            return new ResponseEntity<>("Vehicle deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Vehicle was not found", HttpStatus.NOT_FOUND);
        }
    }
}
