package de.ovsiannikov.redirectservice.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "currentDate")
public class RedirectStatisticDto {

    private String shortUrl;

    private String longUrl;

    private LocalDateTime currentDate;
}
