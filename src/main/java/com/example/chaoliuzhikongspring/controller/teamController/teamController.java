package com.example.chaoliuzhikongspring.controller.teamController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.chaoliuzhikongspring.common.Result;
import com.example.chaoliuzhikongspring.entity.teamInfo;
import com.example.chaoliuzhikongspring.entity.teamPlayerInfo;
import com.example.chaoliuzhikongspring.service.repair.repairService;
import com.example.chaoliuzhikongspring.service.teamPlayerService.teamPlayerService;
import com.example.chaoliuzhikongspring.service.teamService.teamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
@CrossOrigin
public class teamController {
    @Autowired
    private teamService teamService;
    @Autowired
    private teamPlayerService teamPlayerService;
    @Autowired
    private repairService repairService;
    @PostMapping("/add")
//    新增团队
    public Result addTeam(@RequestBody teamInfo team) {
        boolean res = teamService.save(team);
        if (res) return Result.success("新增成功");
        else return Result.error("新增失败");
    }
//    根据团队ID修改团队
    @PutMapping("/update")
    public Result updateTeam(@RequestBody teamInfo team) {
        boolean res = teamService.updateById(team);
        if (res) return Result.success("修改成功");
        else return Result.error("修改失败");
    }
//    删除团队
    @DeleteMapping("/del/{teamId}")
    public Result delTeam(@PathVariable Integer teamId) {
        boolean res = teamService.removeById(teamId);
        if (res) return Result.success("删除成功");
        else return Result.error("删除失败");
    }
//    分页查询团队信息
    @GetMapping("/page")
    public Result getPageList(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        IPage<teamInfo> page = teamService.getPageList(pageNum,pageSize);
        return Result.success(page);
    }
//   根据团队ID分页查询团队队员数据
    @GetMapping("/player")
    public Result getPageList(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam Integer teamId){
       IPage<teamPlayerInfo> res = teamPlayerService.selectPageList(pageNum,pageSize,teamId);
       return Result.success(res);
    }
//  团队下新增队员
    @PostMapping("/player/add")
    public Result addTeamPlayer(@RequestBody teamPlayerInfo teamPlayer) {
        boolean res = teamPlayerService.save(teamPlayer);
        if (res) return Result.success("新增成功");
        else return Result.error("新增失败");
    }
//  根据团队队员ID修改团队队员信息
    @PostMapping("/player/update")
    public Result updateTeamPlayer(@RequestBody teamPlayerInfo teamPlayer) {
        boolean res = teamPlayerService.updateById(teamPlayer);
        if (res) return Result.success("修改成功");
        else  return Result.error("修改失败");
    }
//  删除队员
    @DeleteMapping("/player/del/{playerId}")
    public Result delTeamPlayer(@PathVariable Integer playerId) {
       boolean res = teamPlayerService.removeById(playerId);
       if (res) return Result.success("删除成功");
       else return Result.error("删除失败");
    }
//   派遣团队
    @PutMapping("/dispatch")
    public Result dispatchTeam(@RequestParam Integer teamid,@RequestParam Integer repair_id) {
//      修改团队状态      0：空闲中  1：维修中
        int teamres = teamService.updateTeamStatus(teamid,1,repair_id);
        //        修改报修订单状态至 0:待处理  1：处理中   2：已完成
        int res =   repairService.setRepairstatus(repair_id,1);
        if(teamres==1&&res==1) return Result.success("派遣成功");
        else return Result.error("派遣失败");
    }
//  维修完成更新团队和维修订单状态
    @PutMapping("/updateTeamRepair")
    public Result updateTeam(@RequestParam Integer teamid,@RequestParam Integer repair_id) {
        int teamres = teamService.updateTeamStatus(teamid,0,null);
        int res =   repairService.setRepairstatus(repair_id,2);
        if (teamres==1&&res==1) return Result.success("更新成功");
        else return Result.error("更新失败");
    }
}
