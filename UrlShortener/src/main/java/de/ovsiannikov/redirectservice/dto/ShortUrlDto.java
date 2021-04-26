package de.ovsiannikov.redirectservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortUrlDto {

    private Long id;

    private String shortUrl;
}
