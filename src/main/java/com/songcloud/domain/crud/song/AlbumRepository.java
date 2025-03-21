package com.songcloud.domain.crud.song;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface AlbumRepository extends Repository<Album, Long> {

    Album save(Album album);

    @Query("""
            select a from Album a
            join fetch a.songs songs
            join fetch a.artists artists
            where a.id = :id
            """)
    Optional<Album> findAlbumByIdWithSongsAndArtists(Long id);
}
