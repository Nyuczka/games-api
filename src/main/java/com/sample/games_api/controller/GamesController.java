package com.sample.games_api.controller;

import com.sample.games_api.data.GameData;
import com.sample.games_api.model.Game;
import com.sample.games_api.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping(value = "/games", produces = {MediaType.APPLICATION_JSON_VALUE})
public class GamesController {

    @Resource
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameData>> getGames() {
        List<GameData> all = gameService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping(value = "/platform/{name}")
    public ResponseEntity<List<GameData>> getGamesByPlatform(@PathVariable final
                                                             String name) {
        List<GameData> gamesByPlatform = gameService.getGamesByPlatform(name);
        if (!CollectionUtils.isEmpty(gamesByPlatform)) {
            return new ResponseEntity<>(gamesByPlatform, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addGame(@RequestBody final GameData game){
        Game savedGame = gameService.save(game);
        GameData savedDTO = gameService.getGameMapper().mapToGameData(savedGame);
        return savedGame != null ? new ResponseEntity<>(savedDTO ,HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateGame(@PathVariable final Integer id,
                                        @RequestBody final GameData gameData) {
        Game game = gameService.updateGame(id, gameData);
        GameData savedDTO = gameService.getGameMapper().mapToGameData(game);
        return new ResponseEntity<>(savedDTO
                , HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> remove(@PathVariable final Integer id) {
        boolean isRemoved = gameService.deleteById(id);
        return new ResponseEntity<>(isRemoved ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
