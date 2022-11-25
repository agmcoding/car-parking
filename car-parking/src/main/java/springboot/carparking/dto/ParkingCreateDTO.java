package springboot.carparking.dto;

public class ParkingCreateDTO {

	private String license;
	private String state;
	private String model;
	private String color;

	public String getLicense() {
		return license;
	}

	public String getState() {
		return state;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setColor(String color) {
		this.color = color;
	}

}