package com.test.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.entity.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

	@Query(value = "SELECT apt FROM appointment apt WHERE " + "(apt.appointment_date = ?1 OR apt.appointment_date > ?1)"
			+ "AND apt.appointment_date < ?2", nativeQuery = true)
	List<Appointment> findAllInTime(Date start, Date end);
}
