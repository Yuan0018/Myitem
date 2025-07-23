package com.example.chaoliuzhikongspring.service.repair;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.chaoliuzhikongspring.entity.repairInfo;

public interface repairService extends IService<repairInfo> {
        IPage<repairInfo> repairInfoPage(Integer pageNum, Integer pageSize);
        int setRepairstatus(Integer repair_id,Integer status);
}
