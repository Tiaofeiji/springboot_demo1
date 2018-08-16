package com.zdj.springboot_demo.service.impl;

import com.zdj.springboot_demo.dao.domain.MusicInfo;
import com.zdj.springboot_demo.dao.mapper.MusicInfoMapper;
import com.zdj.springboot_demo.service.MusicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicInfoServiceImpl implements MusicInfoService {
    @Autowired
    private MusicInfoMapper musicInfoMapper;

    @Override
    public List<MusicInfo> getMusicInfo(MusicInfo musicInfo) {
        List<MusicInfo> musicInfos = musicInfoMapper.selectAll(null);
        return musicInfos;
    }

    @Override
    public MusicInfo getMusicInfoByname(String name) {
        MusicInfo musicInfo = musicInfoMapper.findByUsername(name);
        return musicInfo;
    }
}
