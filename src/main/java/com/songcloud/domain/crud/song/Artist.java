package com.songcloud.domain.crud.song;

import com.songcloud.domain.crud.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
class Artist extends BaseEntity {

    @Id
    @GeneratedValue(generator = "artist_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "artist_id_seq", sequenceName = "artist_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    private Set<Album> albums = new HashSet<>();

    public Artist(String name) {
        this.name = name;
    }

    void removeAlbum(Album album) {
        albums.remove(album);
    }

    void addAlbum(Album album) {
        albums.add(album);
        album.addArtist(this);
    }
}
