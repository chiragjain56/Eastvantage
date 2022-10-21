package com.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Appointment;
import com.test.exceptions.AppointmentException;
import com.test.repository.AppointmentRepo;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepo appointmentRepo;

	public List<Appointment> getAllAppointments() {
		return appointmentRepo.findAll();
	}

	public Appointment createAppointment(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}

	public Appointment getAppointmentById(Integer id) throws AppointmentException {
		return appointmentRepo.findById(id).orElseThrow(() -> new AppointmentException("Not found!"));
	}

	public void deleteAppointment(Integer id) throws AppointmentException {
		appointmentRepo.findById(id).orElseThrow(() -> new AppointmentException("Not found!"));
		appointmentRepo.deleteById(id);
	}

	public List<Appointment> getAllInTime(String start, String end) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = formatter.parse(start);
		Date endDate = formatter.parse(end);
		return appointmentRepo.findAllInTime(startDate, endDate);
	}

	public Appointment updateAppointment(Appointment toUpdate) throws AppointmentException {
		Appointment appointment = appointmentRepo.findById(toUpdate.getId())
				.orElseThrow(() -> new AppointmentException("Not found by id!"));
		appointment.setAppointmentDate(toUpdate.getAppointmentDate());
		appointment.setDuration(toUpdate.getDuration());
		appointment.setStatus(toUpdate.getStatus());
		appointment.setComment(toUpdate.getComment());
		return appointmentRepo.save(appointment);
	}

}
