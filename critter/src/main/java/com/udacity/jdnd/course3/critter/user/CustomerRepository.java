package com.udacity.jdnd.course3.critter.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Customer entity
 * Provides CRUD operations for customers
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // JpaRepository provides basic methods like:
    // - save(customer)
    // - findById(id)
    // - findAll()
    // - delete(customer)
    // - count()

    // Custom query methods can be added here if needed
}