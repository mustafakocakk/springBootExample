package com.base.issueManagement.service;

import com.base.issueManagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    Project save(Project project);

    Project getById(Long id);

    List<Project> getByProjectCodeContains(String projectCode);

    List<Project> getByProjectCode(String projectCode);


    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Project project);

}
