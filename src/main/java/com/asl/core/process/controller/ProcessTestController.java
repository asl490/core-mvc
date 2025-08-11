package com.asl.core.process.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asl.core.process.service.ProcessTestService;
import com.asl.core.process.util.ProcessTestDTO;
import com.asl.core.shared.BaseController;

@RestController
@RequestMapping("/processtest")
public class ProcessTestController
        extends BaseController<ProcessTestDTO.Create, ProcessTestDTO.Update, ProcessTestDTO, ProcessTestDTO.Filters> {

    public ProcessTestController(ProcessTestService service) {
        super(service);
    }

}