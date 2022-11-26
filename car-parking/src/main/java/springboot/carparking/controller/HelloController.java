package springboot.carparking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

	@GetMapping
	public String hello() {
		return " Hello World! "
				+ "This is the Home page =D , "
				+ "Send some requests by the address /parking ";
	}
	
}
