package com.songcloud.infrastructure.crud.artist.controller;

import com.songcloud.domain.crud.dto.ArtistDto;
import com.songcloud.domain.crud.dto.ArtistRequestDto;
import com.songcloud.domain.crud.song.SongcloudCrudFacade;
import com.songcloud.infrastructure.crud.artist.dto.AllArtistsDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@AllArgsConstructor
@RequestMapping("/artists")
public class ArtistRestController {

    private final SongcloudCrudFacade songFacade;

    @PostMapping("/createArtist")
    ResponseEntity<ArtistDto> postArtist(@RequestBody ArtistRequestDto request) {
        ArtistDto artistDto = songFacade.addArtist(request);
        return ResponseEntity.ok(artistDto);
    }

    @GetMapping
    ResponseEntity<AllArtistsDto> getArtists(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Set<ArtistDto> allArtists = songFacade.findAllArtists(pageable);
        return ResponseEntity.ok(new AllArtistsDto(allArtists));
    }
}
