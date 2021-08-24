package com.fitnesstracker.FitnessTracker;

import org.springframework.data.repository.CrudRepository;

public interface IAppointmentRepository extends CrudRepository<FitnessAppointment, Long> {

}
