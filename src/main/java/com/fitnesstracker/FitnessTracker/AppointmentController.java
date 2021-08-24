package com.fitnesstracker.FitnessTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
	
	@Autowired
	IAppointmentService appointmentService;
	
	@GetMapping("/appointments")
	private Iterable<FitnessAppointment> getAllFitnessAppointment() {
		return appointmentService.retrieveAllFitnessAppointment();
	}
	
	@PostMapping("/fitnessappointments")
	private void saveFitnessAppointment(@RequestBody FitnessAppointment fitnessappointment) {
		appointmentService.save(fitnessappointment);
	}

}
