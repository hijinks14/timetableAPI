package com.devoteam.timetable.registration;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.devoteam.timetable.RegistrationValidators.HourFormat;

@Entity
@Table(name = "registrations")
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String projectCode;
	@NotNull(message = "You must enter a date to start logging")
	private Date logDate;
	private String note;
	@Positive
	@HourFormat
	private Double hours;
	@NotNull(message = "You must enter a type of hours")
	private String typingCode;
	
	@Column
	@CreationTimestamp
	private LocalDateTime createDateTime;

	@Column
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	@AssertTrue(message="If hours are entered, a note must be provided")
	private boolean isValid() {
		if (this.note == "" ^ this.hours == null) {
		    // unacceptable input
		    return false;
		}
	    return true;
	}

	public Registration() {
		super();
	}

	public Registration(Integer id, Date logDate, Double hours, String note, String projectCode, String typingCode) {
		super();
		this.id = id;
		this.setLogDate(logDate);
		this.setHours(hours);
		this.setNote(note);
		this.setProjectCode(projectCode);
		this.setTypingCode(typingCode);
	}
	
	public Registration findById(Integer id) {
		Registration foundRegistration = this;
		return foundRegistration;		
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTypingCode() {
		return typingCode;
	}

	public void setTypingCode(String typingCode) {
		this.typingCode = typingCode;
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return true;
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
