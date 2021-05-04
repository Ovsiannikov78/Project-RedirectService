package de.ovsiannikov.redirectservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Data
@NoArgsConstructor
@Table(name = "url")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "short_url")
    private String shortUrl;

    @Column(name = "long_url")
    private String longUrl;

    @Column(name = "customer_number")
    private Integer customerNumber;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    public Url(String shortUrl, String longUrl, Integer customerNumber, LocalDateTime expirationDate) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.customerNumber = customerNumber;
        this.expirationDate = expirationDate;
    }
}
