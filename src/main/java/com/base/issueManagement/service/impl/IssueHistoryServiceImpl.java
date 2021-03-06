package com.base.issueManagement.service.impl;

import com.base.issueManagement.service.IssueHistoryService;
import com.base.issueManagement.entity.IssueHistory;
import com.base.issueManagement.repository.IssueHistoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private  final IssueHistoryRepository  issueHistoryRepository;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository){
        this.issueHistoryRepository=issueHistoryRepository;
    }
    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if(issueHistory.getDate()==null){
            throw  new IllegalArgumentException("issue date cannot be null");
        }
        issueHistory=issueHistoryRepository.save(issueHistory);
        return issueHistory;
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }

}
