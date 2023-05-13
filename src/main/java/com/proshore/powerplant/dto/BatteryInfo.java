package com.proshore.powerplant.dto;

import lombok.Data;

@Data
public class BatteryInfo {   
    private Long id;
    private String name;
    private String postCode;
    private double wattCapacity;
}
