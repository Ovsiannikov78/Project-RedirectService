package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.entity.Url;

import java.time.LocalDateTime;
import java.util.List;


public interface UrlService {

     List<Url> getAllUrls();

     Url createUrl(String longUrl,Long customerNumber, LocalDateTime expirationDate);

     Url getUrl(Long id);

     void deleteUrl(Long id);

}
