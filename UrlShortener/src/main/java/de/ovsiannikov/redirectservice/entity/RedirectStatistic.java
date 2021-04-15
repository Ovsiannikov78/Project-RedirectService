package de.ovsiannikov.redirectservice.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "redirect_statistic")
public class RedirectStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "short_url")
    private String shortUrl;

    @NonNull
    @Column(name = "long_url")
    private String longUrl;

    @Column(name = "current_date")
    private LocalDateTime currentDate;
}
