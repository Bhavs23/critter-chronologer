package com.udacity.jdnd.course3.critter.user;

import jakarta.persistence.*;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity representing an Employee (service provider)
 */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Employee skills (WALKING, FEEDING, etc.)
    @ElementCollection(targetClass = EmployeeSkill.class)
    @CollectionTable(name = "employee_skills", joinColumns = @JoinColumn(name = "employee_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "skill")
    private Set<EmployeeSkill> skills = new HashSet<>();

    // Days the employee is available to work
    @ElementCollection(targetClass = DayOfWeek.class)
    @CollectionTable(name = "employee_availability", joinColumns = @JoinColumn(name = "employee_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week")
    private Set<DayOfWeek> daysAvailable = new HashSet<>();

    // Constructors
    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }

    // Helper methods
    public void addSkill(EmployeeSkill skill) {
        this.skills.add(skill);
    }

    public void addDayAvailable(DayOfWeek day) {
        this.daysAvailable.add(day);
    }
}