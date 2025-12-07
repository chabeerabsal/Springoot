package com.example.ProductEntity.Repository;

import com.example.ProductEntity.Modellor.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {

    @Query("select p from Products p join p.productCategory c "+ "where c.name like concat('%',:search,'%')" +"or p.productName=:search"+" or p.productDescription=:search")
    List<Products> findBykeyword(@Param("search") String search);


    @Query("select p from Products p ORDER BY " +
            "CASE " +
            "WHEN :sort ='p.productName' and :sortdir='asc' then p.productName END ASC")
    List<Products> findByUserSort(String sort, String sortdir);
}
