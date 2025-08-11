package com.asl.core.process.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asl.core.process.service.ProcessTypeService;
import com.asl.core.process.util.ProcessTypeDTO;
import com.asl.core.shared.BaseController;

@RestController
@RequestMapping("/processtype")
public class ProcessTypeController
        extends BaseController<ProcessTypeDTO.Create, ProcessTypeDTO.Update, ProcessTypeDTO, ProcessTypeDTO.Filters> {

    public ProcessTypeController(ProcessTypeService service) {
        super(service);
    }

}