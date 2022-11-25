package springboot.carparking.controller;

import org.springframework.http.MediaType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import springboot.carparking.dto.ParkingCreateDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingControllerTest {

	@LocalServerPort
	private int randomPort;

	@BeforeEach
	public void setUpTest() {
		System.out.println(randomPort);
		RestAssured.port = randomPort;
	}

	@Test
	void whenFindAllThenCheckResult() {

		var createDTO = new ParkingCreateDTO();
		createDTO.setColor("Yellow");
		createDTO.setLicense("WRT-5555");
		createDTO.setModel("Model");
		createDTO.setState("ST");

		RestAssured.given().when().get("/parking").then().statusCode(HttpStatus.OK.value());
	}

	@Test
	void whenCreateThenCheckIsCreated() {

		var createDTO = new ParkingCreateDTO();
		createDTO.setColor("Yellow");
		createDTO.setLicense("WRT-5555");
		createDTO.setModel("Model");
		createDTO.setState("ST");

		RestAssured.given().when().contentType(MediaType.APPLICATION_JSON_VALUE).body(createDTO).post("/parking").then()
				.statusCode(HttpStatus.CREATED.value()).body("license", Matchers.equalTo("WRT-5555"))
				.body("color", Matchers.equalTo("Yellow"));
	}

}
