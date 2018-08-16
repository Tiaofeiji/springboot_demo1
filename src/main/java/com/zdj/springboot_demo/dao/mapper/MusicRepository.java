package com.zdj.springboot_demo.dao.mapper;

import com.zdj.springboot_demo.dao.domain.MusicInfoPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<MusicInfoPo,String> {
    MusicInfoPo findByMusicName(String name);
}
