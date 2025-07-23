package com.example.chaoliuzhikongspring.service.teamService;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.chaoliuzhikongspring.entity.teamInfo;

public interface teamService extends IService<teamInfo> {
    IPage<teamInfo> getPageList(Integer pageNum, Integer pageSize);
    int updateTeamStatus(Integer teamid,Integer status,Integer repair_id);
}
