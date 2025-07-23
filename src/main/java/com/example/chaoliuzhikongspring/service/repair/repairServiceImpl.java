package com.example.chaoliuzhikongspring.service.repair;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chaoliuzhikongspring.entity.deviceInfo;
import com.example.chaoliuzhikongspring.entity.repairInfo;
import com.example.chaoliuzhikongspring.mapper.repairMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class repairServiceImpl extends ServiceImpl<repairMapper, repairInfo> implements repairService {
    @Autowired
    private repairMapper repairMapper;
    @Override
    public IPage<repairInfo> repairInfoPage(Integer pageNum, Integer pageSize){
        Page<repairInfo> page = new Page<>(pageNum, pageSize);
        return repairMapper.selectPage(page, null);
    }
    @Override
    public int setRepairstatus(Integer repair_id,Integer status) {
        // 1. 创建更新条件构造器
        UpdateWrapper<repairInfo> updateWrapper = new UpdateWrapper<>();
        // 2. 设置更新条件：例如 repair = 目标值（这里假设目标值为100）
        updateWrapper.eq("repair_id", repair_id);
        // 3. 设置要更新的字段：将 status 改为1
        updateWrapper.set("repair_status", status);
        return repairMapper.update(null,updateWrapper);
    }
}
