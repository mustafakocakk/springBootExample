package com.base.issueManagement.service;

import com.base.issueManagement.util.TPage;
import com.base.issueManagement.dto.IssueDTO;
import org.springframework.data.domain.Pageable;


public interface IssueService {

    IssueDTO save(IssueDTO issue);

    IssueDTO getById(Long id);

    TPage<IssueDTO> getAllPageable(Pageable pageable);

    Boolean delete(IssueDTO issue);

}
