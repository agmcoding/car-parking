package springboot.carparking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.carparking.dto.ParkingCreateDTO;
import springboot.carparking.dto.ParkingDTO;
import springboot.carparking.mapper.ParkingMapper;
import springboot.carparking.model.Parking;
import springboot.carparking.service.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingController {

	private final ParkingService PARKING_SERVICE;
	private final ParkingMapper PARKING_MAPPER;
	
	public ParkingController(ParkingService PARKING_SERVICE, ParkingMapper PARKING_MAPPER) {
		super();
		this.PARKING_SERVICE = PARKING_SERVICE;
		this.PARKING_MAPPER = PARKING_MAPPER;
	}

	
	@GetMapping
	public ResponseEntity<List<ParkingDTO>> findAll() {
		List<Parking> parkingList = PARKING_SERVICE.findAll();
		/* This avoids delivering objects directly from the repository/database: */		
		List<ParkingDTO> result = PARKING_MAPPER.toParkingDTOList(parkingList);
		return ResponseEntity.ok(result);
	}


	
	@GetMapping("/{id}")
	public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
		Parking parking = PARKING_SERVICE.findById(id);
		/* This bellow avoids delivering objects directly from the repository/database: */		
		ParkingDTO result = PARKING_MAPPER.toParkingDTO(parking);
		return ResponseEntity.ok(result);
	}
	
	
	
	@PostMapping
	public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {
	Parking parkingCreate = PARKING_MAPPER.toParkingCreate(dto);
	Parking parking = PARKING_SERVICE.create(parkingCreate);
	ParkingDTO result = PARKING_MAPPER.toParkingDTO(parking);
	return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO dto) {
		Parking parkingUpdate = PARKING_MAPPER.toParkingCreate(dto);
		Parking parking = PARKING_SERVICE.update(id, parkingUpdate);
		ParkingDTO result = PARKING_MAPPER.toParkingDTO(parking);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
	PARKING_SERVICE.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("/{id}/exit")
	public ResponseEntity<ParkingDTO> exit(@PathVariable String id) {
		Parking parking = PARKING_SERVICE.exit(id);
		return ResponseEntity.ok(PARKING_MAPPER.toParkingDTO(parking));
	}
	
}
