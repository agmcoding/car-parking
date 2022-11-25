package springboot.carparking.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import springboot.carparking.exception.CarNotFoundException;
import springboot.carparking.model.Parking;

@Service
public class ParkingService {

	public static Map<String, Parking> parkingMap = new HashMap<>();
	
	// static method just for creating car objects in the startup.
	static {
		String id1 = getUUID();
		Parking car1 = new Parking(id1, "HLM-1234", "SP", "TopModel", "Silver");
		car1.setEntryDate(LocalDateTime.now());
		parkingMap.put(id1, car1);
		String id2 = getUUID();
		Parking car2 = new Parking(id2, "YZM-5432", "OL", "RobustModel", "Red");
		car2.setEntryDate(LocalDateTime.now());
		parkingMap.put(id2, car2);
	}
	
	/*
	 * This UUID class makes a Immutable Universally Unique Identifier (UUID).
	 * Instead of letting the DataBase create an unique identifier, the UUID helps
	 * us in this task. This is safer than taking from the database 
	 * and leaves better performance.
	 */
	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	
	public List<Parking> findAll() {
		return parkingMap.values().stream().collect(Collectors.toList());
	}

	public Parking findById(String id) {
		Parking parking = parkingMap.get(id);
		if (parking == null) {
			throw new CarNotFoundException(id);
		}
		
		return parking;
	}


	public Parking create(Parking parkingCreate) {
		var id = getUUID();
		parkingCreate.setId(id);
		parkingCreate.setEntryDate(LocalDateTime.now());
		parkingMap.put(id, parkingCreate);
		return parkingCreate;
	}


	public void delete(String id) {
		findById(id); // Here it will try to find if that id exists. If not, the method "findById()" will throw an Exception.
		parkingMap.remove(id);
	}


	public Parking update(String id, Parking parkingUpdate) {
		Parking parking = findById(id);
		parking.setBill(parkingUpdate.getBill());
		parking.setColor(parkingUpdate.getColor());
		parking.setId(parking.getId()); /* Here the id will still be the same. */
		parking.setLicense(parkingUpdate.getLicense());
		parking.setModel(parkingUpdate.getModel());
		parking.setState(parkingUpdate.getState());
		parkingMap.replace(id, parking);
		return parking;
	}


	public Parking exit(String id) {
		findById(id); // Checking if the id exists.
		parkingMap.get(id).setExitDate(LocalDateTime.now());
		LocalDateTime parkingEntry = parkingMap.get(id).getEntryDate();
		LocalDateTime parkingExit = parkingMap.get(id).getExitDate();
		
		if ((parkingExit.getHour() - parkingEntry.getHour()) >= 1 ) {
			parkingMap.get(id).setBill(15.0);
		}
		else if (parkingExit.getHour() - parkingEntry.getHour() == 0 ) {
			if ( parkingExit.getMinute() - parkingEntry.getMinute() <= 30 ) {
				parkingMap.get(id).setBill(5.0);
			} else {
				parkingMap.get(id).setBill(10.0);
			}
		}
		return parkingMap.get(id);
	}
	

}