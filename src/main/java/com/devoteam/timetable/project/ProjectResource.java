package com.devoteam.timetable.project;

import java.net.URI;
import java.util.Optional;
import java.util.List;

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
public class ProjectResource {

	@Autowired
	private ProjectRepository projectRepository;

	@PostMapping("/projectPost")
	public ResponseEntity<Object> createProject(@RequestBody Project project, Errors errors) {
		
				Project savedProject = projectRepository.save(project);
				
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(savedProject.getId()).toUri();

				return ResponseEntity.created(location).build();

	}

	@PostMapping("/projectGetAll")
	List<Project> all() {
		return projectRepository.findAll();
	}

	@PostMapping("/projectGet")
	Optional<Project> one(@RequestBody Integer id) {

		return projectRepository.findById(id);
	}
}
