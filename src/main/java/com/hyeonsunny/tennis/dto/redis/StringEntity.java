package com.hyeonsunny.tennis.dto.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StringEntity {
    private String key;
    private String value;
}
