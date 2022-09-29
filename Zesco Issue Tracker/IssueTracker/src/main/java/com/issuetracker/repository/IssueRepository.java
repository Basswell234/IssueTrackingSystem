package com.issuetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issuetracker.model.Issue;

public interface IssueRepository extends JpaRepository<Issue,Long> {
    
}
