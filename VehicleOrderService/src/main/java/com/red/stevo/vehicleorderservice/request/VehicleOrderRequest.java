package com.red.stevo.vehicleorderservice.request;

import java.util.Date;

public record VehicleOrderRequest(Date orderDate, String vehicleInventoryId) {}
