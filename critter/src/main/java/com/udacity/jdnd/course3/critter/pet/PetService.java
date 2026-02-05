package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for managing pets
 * Contains business logic for pet operations
 */
@Service
@Transactional
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Save a new pet or update existing one
     * Also updates the customer's pet list
     */
    public Pet savePet(Pet pet, Long ownerId) {
        Customer owner = customerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + ownerId));

        pet.setOwner(owner);
        Pet savedPet = petRepository.save(pet);

        // Add pet to owner's pet list if not already there
        if (!owner.getPets().contains(savedPet)) {
            owner.addPet(savedPet);
            customerRepository.save(owner);
        }

        return savedPet;
    }

    /**
     * Get all pets
     */
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    /**
     * Find pet by ID
     */
    public Pet getPetById(Long petId) {
        return petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + petId));
    }

    /**
     * Get all pets owned by a specific customer
     */
    public List<Pet> getPetsByOwner(Long ownerId) {
        return petRepository.findByOwnerId(ownerId);
    }
}