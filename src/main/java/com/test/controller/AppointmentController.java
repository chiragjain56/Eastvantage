package com.test.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Appointment;
import com.test.exceptions.AppointmentException;
import com.test.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	// getting all appointments
	@GetMapping("/all")
	public ResponseEntity<?> getAllAppointments() {
		return new ResponseEntity<>(appointmentService.getAllAppointments(), HttpStatus.OK);
	}

	// getting by Id
	@GetMapping
	public ResponseEntity<?> byId(@RequestParam Integer id) throws AppointmentException {
		return new ResponseEntity<>(appointmentService.getAppointmentById(id), HttpStatus.OK);
	}

	// getting between the dates
	@GetMapping("/all/limit")
	public ResponseEntity<?> getAllBetweenTime(@RequestParam String start, @RequestParam String end)
			throws ParseException {
		if (start == null || end == null)
			return new ResponseEntity<>("Start or end time is null!", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(appointmentService.getAllInTime(start, end), HttpStatus.OK);
	}

	// apply for appointment
	@PostMapping
	public ResponseEntity<?> add(@Valid @RequestBody Appointment appointment) {
		if (appointment == null)
			return new ResponseEntity<>("Appointment is null!", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(appointmentService.createAppointment(appointment), HttpStatus.ACCEPTED);
	}

	@DeleteMapping
	public ResponseEntity<?> delete(@RequestParam Integer id) throws AppointmentException {
		if (id == null)
			return new ResponseEntity<>("Id is null!", HttpStatus.BAD_REQUEST);
		appointmentService.deleteAppointment(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// update the appointment
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Appointment appointment) throws AppointmentException {
		if (appointment == null)
			return new ResponseEntity<>("Appointment is null!", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(appointmentService.updateAppointment(appointment), HttpStatus.ACCEPTED);
	}
}
