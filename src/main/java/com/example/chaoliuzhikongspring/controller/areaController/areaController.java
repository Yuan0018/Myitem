package com.example.chaoliuzhikongspring.controller.areaController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.chaoliuzhikongspring.common.Result;
import com.example.chaoliuzhikongspring.entity.areaInfo;
import com.example.chaoliuzhikongspring.service.areaService.areaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/area")
public class areaController {
    @Autowired
    private areaService areaService;
//    区域分页查询
    @GetMapping("/page")
    public Result pageArea(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
       IPage<areaInfo> res = areaService.pageArea(pageNum,pageSize);
       return Result.success(res);
    }
//    根据团队ID修改区域团队分配
    @PutMapping("/team")
    public Result updateAreaTeam(@RequestParam Integer areaId, @RequestParam Integer teamId) {
        boolean res = areaService.sendteam(areaId,teamId);
        if (res) return Result.success(res);
        else return Result.error("修改失败");
    }
//    根据区域ID修改区域信息
    @PutMapping("/update")
    public Result updateArea(@RequestBody areaInfo areaInfo) {
        boolean res = areaService.updateById(areaInfo);
        if (res) return Result.success(res);
        else return Result.error("修改失败");
    }
//  新增区域信息
    @PostMapping("/add")
    public Result addArea(@RequestBody areaInfo areaInfo) {
        boolean res = areaService.save(areaInfo);
        if (res) return Result.success("新增成功");
        else return Result.error("新增失败");
    }
//  删除区域信息
    @DeleteMapping("/del/{areaId}")
    public Result deleteArea(@PathVariable Integer areaId) {
        boolean res = areaService.removeById(areaId);
        if (res) return Result.success(res);
        else return Result.error("删除失败");
    }
}
