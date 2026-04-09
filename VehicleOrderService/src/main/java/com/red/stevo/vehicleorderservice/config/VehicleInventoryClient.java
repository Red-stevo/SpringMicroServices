package com.red.stevo.vehicleorderservice.config;


import com.red.stevo.vehicleorderservice.response.VehicleInventoryModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "VehicleInventoryClient", path = "/vehicleinventoryserver/api/v1/inventory/vehicle")
public interface VehicleInventoryClient {

    @GetMapping("/{vehicleId}")
    VehicleInventoryModel fetchVehicleInventoryById(@PathVariable("vehicleId") String id);

}
