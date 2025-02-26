package com.songcloud.song.infrastructure.controller;

import com.songcloud.song.infrastructure.controller.dto.request.CreateSongRequestDto;
import com.songcloud.song.infrastructure.controller.dto.request.PartiallyUpdateSongRequestDto;
import com.songcloud.song.infrastructure.controller.dto.request.UpdateSongRequestDto;
import com.songcloud.song.infrastructure.controller.dto.response.*;
import com.songcloud.song.domain.model.Song;
import org.springframework.http.HttpStatus;
import java.util.List;

public class SongMapper {

    public static Song mapFromCreateSongRequestDtoToSong(CreateSongRequestDto dto) {
        return new Song(dto.songName(), dto.artistName());
    }
    public static SongDto mapFromSongToSongDto(Song song) {
        return new SongDto(song.getId(), song.getSongName(), song.getArtistName());
    }

    public static CreateSongResponseDto mapFromSongToCreateSongResponseDto(Song song) {
        SongDto songDto = SongMapper.mapFromSongToSongDto(song);
        return new CreateSongResponseDto(songDto);
    }

    public static GetSongResponseDto mapFromSongToGetSongResponseDto(Song song) {
        SongDto songDto = SongMapper.mapFromSongToSongDto(song);
        return new GetSongResponseDto(songDto);
    }

    public static GetAllSongsResponseDto mapFromSongToGetAllSongsResponseDto(List<Song> songs) {
        List<SongDto> songDtos = songs.stream()
                .map(SongMapper::mapFromSongToSongDto).toList();
        return new GetAllSongsResponseDto(songDtos);
    }

    public static DeleteSongResponseDto mapFromSongToDeleteSongResponseDto(Long id) {
        return new DeleteSongResponseDto("You deleted song with id: " + id, HttpStatus.OK);
    }

    public static Song mapFromUpdateSongRequestDtoToSong(UpdateSongRequestDto dto) {
        return new Song(dto.songName(), dto.artistName());
    }

    public static UpdateSongResponseDto mapFromSongToUpdateSongResponseDto(Song newSong) {
        return new UpdateSongResponseDto(newSong.getSongName(), newSong.getArtistName());
    }

    public static Song mapFromPartiallyUpdateSongRequestDtoToSong(PartiallyUpdateSongRequestDto dto) {
        return new Song(dto.songName(), dto.artistName());
    }

    public static PartiallyUpdateSongResponseDto mapFromSongToPartiallyUpdateSongResponseDto(Song updatedSong) {
        SongDto songDto = SongMapper.mapFromSongToSongDto(updatedSong);
        return new PartiallyUpdateSongResponseDto(songDto);
    }


}
