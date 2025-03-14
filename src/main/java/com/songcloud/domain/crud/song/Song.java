package com.songcloud.domain.crud.song;

import com.songcloud.domain.crud.util.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Builder
@Entity
@Getter
@Setter
@Table(name = "song")
@NoArgsConstructor
@AllArgsConstructor
class Song extends BaseEntity {

    @Id
    @GeneratedValue(generator = "song_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "song_id_seq", sequenceName = "song_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String artist;

    private Instant releaseDate;

    private Long duration;

    @Enumerated(EnumType.STRING)
    private SongLanguage language;

    public Song(String name) {
        this.name = name;
    }

}
