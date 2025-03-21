package com.songcloud.infrastructure.crud.album;

import com.songcloud.domain.crud.dto.AlbumDto;
import com.songcloud.domain.crud.dto.AlbumRequestDto;
import com.songcloud.domain.crud.dto.ArtistDto;
import com.songcloud.domain.crud.dto.ArtistRequestDto;
import com.songcloud.domain.crud.song.SongcloudCrudFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/album")
public class AlbumRestController {

    private final SongcloudCrudFacade songFacade;

    @PostMapping("/createAlbum")
    ResponseEntity<AlbumDto> postAlbum(@RequestBody AlbumRequestDto request) {
        AlbumDto albumDto = songFacade.addAlbumWithSong(request);
        return ResponseEntity.ok(albumDto);
    }
}
