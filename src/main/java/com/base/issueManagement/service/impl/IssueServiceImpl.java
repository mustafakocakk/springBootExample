package com.base.issueManagement.service.impl;

import com.base.issueManagement.entity.Issue;
import com.base.issueManagement.repository.IssueRepository;
import com.base.issueManagement.service.IssueService;
import com.base.issueManagement.util.TPage;
import com.base.issueManagement.dto.IssueDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository,ModelMapper modelMapper){
        this.issueRepository=issueRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public IssueDTO save(IssueDTO issue) {
        if(issue.getDate()==null){
            throw  new IllegalArgumentException("Issue date cannot be bull");
        }
        Issue issueDb = modelMapper.map(issue, Issue.class);
         issueDb = issueRepository.save(issueDb);
        return modelMapper.map(issueDb, IssueDTO.class);
    }

    @Override
    public IssueDTO getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDTO> getAllPageable(Pageable pageable) {
        TPage page=new TPage<IssueDTO>();
        Page<Issue> data = issueRepository.findAll(pageable);
        IssueDTO[] dtos = modelMapper.map(data.getContent(), IssueDTO[  ].class);
        page.setStat(data,Arrays.asList(dtos));
        return page;

    }

    @Override
    public Boolean delete(IssueDTO issue) {
        return null;
    }
}
