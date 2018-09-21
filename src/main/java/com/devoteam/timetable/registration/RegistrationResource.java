package com.devoteam.timetable.registration;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		return ex.getBindingResult()
			.getAllErrors().stream()
			.map(ObjectError::getDefaultMessage)
			.collect(Collectors.toList());
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