package com.example.carapi;

import com.example.carapi.model.Vehicle;
import com.example.carapi.service.VehicleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarApiApplication implements CommandLineRunner {

	private final VehicleService vehicleService;

	public CarApiApplication(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Vehicle v1 = new Vehicle("XYZ", "ABC", "LMN", 500.00);
		Vehicle v2 = new Vehicle("UVW", "DEF", "OPQ", 1000.00);
		Vehicle v3 = new Vehicle("RST", "GHI", "XYZ", 1500.00);
		Vehicle[] vehicles = {v1, v2, v3};

		for (Vehicle v : vehicles){
			vehicleService.createVehicle(v);
		}
	}
}
