package com.songcloud.infrastructure.crud.genre;

import com.songcloud.domain.crud.dto.ArtistDto;
import com.songcloud.domain.crud.dto.ArtistRequestDto;
import com.songcloud.domain.crud.dto.GenreDto;
import com.songcloud.domain.crud.dto.GenreRequestDto;
import com.songcloud.domain.crud.song.SongcloudCrudFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/genre")
public class GenreRestController {

    private final SongcloudCrudFacade songFacade;

    @PostMapping("/createGenre")
    ResponseEntity<GenreDto> postGenre(@RequestBody GenreRequestDto request) {
        GenreDto genreDto = songFacade.addGenre(request);
        return ResponseEntity.ok(genreDto);
    }
}
