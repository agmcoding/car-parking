package springboot.carparking.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) /* This is for not showing null values in the web application. */
public class ParkingDTO {

	/*
	 * "Why DTO is used in Java?: The DTO is mainly used for reducing the number of
	 * expensive remote calls. In order to convert data between the DTO and any
	 * entity objects, the assembler object was defined, but now we are using
	 * mappers for converting data." - Source: www.javatpoint.com > dto-java
	 */

	private String id;
	private String license;
	private String state;
	private String model;
	private String color;
	@JsonFormat(pattern = "yyyy/mm/dd hh:mm")
	private LocalDateTime entryDate;
	@JsonFormat(pattern = "yyyy/mm/dd hh:mm")
	private LocalDateTime exitDate;
	private Double bill;

//	Getters and Setters:	
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
