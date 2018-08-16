package com.zdj.springboot_demo.dao.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "music_info")
public class MusicInfoPo implements Serializable {
    private static final long serialVersionUID = 8655851615465363473L;
    // 主键id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 歌手名
    @Column(name="singer_name")
    private String singerName;

    // 歌曲大小
    @Column(name="music_size")
    private String musicSize;

    // 歌曲名
    @Column(name="music_name")
    private String musicName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getMusicSize() {
        return musicSize;
    }

    public void setMusicSize(String musicSize) {
        this.musicSize = musicSize;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public MusicInfoPo(String singerName, String musicSize, String musicName) {
        this.singerName = singerName;
        this.musicSize = musicSize;
        this.musicName = musicName;
    }

    public MusicInfoPo() {
    }
}
