package com.devoteam.timetable.project;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String>{
    Project findByCode(String code);

	Optional<Project> findById(Integer id);
}