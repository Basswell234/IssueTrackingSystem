package com.issuetracker.service.serviceImplementation;

import java.util.List;
import org.springframework.stereotype.Service;
import com.issuetracker.model.Issue;
import com.issuetracker.repository.IssueRepository;

import com.issuetracker.service.IssueService;

@Service
public class IssueServiceImpl implements IssueService {

    private IssueRepository repos;

    public IssueServiceImpl(IssueRepository repos) {
        super();
        this.repos = repos;
    }

    //gettig all the equipments in the database
    @Override
    public List<Issue> getAllEquipment() {
        return repos.findAll();
    }

    //getting issue by id from database
    @Override
    public Issue getIssueById(Long id) {
        return repos.findById(id).get();
    }
    
    //save issue in database
    @Override
    public Issue updateIssue(Issue issue) {
        return repos.save(issue);
    }

    @Override
    public void deleteIssue(Long id) {
        repos.deleteById(id);
    }
}
