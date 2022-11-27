package springboot.carparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.carparking.model.Parking;

public interface ParkingRepository extends JpaRepository<Parking, String>{

}
