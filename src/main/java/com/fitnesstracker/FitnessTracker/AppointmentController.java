package com.fitnesstracker.FitnessTracker;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
	
	@Autowired
	IAppointmentService appointmentService;
	
	@GetMapping("/appointments")
	public Iterable<FitnessAppointment> getAllAppointment() {
		return appointmentService.retrieveAllFitnessAppointment();
	}
	
	@GetMapping("/appointments/{id}")
	public Optional<FitnessAppointment> getFitnessAppointment(@PathVariable("id") long id) {
		return appointmentService.retrieveAppointment(id);
	}
	
	@PostMapping("/fitnessappointments")
	public void saveAppointment(@RequestBody FitnessAppointment appointment) {
		appointmentService.save(appointment);
	}
	
	@DeleteMapping("/appointments/{id}")
	public void deleteAppointment(@PathVariable("id") long id) {
		appointmentService.deleteAppointment(id);
	}

	@ExceptionHandler(value = {AppointmentNotFoundException.class, EmptyResultDataAccessException.class })
	public ResponseEntity<FitnessAppointment> exception(RuntimeException runtimeException) {
		return new ResponseEntity<FitnessAppointment>(HttpStatus.NOT_FOUND);
	}

}
