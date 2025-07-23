package com.example.chaoliuzhikongspring.service.teamPlayerService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.chaoliuzhikongspring.entity.teamPlayerInfo;

public interface teamPlayerService extends IService<teamPlayerInfo> {
    IPage<teamPlayerInfo> selectPageList(Integer pageNum, Integer pageSize,Integer teamId);
}
