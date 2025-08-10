package com.example.OnetoOne.Repository;

import com.example.OnetoOne.Entity.AddresName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressNameRepo extends JpaRepository<AddresName,Integer> {
}
