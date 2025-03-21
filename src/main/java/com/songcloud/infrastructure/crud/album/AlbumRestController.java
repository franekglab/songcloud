package com.songcloud.infrastructure.crud.album;

import com.songcloud.domain.crud.dto.*;
import com.songcloud.domain.crud.song.SongcloudCrudFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/albums")
public class AlbumRestController {

    private final SongcloudCrudFacade songFacade;

    @PostMapping("/createAlbum")
    ResponseEntity<AlbumDto> postAlbum(@RequestBody AlbumRequestDto request) {
        AlbumDto savedAlbum = songFacade.addAlbumWithSong(request);
        return ResponseEntity.ok(savedAlbum);
    }

    @GetMapping("/{albumId}")
    ResponseEntity<AlbumDtoWithArtistsAndSongs> getAlbumWithArtistsAndSongs(@PathVariable Long albumId) {
        AlbumDtoWithArtistsAndSongs albumWithArtistsAndSongs = songFacade.findAlbumByIdWithArtistsAndSongs(albumId);
        return ResponseEntity.ok(albumWithArtistsAndSongs);
    }


}
