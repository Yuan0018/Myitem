package com.example.chaoliuzhikongspring.service.teamService;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chaoliuzhikongspring.entity.teamInfo;
import com.example.chaoliuzhikongspring.mapper.teamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class teamServiceImpl extends ServiceImpl<teamMapper, teamInfo> implements teamService {
    @Autowired
    private teamMapper teamMapper;
    @Override
    public IPage<teamInfo> getPageList(Integer pageNum,Integer pageSize){
        Page<teamInfo> page = new Page<>(pageNum,pageSize);
        return teamMapper.selectPage(page,null);
    }
    @Override
    public int updateTeamStatus(Integer teamid,Integer status,Integer repair_id) {
        UpdateWrapper<teamInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("team_id",teamid);
        updateWrapper.set("team_status",status);
        updateWrapper.set("repair_id",repair_id);
        return teamMapper.update(updateWrapper);
    }
}
