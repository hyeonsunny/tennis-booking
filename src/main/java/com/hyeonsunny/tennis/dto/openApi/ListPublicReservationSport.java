package com.hyeonsunny.tennis.dto.openApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hyeonsunny.tennis.model.Booking;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListPublicReservationSport {

    @JsonProperty("list_total_count") //list_total_count
    private int listTotalCount;

    @JsonProperty("RESULT")
    private Result result;

    private List<Booking> row;
}
