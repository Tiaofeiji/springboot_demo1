package com.zdj.springboot_demo.service;

import com.zdj.springboot_demo.dao.domain.MusicInfo;

import java.util.List;

public interface MusicInfoService {
    public List<MusicInfo> getMusicInfo(MusicInfo musicInfo);
    public MusicInfo getMusicInfoByname(String name);

}
