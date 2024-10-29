package com.hyeonsunny.tennis.service;

import com.hyeonsunny.tennis.dto.openApi.OpenApiResponse;
import com.hyeonsunny.tennis.dto.openApi.ListPublicReservationSport;
import com.hyeonsunny.tennis.model.Booking;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Slf4j
public class TennisService {
    private static WebClient webClient;
    private static String url;
    private final RedisService redisRepository;

    TennisService(@Value("${open.data.seoul.api-key}") String apiKey, RedisService redisRepository) {
        this.url = "http://openAPI.seoul.go.kr:8088/" + apiKey + "/json/ListPublicReservationSport/1/5/테니스장";
        this.webClient = WebClient.builder().build();
        this.redisRepository = redisRepository;
    }

    public List<Booking> findAllBooking() {
        return redisRepository.findAllBooking();
    }

    public Booking findBooking(String id) {
        return redisRepository.findBooking(id);
    }

    public OpenApiResponse addBooking() {
        OpenApiResponse response = webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(OpenApiResponse.class)
                .block();

        ListPublicReservationSport sport = response.getListPublicReservationSport();
        List<Booking> bookings = sport.getRow();

        for(Booking obj : bookings) {
            redisRepository.saveBooking(obj);
        }

        return response;
    }

    public int removeAllBooking() {
        int count = -1;

        try {
            redisRepository.removeAllBooking();
            count = 0;
        } catch(Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}
