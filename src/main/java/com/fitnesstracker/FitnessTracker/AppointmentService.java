package com.fitnesstracker.FitnessTracker;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public abstract class AppointmentService implements IAppointmentService {
	
	@Autowired
	IAppointmentRepository appointmentRepository;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
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
	@Transactional(rollbackFor = Exception.class)
	public void deleteAppointment(long id) {
		appointmentRepository.deleteById((int) id);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	
	public void updateAppointment(long id, FitnessAppointment fitnessappointment) {
		Optional<FitnessAppointment> appointmentFromDB = appointmentRepository.findById((int) id);
		if (!appointmentFromDB.isPresent())
			throw new AppointmentNotFoundException("Appointment does not exist to update");
		FitnessAppointment app1 = appointmentFromDB.get();
		if (StringUtils.hasText(fitnessappointment.getName()))
			app1.setName(fitnessappointment.getName());
		if (fitnessappointment.getAge() > 0 && fitnessappointment.getAge() < 80)
			app1.setAge(fitnessappointment.getAge());
		if (StringUtils.hasText(fitnessappointment.getEmail()))
			app1.setEmail(fitnessappointment.getEmail());
		if (StringUtils.hasText(fitnessappointment.getPhoneNo()))
			app1.setPhoneNo(fitnessappointment.getPhoneNo());
		if (StringUtils.hasText(fitnessappointment.getTrainerPreference()))
			app1.setTrainerPreference(fitnessappointment.getTrainerPreference());
		if (fitnessappointment.isPhysio() != app1.isPhysio())
			app1.setPhysio(fitnessappointment.isPhysio());
		if (StringUtils.hasText(fitnessappointment.getPack()))
			app1.setPack(fitnessappointment.getPack());
		if (fitnessappointment.getWeeks() > 0)
			app1.setWeeks(fitnessappointment.getWeeks());
		if (fitnessappointment.getAmmount() > 0)
			app1.setAmmount(fitnessappointment.getAmmount());

		appointmentRepository.save(app1);
	}


	

}
