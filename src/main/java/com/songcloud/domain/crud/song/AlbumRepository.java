package com.songcloud.domain.crud.song;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

interface AlbumRepository extends Repository<Album, Long> {

    Album save(Album album);

    @Query("""
            select a from Album a
            join fetch a.songs songs
            join fetch a.artists artists
            where a.id = :id
            """)
    Optional<Album> findAlbumByIdWithSongsAndArtists(Long id);

    @Query("""
            select a from Album a
            inner join a.artists artists
            where artists.id = :id
            """)
    Set<Album> findAllAlbumsByArtistId(Long id);

    @Modifying
    @Query("delete from Album a where a.id in :ids")
    int deleteByIdIn(Collection<Long> ids);

    Optional<Album> findById(Long id);
}
