package com.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "purpose")
	private String purpose;

	@Column(name = "appointment_date")
	private Date appointmentDate;

	@Column(name = "duration")
	private String duration;

	@Column(name = "status")
	@Enumerated
	private STATUS status;

	@Column(name = "comment")
	private String comment;


	@Column(name = "user_id")
	private String userId;
}