package com.songcloud.infrastructure.crud.song.controller;

import com.songcloud.domain.crud.song.SongDto;
import com.songcloud.infrastructure.crud.song.dto.request.CreateSongRequestDto;
import com.songcloud.infrastructure.crud.song.dto.request.PartiallyUpdateSongRequestDto;
import com.songcloud.infrastructure.crud.song.dto.request.UpdateSongRequestDto;
import com.songcloud.infrastructure.crud.song.dto.response.*;
import org.springframework.http.HttpStatus;

import java.util.List;

class SongControllerMapper {

    static SongDto mapFromCreateSongRequestDtoToSongDto(CreateSongRequestDto dto) {

        return SongDto
                .builder()
                .name(dto.songName())
                .build();
    }

    static SongDto mapFromUpdateSongRequestDtoToSongDto(UpdateSongRequestDto dto) {

        return SongDto
                .builder()
                .name(dto.songName())
                .build();
    }

    static SongDto mapFromPartiallyUpdateSongRequestDtoToSong(PartiallyUpdateSongRequestDto dto) {

        return SongDto
                .builder()
                .name(dto.songName())
                .build();
    }

    static CreateSongResponseDto mapFromSongToCreateSongResponseDto(SongDto songDto) {

        return new CreateSongResponseDto(songDto);
    }

    static DeleteSongResponseDto mapFromSongToDeleteSongResponseDto(Long id) {

        return new DeleteSongResponseDto("You deleted song with id: " + id, HttpStatus.OK);
    }

    static UpdateSongResponseDto mapFromSongToUpdateSongResponseDto(SongDto newSong) {

        return new UpdateSongResponseDto(newSong.name(), "testt");
    }

    static PartiallyUpdateSongResponseDto mapFromSongDtoToPartiallyUpdateSongResponseDto(SongDto songDto) {

        return new PartiallyUpdateSongResponseDto(songDto);
    }

    static GetSongResponseDto mapFromSongToGetSongResponseDto(SongDto songDto) {

        return new GetSongResponseDto(songDto);
    }

    static GetAllSongsResponseDto mapFromSongToGetAllSongsResponseDto(List<SongDto> songs) {

        return new GetAllSongsResponseDto(songs);
    }

}