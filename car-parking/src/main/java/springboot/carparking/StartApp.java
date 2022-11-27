package springboot.carparking;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import springboot.carparking.model.Parking;
import springboot.carparking.repository.ParkingRepository;
import springboot.carparking.service.ParkingService;

@Component
public class StartApp implements CommandLineRunner{

	ParkingRepository repository;
	ParkingService service;
	
	@Autowired
	public void setRepository(ParkingRepository repository) {
		this.repository = repository;
	}
	
	@Autowired
	public void setService(ParkingService service) {
		this.service = service;
	}



	@Override
	public void run(String... args) throws Exception {
		
			String id1 = service.getUUID();
			Parking car1 = new Parking();
			car1.setId(id1); car1.setLicense("HLM-1234"); car1.setState("SP"); 
			car1.setModel("TopModel"); car1.setColor("Silver"); 
			car1.setEntryDate(LocalDateTime.now());
			repository.save(car1);
			
			String id2 = service.getUUID();
			Parking car2 = new Parking();
			car2.setId(id2); car2.setLicense("YZM-5432"); car2.setState("OL");
			car2.setModel("RobustModel"); car2.setColor("Red");
			car2.setEntryDate(LocalDateTime.now());
			car2.setEntryDate(LocalDateTime.now());
			repository.save(car2);
			
	}

}
