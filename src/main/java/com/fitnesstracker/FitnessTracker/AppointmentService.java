package com.fitnesstracker.FitnessTracker;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;
import org.springframework.util.StringUtils;

@Service
public abstract class AppointmentService implements IAppointmentService {
	
	@Autowired
	IAppointmentRepository appointmentRepository;
	
	@Override
	public void save(FitnessAppointment fitnessappointment) {
		validation(fitnessappointment);
		appointmentRepository.save(fitnessappointment);
		System.out.println("Saved");
	}
	
	private void validation(FitnessAppointment fitnessappointment) {
		if (fitnessappointment.getName().length() < 6) 
			throw new NameException("Name should be atleast 4 characters");
		if(fitnessappointment.getName().isEmpty())
			throw new NameException("Name field cannt be empty");
		if (fitnessappointment.getAge() < 1 || fitnessappointment.getAge() > 100)
			throw new AgeException("Enter Valid Age");
		if (!emailValidation(fitnessappointment.getEmail()))
			throw new EmailException("Enter Valid Email");
		if (fitnessappointment.getPhoneNo().length() != 10) 
			throw new PhoneException("Phone No should be 10 digits");
		

	}

	private boolean emailValidation(String email) {
		String emailRegex =  "^(.+)@(.+)$";

		Pattern pat = Pattern.compile(emailRegex);
		return pat.matcher(email).matches();
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
	
	@Override
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
