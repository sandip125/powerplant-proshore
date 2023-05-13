package com.proshore.powerplant.services.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proshore.powerplant.dto.BatteryInfo;
import com.proshore.powerplant.dto.BatteryListResponse;
import com.proshore.powerplant.dto.BatteryRequest;
import com.proshore.powerplant.dto.BatteryResponse;
import com.proshore.powerplant.entity.Battery;
import com.proshore.powerplant.repository.BatteryRepository;
import com.proshore.powerplant.services.BatteryService;

@Service
public class BatteryServiceImpl implements BatteryService{

        private final BatteryRepository batteryRepository;
        


    @Autowired
    public BatteryServiceImpl(BatteryRepository batteryRepository) {
            this.batteryRepository = batteryRepository;
        }



    @Override
    public BatteryResponse addBatteries(BatteryRequest request) {
        List<Battery> batteries=setBatteries(request.getBatteryInfos());
       List<Battery> bList= batteryRepository.saveAll(batteries);
       BatteryResponse response=new BatteryResponse();
       response.setBatteryInfo(setBatteryResponse(bList));
        return response;
       
    }
    private List<BatteryInfo> setBatteryResponse(List<Battery> batteries){
        List<BatteryInfo> batteryInfos=new ArrayList<>();
        for (Battery battery : batteries) {
          BatteryInfo info=new BatteryInfo();
          info.setId(battery.getId());
          info.setName(battery.getName());
          info.setPostCode(battery.getPostCode());
          info.setWattCapacity(battery.getWattCapacity()); 
          batteryInfos.add(info); 
        }
        return batteryInfos;
    }

    private List<Battery> setBatteries(List<BatteryInfo> request){
       List<Battery> batteries=new ArrayList<>();
        for (BatteryInfo batteryInfo : request) {
            Battery battery=new Battery();
            battery.setName(batteryInfo.getName());
            battery.setPostCode(batteryInfo.getPostCode());
            battery.setWattCapacity(batteryInfo.getWattCapacity());
            batteries.add(battery);
        }
        return batteries;
    }



    @Override
    public BatteryListResponse getBatteriesFromPostCode(String startCode, String endCode) {
        List<Battery> batteries=batteryRepository.findByPostcodeRange(startCode, endCode);
        batteries.sort(Comparator.comparing(Battery::getName));
        double totalWattCapacity = batteries.stream().mapToDouble(Battery::getWattCapacity).sum();
        double averageWattCapacity = batteries.stream().mapToDouble(Battery::getWattCapacity).average().orElse(0.0);
        List<BatteryInfo> infos=setBatteryResponse(batteries);
        return BatteryListResponse.builder().averageWattCapacity(averageWattCapacity).total(totalWattCapacity).batteryInfos(infos).build();
    }
    
}
