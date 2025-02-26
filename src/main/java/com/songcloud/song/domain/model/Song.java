package com.songcloud.song.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Entity
@Getter
@Setter
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String songName;
    @Column(nullable = false)
    String artistName;

    public Song() {

    }

    public Song(String songName, String artistName) {
        this.songName = songName;
        this.artistName = artistName;
    }

    public Song(Long id, String songName, String artistName) {
        this.id = id;
        this.songName = songName;
        this.artistName = artistName;
    }
}
