package com.example.chaoliuzhikongspring.controller.repairController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.chaoliuzhikongspring.common.Result;
import com.example.chaoliuzhikongspring.entity.repairInfo;
import com.example.chaoliuzhikongspring.service.repair.repairService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/repair")
@CrossOrigin
public class repairController {
    @Autowired
    private repairService repairService;
    @PostMapping("/add")
    public Result addRepair(@RequestBody repairInfo repairInfo) {
        repairInfo.setRepairLogs(LocalDate.now());
       boolean res =  repairService.save(repairInfo);
       if (res) return Result.success("新增成功");
       else return Result.error("新增失败");
    }
    @PutMapping("/update")
//    0:待处理  1:处理中  2:已完成
    public Result updateRepair(@RequestParam Integer repairId,@RequestParam Integer repairStatus) {
        repairInfo repairInfo = repairService.getById(repairId);
        repairInfo.setRepairStatus(repairStatus);
//        更新状态
        boolean res = repairService.updateById(repairInfo);
        if(res) return Result.success("状态更新成功");
        else return Result.error("状态更新失败");
    }
    @DeleteMapping("/del")
    public Result delRepair(@RequestParam Integer repairId) {
        boolean res = repairService.removeById(repairId);
        if (res) return Result.success("删除成功");
        else return Result.error("删除失败");
    }
    @GetMapping("/page")
    public Result repairInfoPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
       IPage<repairInfo> res =  repairService.repairInfoPage(pageNum, pageSize);
       return Result.success(res);
    }

}
