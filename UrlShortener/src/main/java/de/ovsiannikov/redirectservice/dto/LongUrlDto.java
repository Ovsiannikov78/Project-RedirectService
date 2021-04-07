package de.ovsiannikov.redirectservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LongUrlDto {

    public Long customerNumber;
    public String longUrl;
    public LocalDateTime expirationDate;
}
