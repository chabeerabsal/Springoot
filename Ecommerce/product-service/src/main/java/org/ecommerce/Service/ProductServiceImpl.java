package org.ecommerce.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.ecommerce.Constants.ProductConstants;
import org.ecommerce.Dto.ProductDto;
import org.ecommerce.Exceptions.ResourceNotFoundException;
import org.ecommerce.Modells.Product;
import org.ecommerce.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public ProductDto create(ProductDto dto) {
        log.info("Creating product with name: {}", dto.getName());

        Product product = Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();

        Product saved = repository.save(product);

        return mapToDto(saved);
    }

    @Override
    public ProductDto getById(UUID id) {
        log.info("Fetching product with id: {}", id);

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                String.format(ProductConstants.PRODUCT_NOT_FOUND, id)
                        )
                );

        return mapToDto(product);
    }

    private ProductDto mapToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }
}