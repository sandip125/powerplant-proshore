package com.proshore.powerplant.services;


import com.proshore.powerplant.dto.BatteryListResponse;
import com.proshore.powerplant.dto.BatteryRequest;
import com.proshore.powerplant.dto.BatteryResponse;

public interface BatteryService {
    
    BatteryResponse addBatteries(BatteryRequest request);
    BatteryListResponse getBatteriesFromPostCode(String startCode,String endCode);
}
