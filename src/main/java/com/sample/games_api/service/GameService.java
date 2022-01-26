package com.sample.games_api.service;

import com.sample.games_api.data.GameData;
import com.sample.games_api.mapper.GameMapper;
import com.sample.games_api.model.Game;
import com.sample.games_api.repository.GameRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service used for CRUD methods
 */
@Service
public class GameService {

    @Resource
    private GameRepository gameRepository;

    private final GameMapper gameMapper =
            Mappers.getMapper(GameMapper.class);


    public void saveGamesFromAPI(final List<GameData> games) {
        List<Game> mappedGames = games.stream().map(gameMapper::mapToGame).collect(Collectors.toList());
        gameRepository.saveAll(mappedGames);
    }

    public Game save(final GameData gameData){
        return gameRepository.save(gameMapper.mapToGame(gameData));
    }

    public List<GameData> getAll(){
        List<Game> games = (List<Game>) gameRepository.findAll();
        return games.stream().map(gameMapper::mapToGameData).collect(Collectors.toList());
    }

    public List<GameData> getGamesByPlatform(final String name){
        Optional<List<Game>> gamesByPlatform = gameRepository.findByPlatformContaining(name);
        return gamesByPlatform.map(games -> games.stream()
                .map(gameMapper::mapToGameData).collect(Collectors.toList()))
                .orElse(new ArrayList<>());
    }

    public Game updateGame(final Integer id, final GameData gameData) {
        return gameRepository.findById(id).map(game -> {
            game = gameMapper.mapToGame(gameData);
            game.setId(id);
            return gameRepository.save(game);
        }).orElseGet(() -> gameRepository.save(gameMapper.mapToGame(gameData)));
    }

    public boolean deleteById(final Integer id) {
        Optional<Game> byId = gameRepository.findById(id);
        if (byId.isPresent()) {
            gameRepository.delete(byId.get());
            return true;
        }
        return false;
    }

    public GameMapper getGameMapper() {
        return gameMapper;
    }
}
