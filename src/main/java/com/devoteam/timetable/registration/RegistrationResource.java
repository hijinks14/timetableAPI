package com.devoteam.timetable.registration;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@RestController
public class RegistrationResource {

	@Autowired
	private RegistrationRepository registrationRepository;

	@PostMapping("/registrationPost")
	public ResponseEntity<Object> createProject(@Valid @RequestBody Registration registration, Errors errors) {
		
		Registration savedRegistration = registrationRepository.save(registration);
				
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(savedRegistration.getId()).toUri();

				return ResponseEntity.created(location).build();

	}

	@PostMapping("/registrationGetAll")
	List<Registration> all() {
		return registrationRepository.findAll();
	}

	@PostMapping("/registrationGet")
	Optional<Registration> one(@RequestBody Integer id) {

		return registrationRepository.findById(id);
	}
}