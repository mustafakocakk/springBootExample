package com.base.issueManagement.repository;

import com.base.issueManagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository  extends JpaRepository<Issue,Long> {
}