package com.hyeonsunny.tennis.controller;

import com.hyeonsunny.tennis.dto.HttpResponse;
import com.hyeonsunny.tennis.dto.openApi.OpenApiResponse;
import com.hyeonsunny.tennis.model.Booking;
import com.hyeonsunny.tennis.service.TennisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
    private final TennisService tennisService;

    ApiController(TennisService tennisService) {
        this.tennisService = tennisService;
    }

    @GetMapping("/booking")
    public HttpResponse booking() {
        List<Booking> list = tennisService.findAllBooking();
        int count = list.size();
        String status = count != 0 ? "200" : "500";

        return HttpResponse.builder()
                .status(status)
                .dataList(list)
                .dataCount(count)
                .build();
    }

    @GetMapping("/booking/{id}")
    public Booking bookingDetail(@PathVariable("id") String id) {
        return tennisService.findBooking(id);
    }

    @GetMapping("/booking/add")
    public OpenApiResponse addBooking() {
        return tennisService.addBooking();
    }

    @PutMapping("/booking/delete")
    public HttpResponse removeAllBooking() {
        int count = tennisService.removeAllBooking();
        String status = count == 0 ? "200" : "500";

        return HttpResponse.builder()
                .status(status)
                .dataCount(count)
                .build();
    }
}
