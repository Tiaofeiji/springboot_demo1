package com.zdj.springboot_demo;

import com.zdj.springboot_demo.dao.domain.MusicInfoPo;
import com.zdj.springboot_demo.service.MusicCacheService;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCache {
    private static final Logger log = LoggerFactory.getLogger(TestCache.class);
    @Autowired
    private MusicCacheService musicCacheService;


    @org.junit.Test
    public void get() {
        MusicInfoPo mu = new MusicInfoPo("5", "u5", "p5");
        mu.setId(5);
        final MusicInfoPo musicInfoPo = musicCacheService.saveOrUpdate(mu);
        log.info("[saveOrUpdate] - [{}]", musicInfoPo);
        final MusicInfoPo musicInfoPo1 = musicCacheService.get(5);
        log.info("[get] - [{}]", musicInfoPo1);
        musicCacheService.delete(5);
    }
}
