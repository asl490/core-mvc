package com.asl.core.process.util;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessTypeDTO {
    private Long id;

    private String name;

    private String description;

    private Integer duration;

    private String status;

    private Double cost;

    @Data
    public static class Create {

        @NotBlank

        private String name;

        private String description;

        @NotNull

        @Min(0)

        private Integer duration;

        @NotBlank

        private String status;

        @NotNull

        @Min(0)

        private Double cost;

    }

    @Data
    public static class Update {

        private String name;

        private String description;

        private Integer duration;

        private String status;

        private Double cost;

    }

    @Data
    public static class Filters {
        private Long id;

        private String name;

        private String description;

        private Integer duration;

        private String status;

        private Double cost;

    }
}