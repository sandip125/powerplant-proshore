package com.proshore.powerplant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proshore.powerplant.entity.Battery;

@Repository
public interface BatteryRepository extends JpaRepository<Battery,Long>{
    @Query(value = "SELECT b FROM Battery b WHERE b.postCode BETWEEN :startPostcode AND :endPostcode")
    List<Battery> findByPostcodeRange(@Param("startPostcode") String startPostcode,@Param("endPostcode") String endPostcode);
}
