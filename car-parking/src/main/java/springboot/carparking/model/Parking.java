package springboot.carparking.model;

import java.time.LocalDateTime;

public class Parking {
	
	
	private String id;
	private String license;
	private String state;
	private String model;
	private String color;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;
	private Double bill;

	public Parking(String id, String license, String state, String model, String color) {
		super();
		this.id = id;
		this.license = license;
		this.state = state;
		this.model = model;
		this.color = color;
	}

//	Constructor without fields:	
	public Parking() {
		super();
	}

	// Getters and Setters:
	public String getId() {
		return id;
	}

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

	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public LocalDateTime getExitDate() {
		return exitDate;
	}

	public Double getBill() {
		return bill;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public void setExitDate(LocalDateTime exitDate) {
		this.exitDate = exitDate;
	}

	public void setBill(Double bill) {
		this.bill = bill;
	}

}
