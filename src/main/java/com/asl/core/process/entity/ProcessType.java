package com.asl.core.process.entity;

import com.asl.core.shared.Auditable;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProcessType extends Auditable {

    private String name;

    private String description;

    private Integer duration;

    private String status;

    private Double cost;

}