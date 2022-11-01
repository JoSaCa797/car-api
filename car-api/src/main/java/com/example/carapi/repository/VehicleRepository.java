package com.example.carapi.repository;

import com.example.carapi.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query(value = "SELECT v FROM Vehicle v WHERE v.vin = ?1 and v.ino = ?2")
    Vehicle findVehicleByVINAndINO(String VIN, String INO);

    @Query(value = "SELECT Cost FROM Vehicle v WHERE v.vin = ?1 and v.ino = ?2", nativeQuery = true)
    Double findCostByVINAndINO(String VIN, String INO);

}
