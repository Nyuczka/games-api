package com.sample.games_api.util;

import com.sample.games_api.data.GameData;
import com.sample.games_api.service.GameService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;

@Component
public class InitDatabaseUtil {

    @Value("${game.rest.api.url}")
    private String url;

    @Resource
    private GameService gameService;

    @EventListener(ApplicationReadyEvent.class)
    public void initDatabase(){
        final RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GameData[]> exchange = restTemplate.exchange(url, HttpMethod.GET,
                null, GameData[].class);

        if (exchange.getBody() != null) {
            gameService.saveGamesFromAPI(Arrays.asList(exchange.getBody()));
        }

    }
}
