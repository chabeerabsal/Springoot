package org.ecommerce.Service;



import org.ecommerce.Dto.ProductDto;

import java.util.UUID;

public interface ProductService {

    ProductDto create(ProductDto dto);

    ProductDto getById(UUID id);
}