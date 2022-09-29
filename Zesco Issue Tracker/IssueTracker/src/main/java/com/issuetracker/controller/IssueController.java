package com.issuetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.issuetracker.model.Issue;
import com.issuetracker.repository.IssueRepository;
import com.issuetracker.service.EquipmentService;
import com.issuetracker.service.IssueService;

@Controller
public class IssueController {
    @Autowired
    private IssueRepository issueRepository;
   
    @Autowired
    private IssueService issueService;


    @Autowired
    private EquipmentService equipmentService;

    public IssueController(IssueService issueService){
        super();
        this.issueService = issueService;
    }
    
    //this takes you to add issue page 
    @GetMapping("/addissue")
	public String showAddIssue(Model model){
        model.addAttribute("listEquipments", equipmentService.getAllEquipment());
		model.addAttribute("issue", new Issue());
		return "/processissue";
	}

    //This saves the information about an issue once submitted and redirected to issue page
    @PostMapping("/processissue")
    public String addIssue(Issue issue){
        issueRepository.save(issue);
        return "redirect:/issue";
    }

    //This takes to issue page and loads all issue that are in the database 
    @GetMapping("/issue")
    public String listIssues(Model model){
        model.addAttribute("listIssues", issueService.getAllEquipment());
        return "issues";
    }

    //this gets the issue by id from the database
    @GetMapping("/issues/edit/{id}")
    public String editIssue(@PathVariable Long id, Model model){
        model.addAttribute("listEquipments", equipmentService.getAllEquipment());
        model.addAttribute("issue", issueService.getIssueById(id));
        return "editissue";
    }

    //update issue
    @PostMapping("/processissue/{id}")
    public String updateIssue(@PathVariable Long id,
        @ModelAttribute("issue") Issue issue, Model model){
            //get issue from database
            Issue existingIssue = issueService.getIssueById(id);
            existingIssue.setId(id);
            existingIssue.setEquipment(issue.getEquipment());
            existingIssue.setDescription(issue.getDescription());
            existingIssue.setLocation(issue.getLocation());
            existingIssue.setStatus(issue.getStatus());
            existingIssue.setDateofinspection(issue.getDateofinspection());
            existingIssue.setNameofinspector(issue.getNameofinspector());

            //save updated issue 
            issueService.updateIssue(existingIssue);
            return "redirect:/issue";
        }
    
        //deletes issue
        @GetMapping("/issues/{id}")
        public String deleteIssue(@PathVariable Long id){
            issueService.deleteIssue(id);
            return "redirect:/issue";
        }

        ///add comment
        @GetMapping("/issues/comment/{id}")
        public String addcomment(@PathVariable Long id, Model model){
        model.addAttribute("issue", issueService.getIssueById(id));
        return "addcomment";
        }

        //add comment
        @PostMapping("/addcomment/{id}")
        public String addcomment(@PathVariable Long id,
            @ModelAttribute("issue") Issue issue, Model model){
            
            //get issue from database
            Issue existingIssue = issueService.getIssueById(id);
            existingIssue.setId(id);
            existingIssue.setComment(issue.getComment());
            //Save Updated Issue 
            issueService.updateIssue(existingIssue);
            return "redirect:/issue";
        }


}