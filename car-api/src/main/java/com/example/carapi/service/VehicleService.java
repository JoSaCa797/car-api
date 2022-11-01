package com.example.carapi.service;

import com.example.carapi.model.Vehicle;
import com.example.carapi.repository.VehicleRepository;
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

    public void createVehicle(Vehicle vehicle){
        Vehicle v = vehicleRepository.findVehicleByVINAndINO(vehicle.getVIN(), vehicle.getINO());
        if(v == null){
            vehicleRepository.save(vehicle);
        }
    }

    public Double findCost(String VIN, String INO){
        return vehicleRepository.findCostByVINAndINO(VIN, INO);
    }
}
