package com.devoteam.timetable.registration;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoteam.timetable.project.Project;

public interface RegistrationRepository extends JpaRepository<Registration, Integer>{
	Optional<Registration> findById(Integer id);
}