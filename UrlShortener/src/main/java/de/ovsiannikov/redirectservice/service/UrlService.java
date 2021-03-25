package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.entity.Url;
import java.util.List;


public interface UrlService {

     List<Url> getAllUrls();

     Url saveUrl(String url);

     Url getUrl(Long id);

     void deleteUrl(Long id);

}
