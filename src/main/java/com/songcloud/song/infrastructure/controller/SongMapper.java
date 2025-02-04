package com.songcloud.song.infrastructure.controller;

import com.songcloud.song.infrastructure.controller.dto.request.CreateSongRequestDto;
import com.songcloud.song.infrastructure.controller.dto.request.PartiallyUpdateSongRequestDto;
import com.songcloud.song.infrastructure.controller.dto.request.UpdateSongRequestDto;
import com.songcloud.song.infrastructure.controller.dto.response.*;
import com.songcloud.song.domain.model.Song;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class SongMapper {

    public static Song mapFromCreateSongRequestDtoToSong(CreateSongRequestDto dto) {
        return new Song(dto.songName(), dto.artistName());
    }

    public static CreateSongResponseDto mapFromSongToCreateSongResponseDto(Song song) {
        return new CreateSongResponseDto(song);
    }

    public static GetSongResponseDto mapFromSongToGetSongResponseDto(Song song) {
        return new GetSongResponseDto(song);
    }

    public static GetAllSongsResponseDto mapFromSongToGetAllSongsResponseDto(Map<Integer, Song> database) {
        return new GetAllSongsResponseDto(database);
    }

    public static DeleteSongResponseDto mapFromSongToDeleteSongResponseDto(Integer id) {
        return new DeleteSongResponseDto("You deleted song with id: " + id, HttpStatus.OK);
    }

    public static Song mapFromUpdateSongRequestDtoToSong(UpdateSongRequestDto dto) {
        return new Song(dto.songName(), dto.artistName());
    }

    public static UpdateSongResponseDto mapFromSongToUpdateSongResponseDto(Song newSong) {
        return new UpdateSongResponseDto(newSong.songName(), newSong.artistName());
    }

    public static Song mapFromPartiallyUpdateSongRequestDtoToSong(PartiallyUpdateSongRequestDto dto) {
        return new Song(dto.songName(), dto.artistName());
    }

    public static PartiallyUpdateSongResponseDto mapFromSongToPartiallyUpdateSongResponseDto(Song updatedSong) {
        return new PartiallyUpdateSongResponseDto(updatedSong);
    }


}
