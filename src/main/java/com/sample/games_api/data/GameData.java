package com.sample.games_api.data;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameData {

    private int id;

    private String title;

    private String thumbnail;

    @JsonProperty("short_description")
    private String shortDescription;

    @JsonProperty("game_url")
    private String gameUrl;

    private String genre;

    private String platform;

    private String publisher;

    private String developer;

    @JsonProperty("release_date")
    private String releaseDate;

}
