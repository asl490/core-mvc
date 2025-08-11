package com.asl.core.process.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.asl.core.process.entity.ProcessGroup;
import com.asl.core.shared.BaseMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProcessGroupMapper extends BaseMapper<ProcessGroup, ProcessGroupDTO, ProcessGroupDTO.Create, ProcessGroupDTO.Update> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    ProcessGroup toEntity(ProcessGroupDTO.Create dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    void updateEntityFromDTO(ProcessGroupDTO.Update dto, @MappingTarget ProcessGroup entity);

}