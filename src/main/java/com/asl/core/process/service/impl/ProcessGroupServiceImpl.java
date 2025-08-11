package com.asl.core.process.service.impl;

import org.springframework.stereotype.Service;

import com.asl.core.process.entity.ProcessGroup;
import com.asl.core.process.repository.ProcessGroupRepository;
import com.asl.core.process.service.ProcessGroupService;
import com.asl.core.process.util.ProcessGroupDTO;
import com.asl.core.process.util.ProcessGroupDTO.Create;
import com.asl.core.process.util.ProcessGroupDTO.Filters;
import com.asl.core.process.util.ProcessGroupDTO.Update;
import com.asl.core.process.util.ProcessGroupMapper;
import com.asl.core.shared.BaseServiceImpl;

@Service
public class ProcessGroupServiceImpl extends
        BaseServiceImpl<ProcessGroup, Create, Update, ProcessGroupDTO, Filters>
        implements ProcessGroupService {

    public ProcessGroupServiceImpl(ProcessGroupRepository repository,
            ProcessGroupMapper mapper) {
        super(repository, mapper);

    }

}