package springboot.carparking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import springboot.carparking.service.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingController {

	private ParkingService PARKING_SERVICE;
	
	@Autowired
	public void setPARKING_SERVICE(ParkingService pARKING_SERVICE) {
		PARKING_SERVICE = pARKING_SERVICE;
	}


	@GetMapping
	public ResponseEntity<List<ParkingDTO>> findAll() {
		List<ParkingDTO> result = PARKING_SERVICE.findAll();
		return ResponseEntity.ok(result);
	}


	@GetMapping("/{id}")
	public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
		ParkingDTO result = PARKING_SERVICE.findById(id);
		return ResponseEntity.ok(result);
	}
	
	
	
	@PostMapping
	public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {
	ParkingDTO result = PARKING_SERVICE.create(dto);
	return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO dto) {
		ParkingDTO result = PARKING_SERVICE.update(id, dto);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
	PARKING_SERVICE.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("/{id}/exit")
	public ResponseEntity<ParkingDTO> exit(@PathVariable String id) {
		ParkingDTO parkingDTO = PARKING_SERVICE.exit(id);
		return ResponseEntity.ok(parkingDTO);
	}
	
}
