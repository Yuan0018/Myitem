package com.example.chaoliuzhikongspring.service.historyOperation;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chaoliuzhikongspring.entity.historyInfo;
import com.example.chaoliuzhikongspring.mapper.historyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class historyServiceImpl extends ServiceImpl<historyMapper, historyInfo> implements historyService {
    @Autowired
    private historyMapper historyMapper;

    @Override
    public historyInfo saveAddhistory(String id){
        historyInfo historyInfo = new historyInfo();
        historyInfo.setUserid(id);
        historyInfo.setOperation("注册账号");
        historyInfo.setOperationtime(LocalDateTime.now());
//        保存注册记录
        return historyInfo;
    }

    @Override
    public historyInfo AdmindelAddhistory(String delid,String deladmin) {
        historyInfo historyInfo = new historyInfo();
        historyInfo.setUserid(deladmin);
        historyInfo.setOperation("管理员删除账号"+delid);
        historyInfo.setOperationtime(LocalDateTime.now());
        return historyInfo;
    }

    @Override
    public historyInfo AdminchangeAddhistory(String changeid,String changeadmin) {
        historyInfo historyInfo = new historyInfo();
        historyInfo.setUserid(changeadmin);
        historyInfo.setOperation("管理员修改信息"+changeid);
        historyInfo.setOperationtime(LocalDateTime.now());
        return historyInfo;
    }
    @Override
    public historyInfo loginAddhistory(String id,String permission) {
        historyInfo historyInfo = new historyInfo();
        historyInfo.setUserid(id);
        if (permission.equals("0")) historyInfo.setOperation("普通用户登录账号");
        if (permission.equals("1")) historyInfo.setOperation("企业用户登录账号");
        if (permission.equals("2")) historyInfo.setOperation("运维工程师登录账号");
        if (permission.equals("3")) historyInfo.setOperation("系统管理员登录账号");
        historyInfo.setOperationtime(LocalDateTime.now());
        return historyInfo;
    }



    @Override
    public IPage<historyInfo> getHistoryPage(Integer pageNum,Integer pageSize) {
        Page<historyInfo> page = new Page<>(pageNum,pageSize);
        IPage<historyInfo> Ipage = historyMapper.selectPage(page,null);
        return Ipage;
    }
}
