package com.red.stevo.vehicleorderservice.mapper;


import com.red.stevo.vehicleorderservice.entity.VehicleOrderEntity;
import com.red.stevo.vehicleorderservice.request.VehicleOrderRequest;
import com.red.stevo.vehicleorderservice.response.VehicleInventoryModel;
import com.red.stevo.vehicleorderservice.response.VehicleOrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface VehicleOrderMapper {

    VehicleOrderEntity mapVehicleOrderRequestToVehicleOrderEntity(VehicleOrderRequest orderRequest);

    @Mappings({

    })
    VehicleOrderModel mapVehicleOrderEntityAndVehicleInventoryModelToVehicleOrderModel(
            VehicleOrderEntity orderEntity, VehicleInventoryModel inventoryModel);

}
