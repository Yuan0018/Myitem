package com.example.chaoliuzhikongspring.service.areaService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.chaoliuzhikongspring.common.Result;
import com.example.chaoliuzhikongspring.entity.UserInfo;
import com.example.chaoliuzhikongspring.entity.areaInfo;
import org.springframework.web.bind.annotation.RequestParam;

public interface areaService extends IService<areaInfo> {
    IPage<areaInfo> pageArea(Integer pageNum, Integer pageSize);
    boolean sendteam(Integer areaId, Integer teamId);

}
