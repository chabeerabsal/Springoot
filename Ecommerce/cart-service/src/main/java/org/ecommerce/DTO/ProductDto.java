package org.ecommerce.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProductDto {
    private UUID id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
