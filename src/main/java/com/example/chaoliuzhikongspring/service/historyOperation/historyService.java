package com.example.chaoliuzhikongspring.service.historyOperation;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.chaoliuzhikongspring.entity.historyInfo;

public interface historyService extends IService<historyInfo> {
    historyInfo saveAddhistory(String id);
    historyInfo loginAddhistory(String id,String permission);
    historyInfo AdmindelAddhistory(String delid,String deladmin);
    historyInfo AdminchangeAddhistory(String changeid,String changeadmin);

    IPage<historyInfo> getHistoryPage(Integer pageNum,Integer pageSize);

}
