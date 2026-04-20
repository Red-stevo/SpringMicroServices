package com.red.stevo.vehicleorderservice.service;


import com.red.stevo.vehicleorderservice.config.VehicleInventoryClient;
import com.red.stevo.vehicleorderservice.entity.VehicleOrderEntity;
import com.red.stevo.vehicleorderservice.mapper.VehicleOrderMapper;
import com.red.stevo.vehicleorderservice.repository.VehicleOrderRepo;
import com.red.stevo.vehicleorderservice.request.VehicleOrderRequest;
import com.red.stevo.vehicleorderservice.response.VehicleInventoryModel;
import com.red.stevo.vehicleorderservice.response.VehicleOrderModel;
import jakarta.ws.rs.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleOrderService {

    private final VehicleOrderRepo orderRepo;

    private final VehicleOrderMapper orderMapper;

    private final VehicleInventoryClient vehicleInventoryClient;


    public VehicleOrderModel saveVehicleOrder(VehicleOrderRequest orderRequest) {

        /*Save the order to database*/
        VehicleOrderEntity orderEntity = orderRepo
                .save(orderMapper
                        .mapVehicleOrderRequestToVehicleOrderEntity(orderRequest));

        /*Here we need to get some details from the vehicle Inventory Service*/
        VehicleInventoryModel vehicleInventoryModel =
                vehicleInventoryClient
                        .fetchVehicleInventoryById(orderEntity.getVehicleInventoryId());

        /*Combine the two response into a single order details response*/
        return orderMapper
                .mapVehicleOrderEntityAndVehicleInventoryModelToVehicleOrderModel(orderEntity, vehicleInventoryModel);
    }


    public VehicleOrderModel getVehicleOrderDetails(String orderId) {

        VehicleOrderEntity orderEntity = orderRepo.findById(orderId).orElseThrow(
                () -> new BadRequestException("Parameters Passed Were Invalid Please Try again"));


        /*Here we need to get some details from the vehicle Inventory Service*/
        VehicleInventoryModel vehicleInventoryModel =
                vehicleInventoryClient
                        .fetchVehicleInventoryById(orderEntity.getVehicleInventoryId());

        /*Combine the two response into a single order details response*/
        return orderMapper
                .mapVehicleOrderEntityAndVehicleInventoryModelToVehicleOrderModel(orderEntity, vehicleInventoryModel);
    }


    public List<VehicleOrderModel> getAllVehicleOrderDetails() {

        List<VehicleOrderEntity> orderEntities = orderRepo.findAll();


        /*For each order entity, fetch it corresponding inventory detail and map them to the order model for response*/
        return orderEntities.stream().map(
                orderEntity ->
                        orderMapper.mapVehicleOrderEntityAndVehicleInventoryModelToVehicleOrderModel(orderEntity,
                                vehicleInventoryClient.fetchVehicleInventoryById(orderEntity.getVehicleInventoryId()))
        ).toList();

    }

}
