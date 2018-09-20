package com.devoteam.timetable.typing;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoteam.timetable.typing.Typing;

@Repository
public interface TypingRepository extends JpaRepository<Typing, String>{
	Typing findByCode(String code);

	Optional<Typing> findById(Integer id);
}