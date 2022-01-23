package com.sample.games_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String thumbnail;

    @Column(name="game_url")
    private String gameUrl;

    private String genre;

    private String platform;

    private String publisher;

    private String developer;

    @Column(name="release_date")
    private LocalDate releaseDate;
}
