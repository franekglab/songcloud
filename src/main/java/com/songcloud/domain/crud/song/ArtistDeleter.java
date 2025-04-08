package com.songcloud.domain.crud.song;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Log4j2
class ArtistDeleter {

    private final ArtistRepository artistRepository;
    private final ArtistRetriever artistRetriever;
    private final AlbumRetriever albumRetriever;
    private final AlbumDeleter albumDeleter;
    private final SongDeleter songDeleter;

    void deleteArtistByIdWithAlbumsAndSongs(final Long artistId) {
        Artist artist = artistRetriever.findById(artistId);
        Set<Album> albumsByArtistId = albumRetriever.finAlbumsByArtistId(artist.getId());
        if(albumsByArtistId.isEmpty()) {
            log.info("Artist with id: " + artistId + " have 0 albums");
            artistRepository.deleteById(artistId);
            return;
        }

        albumsByArtistId.stream()
                .filter(album -> album.getArtists().size() >= 2)
                .forEach(album -> album.removeArtist(artist));

        Set<Album> albumWithOnlyOneArtist = albumsByArtistId.stream()
                .filter(album -> album.getArtists().size() == 1)
                .collect(Collectors.toSet());

        Set<Long> allSongsFromAllAlbumsWhereWasOnlyThisArtist = albumWithOnlyOneArtist
                .stream()
                .flatMap(album -> album.getSongs().stream())
                .map(Song::getId)
                .collect(Collectors.toSet());

        songDeleter.deleteAllSongsById(allSongsFromAllAlbumsWhereWasOnlyThisArtist);

        Set<Long> albumIdsToDelete = albumWithOnlyOneArtist.stream()
                .map(Album::getId)
                .collect(Collectors.toSet());

        albumDeleter.deleteAllAlbumsByIds(albumIdsToDelete);

        artistRepository.deleteById(artistId);
    }
}
