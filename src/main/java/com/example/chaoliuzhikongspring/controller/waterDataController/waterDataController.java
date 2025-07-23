package com.example.chaoliuzhikongspring.controller.waterDataController;

import com.example.chaoliuzhikongspring.common.Result;
import com.example.chaoliuzhikongspring.entity.waterInfo;
import com.example.chaoliuzhikongspring.service.waterData.waterDataservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class waterDataController {
    @Autowired
    private waterDataservice waterDataservice;

    @GetMapping("/water/total/{id}")
    public Result waterTotal(@PathVariable String id){
        waterInfo WaterInfo = waterDataservice.mygetById(id);
        return Result.success(WaterInfo);
    }
}
