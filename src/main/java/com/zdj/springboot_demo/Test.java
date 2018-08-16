package com.zdj.springboot_demo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zdj.springboot_demo.dao.domain.MusicInfoPo;
import com.zdj.springboot_demo.dao.mapper.MusicInfoMapperFy;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    private static final Logger log = LoggerFactory.getLogger(Test.class);

    @Autowired
    private MusicInfoMapperFy musicMapper;

    @org.junit.Test
    public void test1() throws Exception {
        final MusicInfoPo MusicInfoPo1 = new MusicInfoPo("u1", "p1","w1");
        final MusicInfoPo MusicInfoPo2 = new MusicInfoPo("u1", "p2","w1");
        final MusicInfoPo MusicInfoPo3 = new MusicInfoPo("u3", "p3","w1");
/*        musicMapper.insertSelective(MusicInfoPo1);
        log.info("[MusicInfoPo1回写主键] - [{}]", MusicInfoPo1.getId());
        musicMapper.insertSelective(MusicInfoPo2);
        log.info("[MusicInfoPo2回写主键] - [{}]", MusicInfoPo2.getId());
        musicMapper.insertSelective(MusicInfoPo3);
        log.info("[MusicInfoPo3回写主键] - [{}]", MusicInfoPo3.getId());*/
        final int count = musicMapper.countByName("u1");
        log.info("[调用自己写的SQL] - [{}]", count);
        List<MusicInfoPo> list = this.musicMapper.selectAll();

        // TODO 模拟分页
       /* musicMapper.insert(new MusicInfoPo("u1", "p1","w1"));
        musicMapper.insert(new MusicInfoPo("u1", "p1","w1"));
        musicMapper.insert(new MusicInfoPo("u1", "p1","w1"));
        musicMapper.insert(new MusicInfoPo("u1", "p1","w1"));
        musicMapper.insert(new MusicInfoPo("u1", "p1","w1"));
        musicMapper.insert(new MusicInfoPo("u1", "p1","w1"));
        musicMapper.insert(new MusicInfoPo("u1", "p1","w1"));
        musicMapper.insert(new MusicInfoPo("u1", "p1","w1"));
        musicMapper.insert(new MusicInfoPo("u1", "p1","w1"));
        musicMapper.insert(new MusicInfoPo("u1", "p1","w1"));*/
        // TODO 分页 + 排序 this.musicMapper.selectAll() 这一句就是我们需要写的查询，有了这两款插件无缝切换各种数据库
        final PageInfo<Object> pageInfo = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPageInfo(() -> this.musicMapper.selectAll());
        log.info("[lambda写法] - [分页信息] - [{}]", pageInfo.toString());

        PageHelper.startPage(1, 10).setOrderBy("id desc");
        final PageInfo<MusicInfoPo> MusicInfoPoPageInfo = new PageInfo<>(this.musicMapper.selectAll());
        log.info("[普通写法] - [{}]", MusicInfoPoPageInfo);
    }
}
