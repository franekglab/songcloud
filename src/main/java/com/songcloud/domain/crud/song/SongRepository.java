package com.songcloud.domain.crud.song;

import com.songcloud.domain.crud.song.Song;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

interface SongRepository extends Repository<Song, Long> {


    @Query("SELECT s from Song s")
    List<Song> findAll(Pageable pageable);

    @Query("SELECT s FROM Song s WHERE s.id = :id")
    Optional<Song> findById(Long id);

    @Modifying
    @Query("DELETE FROM Song s WHERE s.id = :id")
    void deleteById(Long id);

    @Modifying
    @Query("UPDATE Song s SET s.name = :#{#newSong.name} WHERE s.id = :id")
    void updateById(Long id, Song newSong);

    Song save(Song song);

    boolean existsById(Long id);

    @Modifying
    @Query("delete from Song s where s.id in :ids")
    int deleteByIdIn(Collection<Long> ids);
}
