package com.example.SearchingFilterSortingpagination.Repository;

import com.example.SearchingFilterSortingpagination.Model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Integer> {

    @Query("SELECT p FROM Products p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Products> findResultsWithMatchedKeyword(@Param("keyword") String keyword, Pageable pageable);

    Page<Products> findByCategoryIgnoreCaseAndBrandIgnoreCase(String category, String brand, Pageable pageable);
}
