package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service for managing employees
 * Contains business logic for employee operations
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Save a new employee or update existing one
     */
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Find employee by ID
     */
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
    }

    /**
     * Set the days an employee is available to work
     */
    public void setAvailability(Set<DayOfWeek> daysAvailable, Long employeeId) {
        Employee employee = getEmployeeById(employeeId);
        employee.setDaysAvailable(daysAvailable);
        employeeRepository.save(employee);
    }

    /**
     * Find employees available for service on a specific date with required skills
     */
    public List<Employee> findEmployeesForService(DayOfWeek dayOfWeek, Set<EmployeeSkill> skills) {
        List<Employee> allEmployees = employeeRepository.findAll();

        return allEmployees.stream()
                .filter(employee -> employee.getDaysAvailable().contains(dayOfWeek))
                .filter(employee -> employee.getSkills().containsAll(skills))
                .collect(Collectors.toList());
    }
}