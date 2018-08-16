package com.zdj.springboot_demo.service.impl;

import com.zdj.springboot_demo.dao.domain.MusicInfoPo;
import com.zdj.springboot_demo.service.MusicCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class MusicCacheServiceimpl implements MusicCacheService {
    private static final Map<Integer, MusicInfoPo> DATABASES = new HashMap<>();

    static {
        DATABASES.put(1, new MusicInfoPo("1", "u1", "p1"));
        DATABASES.put(2, new MusicInfoPo("2", "u2", "p2"));
        DATABASES.put(3, new MusicInfoPo("3", "u3", "p3"));
    }


    private static final Logger log = LoggerFactory.getLogger(MusicCacheServiceimpl.class);

    @Cacheable(value = "musicInfoPo", key = "#id")
    @Override
    public MusicInfoPo get(Integer id) {
        // TODO 我们就假设它是从数据库读取出来的
        log.info("进入 get 方法");
        return DATABASES.get(id);
    }

    @CachePut(value = "musicInfoPo", key = "#musicInfoPo.id")
    @Override
    public MusicInfoPo saveOrUpdate(MusicInfoPo musicInfoPo) {
        DATABASES.put(musicInfoPo.getId(), musicInfoPo);
        log.info("进入 saveOrUpdate 方法");
        return musicInfoPo;
    }

    @CacheEvict(value = "musicInfoPo", key = "#id")
    @Override
    public void delete(Integer id) {
        DATABASES.remove(id);
        log.info("进入 delete 方法");
    }
}
