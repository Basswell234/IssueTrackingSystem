package com.issuetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issuetracker.model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment,Long> {

    
}