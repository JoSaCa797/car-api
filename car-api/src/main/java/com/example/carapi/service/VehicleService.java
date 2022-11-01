package com.example.carapi.service;

import com.example.carapi.model.Vehicle;
import com.example.carapi.repository.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

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
