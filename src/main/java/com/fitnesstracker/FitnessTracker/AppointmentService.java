package com.fitnesstracker.FitnessTracker;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class AppointmentService implements IAppointmentService {
	
	@Autowired
	IAppointmentRepository appointmentRepository;
	
	@Override
	public void save(FitnessAppointment fitnessappointment) {
		appointmentRepository.save(fitnessappointment);
		System.out.println("Saved");
	}
	
	@Override
	public Iterable<FitnessAppointment> retrieveAllFitnessAppointment() {
		return appointmentRepository.findAll();
	}
	
	
	@Override
	public  Optional<FitnessAppointment> retrieveFitnessAppointment(long id) {
		Optional<FitnessAppointment> fitnessappointment = appointmentRepository.findById((int) id);
		if(!fitnessappointment.isPresent()) {
			throw  new AppointmentNotFoundException("Appointment does not exist");
		}
		return fitnessappointment;
	}

	@Override
	public void deleteAppointment(long id) {
		appointmentRepository.deleteById((int) id);
	}

	

}
