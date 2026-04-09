package com.red.stevo.vehicleorderservice.service;


import com.red.stevo.vehicleorderservice.config.VehicleInventoryClient;
import com.red.stevo.vehicleorderservice.entity.VehicleOrderEntity;
import com.red.stevo.vehicleorderservice.mapper.VehicleOrderMapper;
import com.red.stevo.vehicleorderservice.repository.VehicleOrderRepo;
import com.red.stevo.vehicleorderservice.request.VehicleOrderRequest;
import com.red.stevo.vehicleorderservice.response.VehicleInventoryModel;
import com.red.stevo.vehicleorderservice.response.VehicleOrderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleOrderService {

    private final VehicleOrderRepo orderRepo;

    private final VehicleOrderMapper orderMapper;

    private final VehicleInventoryClient vehicleInventoryClient;

    public VehicleOrderModel saveVehicleOrder(VehicleOrderRequest orderRequest) {

        VehicleOrderEntity orderEntity = orderRepo
                .save(orderMapper
                        .mapVehicleOrderRequestToVehicleOrderEntity(orderRequest));

        /*Here we need to get some details from the vehicle Inventory Service*/
        VehicleInventoryModel vehicleInventoryModel =
                vehicleInventoryClient
                        .fetchVehicleInventoryById(orderEntity.getVehicleInventoryId());

        return null;
    }

    public VehicleOrderModel getVehicleOrderDetails(String orderId) {
        return null;
    }

    public List<VehicleOrderModel> getAllVehicleOrderDetails() {
        return null;
    }

}
