package com.fitnesstracker.FitnessTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
	
	@Autowired
	IAppointmentRepository appointmentRepository;
	
	public void save(FitnessAppointment fitnessappointment) {
		appointmentRepository.save(fitnessappointment);
		System.out.println("Saved");
	}

	public Iterable<FitnessAppointment> retrieveAllFitnessAppointment() {
		return appointmentRepository.findAll();
	}

}
