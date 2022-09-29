package com.issuetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.issuetracker.model.Equipment;
import com.issuetracker.repository.EquipmentRepository;
import com.issuetracker.service.EquipmentService;

@Controller
public class EquipmentController {

    @Autowired
    private EquipmentRepository equipmentRepository;
    private EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        super();
        this.equipmentService = equipmentService;
    }

    // trying out some code
    @GetMapping("/equipments")
    public String listEquipments(Model model){
        List <Equipment> listequipment = equipmentService.getAllEquipment();
        model.addAttribute("listEquipments", listequipment);
        model.addAttribute("equipment", new Equipment());
        return "equipments";
    }

    @GetMapping("/add_equipment")
	public String showAddEquipment(Model model){
		model.addAttribute("equipment", new Equipment());
		return "process_addequipment";
	}

    //saving an equipment
    @PostMapping("/process_addequipment")
    public String process_addEquipment(Equipment equipment){
        equipmentRepository.save(equipment);
        return "redirect:/equipments";
    }
    
}
