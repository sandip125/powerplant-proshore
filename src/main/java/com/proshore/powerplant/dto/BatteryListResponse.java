package com.proshore.powerplant.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BatteryListResponse {
    private List<BatteryInfo> batteryInfos;
    private double total;
    private double averageWattCapacity;
}
