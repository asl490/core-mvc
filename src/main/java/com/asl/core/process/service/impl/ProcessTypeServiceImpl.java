package com.asl.core.process.service.impl;

import org.springframework.stereotype.Service;

import com.asl.core.process.entity.ProcessType;
import com.asl.core.process.repository.ProcessTypeRepository;
import com.asl.core.process.service.ProcessTypeService;
import com.asl.core.process.util.ProcessTypeDTO;
import com.asl.core.process.util.ProcessTypeDTO.Create;
import com.asl.core.process.util.ProcessTypeDTO.Filters;
import com.asl.core.process.util.ProcessTypeDTO.Update;
import com.asl.core.process.util.ProcessTypeMapper;
import com.asl.core.shared.BaseServiceImpl;

@Service
public class ProcessTypeServiceImpl extends
        BaseServiceImpl<ProcessType, Create, Update, ProcessTypeDTO, Filters>
        implements ProcessTypeService {

    public ProcessTypeServiceImpl(ProcessTypeRepository repository,
            ProcessTypeMapper mapper) {
        super(repository, mapper);

    }

}