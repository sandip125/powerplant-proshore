package com.proshore.powerplant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proshore.powerplant.dto.BatteryListResponse;
import com.proshore.powerplant.dto.BatteryRequest;
import com.proshore.powerplant.dto.BatteryResponse;
import com.proshore.powerplant.services.BatteryService;

@RestController
@RequestMapping(value  = "batteries")
public class BatteryController {
    

    private BatteryService batteryService;

    @Autowired
    public BatteryController(BatteryService batteryService) {
        this.batteryService = batteryService;
    }

    @PostMapping(value = "/add")
    private BatteryResponse addBatteries(@RequestBody BatteryRequest request){
        return batteryService.addBatteries(request);
    }

    @GetMapping(params = {"startPostcode", "endPostcode"})
    private BatteryListResponse getBatteryListWithStatistics(@RequestParam("startPostcode") String startPostcode,
    @RequestParam("endPostcode") String endPostcode){
        return batteryService.getBatteriesFromPostCode(startPostcode, endPostcode);
    }
    
}
