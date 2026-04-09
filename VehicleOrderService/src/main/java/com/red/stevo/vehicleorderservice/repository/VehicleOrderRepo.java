package com.red.stevo.vehicleorderservice.repository;

import com.red.stevo.vehicleorderservice.entity.VehicleOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleOrderRepo extends JpaRepository<VehicleOrderEntity, String> {
}
