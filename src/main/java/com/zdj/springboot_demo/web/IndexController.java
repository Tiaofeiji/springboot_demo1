package com.zdj.springboot_demo.web;

import com.zdj.springboot_demo.dao.domain.Book;
import com.zdj.springboot_demo.dao.domain.MusicInfoPo;
import com.zdj.springboot_demo.dao.domain.MusicInfo;
import com.zdj.springboot_demo.dao.mapper.MusicRepository;
import com.zdj.springboot_demo.exception.CustomException;
import com.zdj.springboot_demo.groups.Groups;
import com.zdj.springboot_demo.service.MusicInfoService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Validated
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
    @RequestMapping("/chatroom")
    public String chatroom() {
        return "chatroom";
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
    @RequestMapping("/test")
    @ResponseBody
    public String test(Integer num) {
        if (num == null) {
            throw new CustomException(400, "num不能为空");
        }
        int i = 10 / num;
        return "result:" + i;
    }
    @GetMapping("/test2")
    @ResponseBody
    public String test2(@NotBlank(message = "name 不能为空") @Length(min = 2, max = 10, message = "name 长度必须在 {min} - {max} 之间") String name) {
        return "success";
    }

    @GetMapping("/test3")
    @ResponseBody
    public String test3(@Validated Book book) {
        return "success";
    }

    @GetMapping("/insertBook")
    @ResponseBody
    public String insert(@Validated(value = Groups.Default.class) Book book) {
        return "insert";
    }

    @GetMapping("/updateBook")
    @ResponseBody
    public String update(@Validated(value = {Groups.Default.class, Groups.Update.class}) Book book) {
        return "update";
    }
}
