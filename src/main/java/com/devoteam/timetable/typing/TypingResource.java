package com.devoteam.timetable.typing;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class TypingResource {

	@Autowired
	private TypingRepository typingRepository;

	@PostMapping("/typingPost")
	public ResponseEntity<Object> createTyping(@RequestBody Typing typing, Errors errors) {
		
		Typing savedTyping = typingRepository.save(typing);
				
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(savedTyping.getId()).toUri();

				return ResponseEntity.created(location).build();

	}

	@PostMapping("/typingGetAll")
	List<Typing> all() {
		return typingRepository.findAll();
	}

	@PostMapping("/typingGet")
	Optional<Typing> one(@RequestBody Integer id) {

		return typingRepository.findById(id);
	}
}
