package com.issuetracker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.issuetracker.model.Issue;
import com.issuetracker.repository.IssueRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class IssueRepositoryTests {

    @Autowired
    IssueRepository reposi;

    
    //testing create issue
	@Test
	public void testCreateIssue() {
		Issue issue = new Issue();
		issue.setEquipment("laptop");
		issue.setDescription("Has broken screen");
		issue.setLocation("copperbelt");
		issue.setStatus("Critical");
		issue.setDateofinspection("12/06/22");
		reposi.save(issue);
	}

    //testing find issue by id
	@Test
	public void testFindIssueById(){
        Issue issue = new Issue();
		issue.setEquipment("Bulbs");
		issue.setDescription("Has broken element");
		issue.setLocation("kitwe");
		issue.setStatus("Critical");
		issue.setDateofinspection("12/06/22");
		reposi.save(issue);

	    reposi.findById(issue.getId());
	}

    //testing delete issue by id
    @Test
	public void testDeleteIssueById(){
        Issue issue = new Issue();
		issue.setEquipment("Bulbs");
		issue.setDescription("Has broken element");
		issue.setLocation("kitwe");
		issue.setStatus("Critical");
		issue.setDateofinspection("12/06/22");
		reposi.save(issue);

	    reposi.deleteById(issue.getId());
	}

    


}
