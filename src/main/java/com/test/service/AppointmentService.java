package com.test.service;

import java.sql.Date;
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
		return appointmentRepo.findById(id).orElseThrow(()-> new AppointmentException("Not found!"));
	}
	
	public void deleteAppointment(Integer id) throws AppointmentException {
		appointmentRepo.findById(id).orElseThrow(()-> new AppointmentException("Not found!"));
		appointmentRepo.deleteById(id);
	}
	
	public List<Appointment> getAllInTime(Date start, Date end) {
		return appointmentRepo.findAllInTime(start, end);
	}

	public Appointment updateAppointment(Appointment toUpdate) throws AppointmentException {
		Appointment appointment = appointmentRepo.findById(toUpdate.getId()).orElseThrow(()-> new AppointmentException("Not found by id!"));
		appointment.setAppointmentDate(toUpdate.getAppointmentDate());
		appointment.setDuration(toUpdate.getDuration());
		appointment.setStatus(toUpdate.getStatus());
		appointment.setPurpose(toUpdate.getPurpose());
		appointment.setComment(toUpdate.getComment());
		return appointmentRepo.save(appointment);
	}

}
