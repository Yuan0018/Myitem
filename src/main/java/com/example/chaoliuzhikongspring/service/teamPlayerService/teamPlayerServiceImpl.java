package com.example.chaoliuzhikongspring.service.teamPlayerService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chaoliuzhikongspring.entity.teamPlayerInfo;
import com.example.chaoliuzhikongspring.mapper.teamPlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class teamPlayerServiceImpl extends ServiceImpl<teamPlayerMapper, teamPlayerInfo> implements teamPlayerService {
    @Autowired
    private teamPlayerMapper teamPlayerMapper;

    @Override
    public IPage<teamPlayerInfo> selectPageList(Integer pageNum, Integer pageSize,Integer teamId) {
        Page<teamPlayerInfo> page = new Page<>(pageNum, pageSize);
        // 2. 构建查询条件（类似 WHERE 子句）
        QueryWrapper<teamPlayerInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("team_id",teamId);
        return teamPlayerMapper.selectPage(page, queryWrapper);
    }
}
