package com.songcloud.song.domain.model;

import lombok.Builder;

@Builder
public record Song(String songName, String artistName) {
}
