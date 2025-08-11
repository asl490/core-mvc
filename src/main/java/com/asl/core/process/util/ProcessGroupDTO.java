package com.asl.core.process.util;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessGroupDTO {
    private Long id;

    private String name;

    private String description;

    @Data
    public static class Create {

        @NotBlank

        private String name;

        private String description;

    }

    @Data
    public static class Update {

        private String name;

        private String description;

    }

    @Data
    public static class Filters {
        private Long id;

        private String name;

        private String description;

    }
}