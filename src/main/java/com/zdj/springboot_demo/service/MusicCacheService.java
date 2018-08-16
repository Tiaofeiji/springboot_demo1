package com.zdj.springboot_demo.service;

import com.zdj.springboot_demo.dao.domain.MusicInfoPo;

public interface MusicCacheService {
    /**
     * 删除
     *
     * @param user 用户对象
     * @return 操作结果
     */
    MusicInfoPo saveOrUpdate(MusicInfoPo user);

    /**
     * 添加
     *
     * @param id key值
     * @return 返回结果
     */
    MusicInfoPo get(Integer id);

    /**
     * 删除
     *
     * @param id key值
     */
    void delete(Integer id);
}
