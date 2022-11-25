package springboot.carparking.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import springboot.carparking.dto.ParkingCreateDTO;
import springboot.carparking.dto.ParkingDTO;
import springboot.carparking.model.Parking;

@Component
public class ParkingMapper {

	/*
	 * "ModelMapper uses conventions to determine how properties and values are
	 * mapped to each other. Users can create custom conventions, or use one of the
	 * supplied conventions."
	 * - Source: modelmapper.org
	 */
	
	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	public ParkingDTO toParkingDTO(Parking parking) {
		return MODEL_MAPPER.map(parking, ParkingDTO.class);
	}
	
	public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
		return parkingList.stream().map(this::toParkingDTO).collect(Collectors.toList());
	}

	public Parking toParking(ParkingDTO dto) {
		return MODEL_MAPPER.map(dto, Parking.class);
	}

	public Parking toParkingCreate(ParkingCreateDTO dto) {
		return MODEL_MAPPER.map(dto, Parking.class);
	}

	
	
}
