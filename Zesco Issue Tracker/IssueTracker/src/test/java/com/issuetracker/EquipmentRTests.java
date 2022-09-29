package com.issuetracker;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.issuetracker.model.Equipment;
import com.issuetracker.repository.EquipmentRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class EquipmentRTests {

    @Autowired
    EquipmentRepository repos;
    
	//testing create equipment method
	@Test
	public void testCreateEquipment() {
		Equipment equipment = new Equipment();
		equipment.setEquipmentname("Bulbs");
		equipment.setEquipmentdescription("LED LIGHTS");
		equipment.setLocation("kitwe");
		repos.save(equipment);
	}
}