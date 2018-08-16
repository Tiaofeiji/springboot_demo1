package com.zdj.springboot_demo.dao.mapper;

import com.zdj.springboot_demo.dao.domain.MusicInfo;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MusicInfoMapper {
    @ResultMap("BaseResultMap")
    @Select("select * from music_info")
    List<MusicInfo> selectAll(MusicInfo musicInfo);

    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM music_info WHERE music_name = #{music_name}")
    MusicInfo findByUsername(@Param("music_name") String music_name);
}
