package com.sample.games_api.service;

import com.sample.games_api.data.GameData;
import com.sample.games_api.mapper.GameMapper;
import com.sample.games_api.model.Game;
import com.sample.games_api.repository.GameRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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


    public void saveGamesFromAPI(List<GameData> games) {
        List<Game> mappedGames = games.stream().map(gameMapper::mapToGame).collect(Collectors.toList());
        gameRepository.saveAll(mappedGames);
    }

    public List<GameData> getAll(){
        List<Game> games = (List<Game>) gameRepository.findAll();
        return games.stream().map(gameMapper::mapToGameData).collect(Collectors.toList());
    }
}
