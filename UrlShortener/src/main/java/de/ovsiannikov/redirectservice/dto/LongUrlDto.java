package de.ovsiannikov.redirectservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LongUrlDto {

    public Long customerNumber;

    @NotBlank(message = "Please, provide a url")
    @URL(message = "Please, provide valid url")
    public String longUrl;

    @Future(message = "The date can't be in the past. Please provide a valid date.")
    public LocalDateTime expirationDate;
}
