package com.example.chaoliuzhikongspring.controller.historyDataController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.chaoliuzhikongspring.common.Result;
import com.example.chaoliuzhikongspring.entity.historyInfo;
import com.example.chaoliuzhikongspring.service.historyOperation.historyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class historyDataController {
    @Autowired
    private historyService historyService;
    @GetMapping("/history")
    public Result getHistory(@RequestParam Integer pageNum, @RequestParam Integer pageSize ){
        IPage<historyInfo> Ipage =  historyService.getHistoryPage(pageNum,pageSize);
        return Result.success(Ipage);
    }
    @DeleteMapping("/history/del/{history_id}")
    public Result del(@PathVariable Integer history_id){
        boolean res = historyService.removeById(history_id);
        if (res) return Result.success("成功删除");
        else return Result.error("删除失败");
    }
}
