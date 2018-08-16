package com.zdj.springboot_demo.web;

import com.zdj.springboot_demo.dao.domain.MusicInfoPo;
import com.zdj.springboot_demo.dao.domain.MusicInfo;
import com.zdj.springboot_demo.dao.mapper.MusicRepository;
import com.zdj.springboot_demo.service.MusicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private MusicInfoService musicInfoService;
    @Autowired
    private MusicRepository musicRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/show")
    public String getIndex() {
        return "index";
    }
    @RequestMapping("/music")
    @ResponseBody
    public List<MusicInfo> getMusicInfo() {
        List<MusicInfo> musicInfoList = musicInfoService.getMusicInfo(null);
        //jdbc访问
        //List<MusicInfo> musicInfoList = this.jdbcTemplate.query("select * from music_info", new BeanPropertyRowMapper(MusicInfo.class));
        MusicInfo musicInfot = (MusicInfo)this.jdbcTemplate.queryForObject("select * from music_info  WHERE id = ?",new BeanPropertyRowMapper(MusicInfo.class),new Object[] { 1 });
        return musicInfoList;
    }
    @RequestMapping("/music1")
    @ResponseBody
    public MusicInfo getMusicInfo(String id) {
        //jdbc访问
        MusicInfo musicInfot = (MusicInfo)this.jdbcTemplate.queryForObject("select * from music_info  WHERE id = ?",new BeanPropertyRowMapper(MusicInfo.class),new Object[] { id });
        return musicInfot;
    }
    @RequestMapping("/music2")
    @ResponseBody
    public MusicInfoPo getMusicInfo1(String id) {
        //hibernate
        MusicInfoPo musicInfot = musicRepository.findByMusicName("忘情水");
        MusicInfoPo mp = new MusicInfoPo();
        mp.setMusicName("123");
        mp.setMusicSize("32M");
        mp.setSingerName("aaa");
        musicRepository.save(mp);
        return musicInfot;
    }
    @RequestMapping("/music3")
    @ResponseBody
    public MusicInfo getMusicInfoByname(@RequestParam(name="name") String musicname) {
        MusicInfo musicInfo = musicInfoService.getMusicInfoByname(musicname);
        return musicInfo;
    }
}
