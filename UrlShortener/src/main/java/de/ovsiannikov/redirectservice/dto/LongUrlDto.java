package de.ovsiannikov.redirectservice.dto;

import de.ovsiannikov.redirectservice.validator.LongUrlConstraint;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class LongUrlDto {

    private Long customerNumber;

    @LongUrlConstraint
    @NotBlank(message = "Please, provide a url")
    @URL(message = "Please, provide valid url")
    private String longUrl;

    @Future(message = "The date can't be in the past. Please provide a valid date.")
    private LocalDateTime expirationDate;
}
