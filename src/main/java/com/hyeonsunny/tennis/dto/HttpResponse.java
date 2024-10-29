package com.hyeonsunny.tennis.dto;

import com.hyeonsunny.tennis.model.Booking;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class HttpResponse {
    private String status;
    private int dataCount;
    private List<Booking> dataList;
}
