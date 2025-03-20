package com.songcloud.domain.crud.song;

import com.songcloud.domain.crud.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
class Genre extends BaseEntity {

    @Id
    @GeneratedValue(generator = "genre_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "genre_id_seq", sequenceName = "genre_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
