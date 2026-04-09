package com.red.stevo.vehicleorderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    private Date orderDate;

    private String vehicleInventoryId;

}
