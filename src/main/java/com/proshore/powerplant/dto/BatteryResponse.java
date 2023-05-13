package com.proshore.powerplant.dto;

import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BatteryResponse {
    List<BatteryInfo> batteryInfo;
}
