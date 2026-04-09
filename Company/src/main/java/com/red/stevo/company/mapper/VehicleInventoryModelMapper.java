package com.red.stevo.company.mapper;

import com.red.stevo.company.entity.VehicleInventoryEntity;
import com.red.stevo.company.requests.VehicleInventoryModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleInventoryModelMapper {

    VehicleInventoryEntity mapInventoryModelToInventoryEntity(VehicleInventoryModel vehicleModel);

    VehicleInventoryModel mapInventoryEntityToInventoryModel(VehicleInventoryEntity vehicleModel);

    List<VehicleInventoryModel> mapInventoryEntityListToInventoryModelList(List<VehicleInventoryEntity> vehicleModel);

}
