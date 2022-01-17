package com.sample.games_api.controller;

import com.sample.games_api.data.GameData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/games")
public class GamesController {

    @Value("${game.rest.api.url}")
    private String url;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ResponseEntity<GameData[]> getGames() {

        HttpEntity<GameData> request = new HttpEntity<>(new GameData());

        return restTemplate.exchange(url, HttpMethod.GET, request, GameData[].class);
    }


    @GetMapping("/platform/{name}")
    public ResponseEntity<?> getGamesByPlatform(@PathVariable final String name) {
        Map<String, String> queryParams = new HashMap<>();
        HttpEntity<GameData> request = new HttpEntity<>(new GameData());
        queryParams.put("name", name);
        return restTemplate.exchange(url + "?platform=" + name, HttpMethod.GET, request,
                GameData[].class, queryParams);
    }

}
