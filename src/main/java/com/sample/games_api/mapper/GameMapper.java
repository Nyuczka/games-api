package com.sample.games_api.mapper;

import com.sample.games_api.data.GameData;
import com.sample.games_api.model.Game;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface GameMapper {

    @Mapping(source= "releaseDate",target = "releaseDate", dateFormat = "yyyy-MM-dd")
    Game mapToGame(GameData gameData);

    @InheritInverseConfiguration(name="mapToGame")
    GameData mapToGameData(Game game);
}
