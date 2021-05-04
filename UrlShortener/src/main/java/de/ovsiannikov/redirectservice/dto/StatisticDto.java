package de.ovsiannikov.redirectservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDto {

    private String shortUrl;

    private String longUrl;

    private Long counter;
}
