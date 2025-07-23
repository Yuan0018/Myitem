package com.example.chaoliuzhikongspring.controller.deviceDataController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.chaoliuzhikongspring.common.Result;
import com.example.chaoliuzhikongspring.entity.deviceInfo;
import com.example.chaoliuzhikongspring.service.deviceService.deviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device")
@CrossOrigin
public class deviceController {
    @Autowired
    private deviceService deviceService;
    public String ranDomId(){
//        随机十位数ID
        long randomNum = (long) (Math.random() * 10000000000L);
        String id = String.format("%010d", randomNum);
        return id;
    }
    @PostMapping("/add")
//    设备新增
    public Result addData(@RequestBody deviceInfo deviceInfo){
        deviceInfo.setDeviceId(ranDomId());
        boolean res =  deviceService.save(deviceInfo);
        if(res) return Result.success("设备数据新增成功");
        return Result.error("设备数据新增失败");
    }
    @DeleteMapping("/del/{deviceId}")
//    设备删除
    public Result delData(@PathVariable String deviceId){
        boolean res = deviceService.removeById(deviceId);
        if (res) return Result.success("删除成功");
        else return Result.error("删除失败");
    }
    @PutMapping("/revise")
//    设备修改
    public Result reviseDataById(@RequestBody deviceInfo deviceInfo){
        boolean res = deviceService.updateById(deviceInfo);
        if(res) return Result.success("修改成功");
        else return Result.error("修改失败");
    }
    @GetMapping("/get")
//    设备分页查询
    public Result getPageData(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        IPage<deviceInfo> res = deviceService.getPageData(pageNum,pageSize);
        return Result.success(res);
    }
//    设备在线查询
    @GetMapping("/online")
    public Result getOnlineData(){
        long res = deviceService.onlineCount();
        return Result.success(res);
    }
//    设备总数查询
    @GetMapping("/total")
    public Result getTotalData(){
        long res = deviceService.totalCount();
        return Result.success(res);
    }
//    根据设备ID查询设备数据
    @GetMapping("/{deviceId}")
    public Result getData(@PathVariable String deviceId){
        deviceInfo res = deviceService.getById(deviceId);
        if (res != null) return Result.success(res);
        else return Result.error("查询失败");
    }
}
