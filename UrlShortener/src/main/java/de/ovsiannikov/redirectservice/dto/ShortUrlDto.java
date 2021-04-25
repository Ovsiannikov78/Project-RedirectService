package de.ovsiannikov.redirectservice.dto;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
@ToString
@UniqueElements
@NoArgsConstructor
@AllArgsConstructor
public class ShortUrlDto {

    private Long id;

    private String shortUrl;
}
