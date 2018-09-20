package com.devoteam.timetable.registration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.Constraint;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "registrations")

public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String projectCode;
	private Date logDate;
	@NotNull(message = "You must enter an amount of hours")
	@Positive
	private BigDecimal hours;
	private String note;
	private String typingCode;
	
	@Column
	@CreationTimestamp
	private LocalDateTime createDateTime;

	@Column
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Registration() {
		super();
	}

	public Registration(Integer id, Date logDate, BigDecimal hours, String note, String projectCode, String typingCode) {
		super();
		this.id = id;
		this.setLogDate(logDate);
		this.setHours(hours);
		this.setNote(note);
		this.setProjectCode(projectCode);
		this.setTypingCode(typingCode);
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

	public BigDecimal getHours() {
		return hours;
	}

	public void setHours(BigDecimal hours) {
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