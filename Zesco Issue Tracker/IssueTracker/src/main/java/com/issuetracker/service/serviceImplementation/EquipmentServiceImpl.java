package com.issuetracker.service.serviceImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.issuetracker.model.Equipment;
import com.issuetracker.repository.EquipmentRepository;
import com.issuetracker.service.EquipmentService;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private EquipmentRepository repos;

    public EquipmentServiceImpl(EquipmentRepository repos) {
        super();
        this.repos = repos;
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return repos.findAll();
    }    
}
