package com.hyeonsunny.tennis.dto.openApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OpenApiResponse {
    @JsonProperty("ListPublicReservationSport")
    private ListPublicReservationSport listPublicReservationSport;
}
