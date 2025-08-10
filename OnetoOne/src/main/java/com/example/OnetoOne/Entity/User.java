package com.example.OnetoOne.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long  id;
    String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressName_id",referencedColumnName = "id")
    AddresName addressName;

    public void setAddressName(AddresName addressName) {
        this.addressName = addressName;
        if (addressName != null) {
            addressName.setUser(this); // Maintain both sides
        }
    }

}
