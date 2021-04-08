package de.ovsiannikov.redirectservice.dto;

import de.ovsiannikov.redirectservice.validator.DateConstraint;
import de.ovsiannikov.redirectservice.validator.UrlConstraint;
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

    @UrlConstraint
    public String longUrl;

    @DateConstraint
    public LocalDateTime expirationDate;
}
