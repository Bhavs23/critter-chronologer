package com.udacity.jdnd.course3.critter.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

/**
 * Repository for Employee entity
 * Provides CRUD operations for employees
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employees available on a specific day and with specific skills
    @Query("SELECT DISTINCT e FROM Employee e " +
            "JOIN e.daysAvailable d " +
            "WHERE d = :dayOfWeek AND :skills MEMBER OF e.skills")
    List<Employee> findEmployeesForService(@Param("dayOfWeek") DayOfWeek dayOfWeek,
                                           @Param("skills") Set<EmployeeSkill> skills);
}