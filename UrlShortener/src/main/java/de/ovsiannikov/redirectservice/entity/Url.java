package de.ovsiannikov.redirectservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "url")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "short_url")
    @Setter
    private String shortUrl;

    @Column(name = "long_url")
    @Setter
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


    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", shortUrl='" + shortUrl + '\'' +
                ", longUrl='" + longUrl + '\'' +
                ", customerNumber=" + customerNumber +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
