package com.fitnesstracker.FitnessTracker;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface IAppointmentRepository extends CrudRepository<FitnessAppointment, Integer> {

}
