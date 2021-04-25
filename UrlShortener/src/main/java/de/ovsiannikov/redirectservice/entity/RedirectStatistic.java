package de.ovsiannikov.redirectservice.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
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

    @Column(name = "counter")
    private Long counter;

    public RedirectStatistic(@NonNull String shortUrl, @NonNull String longUrl, Long counter) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.counter = counter;
    }
}
