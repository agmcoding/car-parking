package springboot.carparking.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*In addition to GraalVM native image support, this release also completes our 
 *migration to JakartaEE 9 and our baseline upgrade to Java 17. 
 * @See: https://spring.io/blog/2022/10/20/spring-boot-3-0-0-rc1-available-now#:~:text=This%20is%20our%20first%20release,changes%20if%20we%20find%20issues.
*/

@Component
@Entity
public class Parking {
	
	@Id
	@Column( length = 100 )
	private String id;
	
	@Column( nullable = false , length = 10)
	private String license;
	
	@Column( nullable = false , length = 50)
	private String state;
	
	@Column( nullable = false , length = 30)
	private String model;
	
	@Column( nullable = false , length = 30)
	private String color;
	
	@Column( nullable = false )
	private LocalDateTime entryDate;
	
	@Column()
	private LocalDateTime exitDate;
	
	@Column
	private Double bill;

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
