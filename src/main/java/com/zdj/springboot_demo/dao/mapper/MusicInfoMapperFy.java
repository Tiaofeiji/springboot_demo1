package com.zdj.springboot_demo.dao.mapper;

import com.zdj.springboot_demo.dao.domain.MusicInfoPo;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

//mybatis分页
@Mapper
public interface MusicInfoMapperFy extends BaseMapper<MusicInfoPo> {
    int countByName(String name);
    List<MusicInfoPo> selectAll();

    @Override
    int insert(MusicInfoPo musicInfoPo);
}
