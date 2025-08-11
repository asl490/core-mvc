package com.asl.core.process.service.impl;

import org.springframework.stereotype.Service;

import com.asl.core.process.entity.ProcessTest;
import com.asl.core.process.repository.ProcessTestRepository;
import com.asl.core.process.service.ProcessTestService;
import com.asl.core.process.util.ProcessTestDTO;
import com.asl.core.process.util.ProcessTestDTO.Create;
import com.asl.core.process.util.ProcessTestDTO.Filters;
import com.asl.core.process.util.ProcessTestDTO.Update;
import com.asl.core.process.util.ProcessTestMapper;
import com.asl.core.shared.BaseServiceImpl;

@Service
public class ProcessTestServiceImpl extends
        BaseServiceImpl<ProcessTest, Create, Update, ProcessTestDTO, Filters>
        implements ProcessTestService {

    public ProcessTestServiceImpl(ProcessTestRepository repository,
            ProcessTestMapper mapper) {
        super(repository, mapper);

    }

}