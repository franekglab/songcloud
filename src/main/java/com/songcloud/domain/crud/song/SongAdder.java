package com.songcloud.domain.crud.song;

import com.songcloud.domain.crud.dto.SongDto;
import com.songcloud.domain.crud.dto.SongLanguageDto;
import com.songcloud.domain.crud.dto.SongRequestDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Instant;

@AllArgsConstructor(access = lombok.AccessLevel.PACKAGE)
@Log4j2
@Service
class SongAdder {

    private final SongRepository songRepository;

    SongDto addSong(final SongRequestDto songDto) {
        SongLanguageDto language = songDto.language();
        SongLanguage songLanguage = SongLanguage.valueOf(language.name());
        Song song = new Song(songDto.name(), songDto.releaseDate(), songDto.duration(), songLanguage);
        log.info("adding new song: " + songDto);
        Song save = songRepository.save(song);
        return new SongDto(save.getId(), save.getName());
    }


}
