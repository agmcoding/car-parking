package springboot.carparking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.carparking.dto.ParkingCreateDTO;
import springboot.carparking.dto.ParkingDTO;
import springboot.carparking.mapper.ParkingMapper;
import springboot.carparking.model.Parking;
import springboot.carparking.repository.ParkingRepository;

@Service
public class ParkingService {

	private ParkingMapper parkingMapper;
	private ParkingRepository repository;

	@Autowired
	public void setRepository(ParkingRepository repository) {
		this.repository = repository;
	}

	@Autowired
	public void setParkingMapper(ParkingMapper parkingMapper) {
		this.parkingMapper = parkingMapper;
	}

	/*
	 * This UUID class makes a Immutable Universally Unique Identifier (UUID).
	 * Instead of letting the DataBase create an unique identifier, the UUID helps
	 * us in this task. This is safer than taking from the database 
	 * and leaves better performance.
	 */
	public String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	
	public List<ParkingDTO> findAll() {
		List<Parking> parkingList =  repository.findAll();
		/* This avoids delivering objects directly from the repository/database: */
		return parkingMapper.toParkingDTOList(parkingList);
	}

	public ParkingDTO findById(String id) {
		Parking parking = repository.findById(id).get(); //.get(id);
		/* This bellow avoids delivering objects directly from the repository/database: */
		return parkingMapper.toParkingDTO(parking);
	}


	public ParkingDTO create(ParkingCreateDTO dto) {
		Parking parkingCreate = parkingMapper.toParkingCreate(dto);
		var id = getUUID();
		parkingCreate.setId(id);
		parkingCreate.setEntryDate(LocalDateTime.now());
		repository.save(parkingCreate);
		return parkingMapper.toParkingDTO(parkingCreate);
	}


	public void delete(String id) {
		findById(id); // Here it will try to find if that id exists. If not, the method "findById()" will throw an Exception.
		repository.deleteById(id);
	}


	public ParkingDTO update(String id, ParkingCreateDTO dto) {
		Parking parkingUpdate = parkingMapper.toParkingCreate(dto);
		Parking parking = repository.findById(id).get();
		parking.setBill(parkingUpdate.getBill());
		parking.setColor(parkingUpdate.getColor());
		parking.setId(parking.getId()); /* Here the id will still be the same. */
		parking.setLicense(parkingUpdate.getLicense());
		parking.setModel(parkingUpdate.getModel());
		parking.setState(parkingUpdate.getState());
		repository.save(parking);
		return parkingMapper.toParkingDTO(parking);
	}


	public ParkingDTO exit(String id) {
		findById(id); // Checking if the id exists.
		Parking parking = repository.findById(id).get();
		parking.setExitDate(LocalDateTime.now());
		LocalDateTime parkingEntry = parking.getEntryDate();
		LocalDateTime parkingExit = parking.getExitDate();
		
		if ((parkingExit.getHour() - parkingEntry.getHour()) >= 1 ) {
			parking.setBill(15.0);
			repository.save(parking);
		}
		else if (parkingExit.getHour() - parkingEntry.getHour() == 0 ) {
			if ( parkingExit.getMinute() - parkingEntry.getMinute() <= 30 ) {
				parking.setBill(5.0);
				repository.save(parking);
			} else {
				parking.setBill(10.0);
				repository.save(parking);
			}
		}
		return parkingMapper.toParkingDTO(parking);
	}
	

}
