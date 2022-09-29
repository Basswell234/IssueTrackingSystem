package com.issuetracker.service;

import java.util.List;

import com.issuetracker.model.Issue;

public interface IssueService {
        List<Issue> getAllEquipment();

        Issue getIssueById(Long id);
        Issue updateIssue(Issue issue);
        void deleteIssue(Long id);
}    
