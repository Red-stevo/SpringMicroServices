package com.red.stevo.vehicleorderservice.controller;


import com.red.stevo.vehicleorderservice.request.VehicleOrderRequest;
import com.red.stevo.vehicleorderservice.response.VehicleOrderModel;
import com.red.stevo.vehicleorderservice.service.VehicleOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle/order")
public class VehicleOrderController {

    private final VehicleOrderService orderService;


    @PostMapping
    public ResponseEntity<VehicleOrderModel> saveVehicleOrder(@RequestBody VehicleOrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.saveVehicleOrder(orderRequest));
    }


    @GetMapping
    public ResponseEntity<List<VehicleOrderModel>> getAllVehicleOrderModels() {
        return ResponseEntity.ok(orderService.getAllVehicleOrderDetails());
    }

    @GetMapping("{id}")
    public ResponseEntity<VehicleOrderModel> getVehicleOrderModel(@PathVariable("id") String orderId) {
        return ResponseEntity.ok(orderService.getVehicleOrderDetails(orderId));
    }

}
