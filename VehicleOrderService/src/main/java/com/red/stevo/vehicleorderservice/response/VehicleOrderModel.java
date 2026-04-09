package com.red.stevo.vehicleorderservice.response;

import java.util.Date;

public record VehicleOrderModel(String id, Date orderDate, String make, String model, String count, Double price, String capability) {}
