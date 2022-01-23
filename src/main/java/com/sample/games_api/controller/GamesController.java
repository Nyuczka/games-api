package com.sample.games_api.controller;

import com.sample.games_api.data.GameData;
import com.sample.games_api.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/games")
public class GamesController {

    @Resource
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameData>> getGames() {
        List<GameData> all = gameService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
