package springboot.carparking.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	private ModelMapper modelMapper;
	
	@Autowired
	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public ParkingDTO toParkingDTO(Parking parking) {
		return modelMapper.map(parking, ParkingDTO.class);
	}
	
	public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
		return parkingList.stream().map(this::toParkingDTO).collect(Collectors.toList());
	}

	public Parking toParking(ParkingDTO dto) {
		return modelMapper.map(dto, Parking.class);
	}

	public Parking toParkingCreate(ParkingCreateDTO dto) {
		return modelMapper.map(dto, Parking.class);
	}

	
	
}
