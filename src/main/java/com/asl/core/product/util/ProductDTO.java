package com.asl.core.product.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;

    @Data
    public static class Create {
        private String name;
        private Double price;
    }

    @Data
    public static class Update {
        private String name;
        private Double price;
    }

    @Data
    public static class Filters {
        private String name;
        private Double price;
    }
}
