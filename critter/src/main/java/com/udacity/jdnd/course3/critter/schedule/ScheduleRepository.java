package com.udacity.jdnd.course3.critter.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository for Schedule entity
 * Provides CRUD operations for schedules
 */
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // Find all schedules for a specific pet
    @Query("SELECT s FROM Schedule s JOIN s.pets p WHERE p.id = :petId")
    List<Schedule> findByPetId(@Param("petId") Long petId);

    // Find all schedules for a specific employee
    @Query("SELECT s FROM Schedule s JOIN s.employees e WHERE e.id = :employeeId")
    List<Schedule> findByEmployeeId(@Param("employeeId") Long employeeId);

    // Find all schedules for pets owned by a specific customer
    @Query("SELECT s FROM Schedule s JOIN s.pets p WHERE p.owner.id = :customerId")
    List<Schedule> findByCustomerId(@Param("customerId") Long customerId);
}