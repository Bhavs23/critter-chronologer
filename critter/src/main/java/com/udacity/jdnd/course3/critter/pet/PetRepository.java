package com.udacity.jdnd.course3.critter.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository for Pet entity
 * Provides CRUD operations for pets
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    // Custom query method: Find all pets belonging to a specific customer
    List<Pet> findByOwnerId(Long ownerId);
}