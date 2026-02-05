package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetRepository;
import com.udacity.jdnd.course3.critter.user.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for managing schedules
 * Contains business logic for schedule operations
 */
@Service
@Transactional
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Create a new schedule
     */
    public Schedule createSchedule(Schedule schedule, List<Long> employeeIds, List<Long> petIds) {
        // Load employees
        List<Employee> employees = employeeRepository.findAllById(employeeIds);
        schedule.setEmployees(employees);

        // Load pets
        List<Pet> pets = petRepository.findAllById(petIds);
        schedule.setPets(pets);

        return scheduleRepository.save(schedule);
    }

    /**
     * Get all schedules
     */
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    /**
     * Get all schedules for a specific pet
     */
    public List<Schedule> getScheduleForPet(Long petId) {
        return scheduleRepository.findByPetId(petId);
    }

    /**
     * Get all schedules for a specific employee
     */
    public List<Schedule> getScheduleForEmployee(Long employeeId) {
        return scheduleRepository.findByEmployeeId(employeeId);
    }

    /**
     * Get all schedules for pets owned by a specific customer
     */
    public List<Schedule> getScheduleForCustomer(Long customerId) {
        return scheduleRepository.findByCustomerId(customerId);
    }
}