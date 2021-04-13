package de.ovsiannikov.redirectservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ShortUrlDto {

    public Long id;
    public String shortUrl;
}
