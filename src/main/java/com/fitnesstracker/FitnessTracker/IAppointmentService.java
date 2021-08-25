package com.fitnesstracker.FitnessTracker;

import java.util.Optional;
public interface IAppointmentService {
	
	void save(FitnessAppointment fitnessappointment);
	Iterable<FitnessAppointment> retrieveAllFitnessAppointment();
	Optional<FitnessAppointment> retrieveAppointment(long id);

	void deleteAppointment(long id);
	Optional<FitnessAppointment> retrieveFitnessAppointment(long id);
	void updateAppointment(long id, FitnessAppointment appointment);
		
	}


