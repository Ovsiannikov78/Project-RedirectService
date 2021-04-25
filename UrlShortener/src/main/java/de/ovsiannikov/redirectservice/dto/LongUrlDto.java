package de.ovsiannikov.redirectservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LongUrlDto {

    private Long customerNumber;

    // TODO Validation for whitespace !!!

    @NotBlank(message = "Please, provide a url")
    @URL(message = "Please, provide valid url")
    private String longUrl;

    @Future(message = "The date can't be in the past. Please provide a valid date.")
    private LocalDateTime expirationDate;
}
