package com.sample.games_api.repository;

import com.sample.games_api.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

    Optional<List<Game>> findGamesByPlatform(final String platform);

    Optional<List<Game>> findGamesByDeveloper(final String developer);

}
