package com.asl.core.process.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asl.core.process.service.ProcessGroupService;
import com.asl.core.process.util.ProcessGroupDTO;
import com.asl.core.shared.BaseController;

@RestController
@RequestMapping("/processgroup")
public class ProcessGroupController
        extends BaseController<ProcessGroupDTO.Create, ProcessGroupDTO.Update, ProcessGroupDTO, ProcessGroupDTO.Filters> {

    public ProcessGroupController(ProcessGroupService service) {
        super(service);
    }

}