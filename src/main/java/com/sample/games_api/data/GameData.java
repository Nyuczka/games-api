package com.sample.games_api.data;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sample.games_api.deserializer.CustomLocalDateDeserializer;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameData {

    private int id;

    private String title;

    private String thumbnail;

    @JsonIgnore
    private String shortDescription;

    @JsonProperty("game_url")
    private String gameUrl;

    private String genre;

    private String platform;

    private String publisher;

    private String developer;

    @JsonProperty("release_date")
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate releaseDate;

}
