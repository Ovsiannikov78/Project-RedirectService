package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dto.LongUrlDto;
import de.ovsiannikov.redirectservice.entity.Url;
import java.util.List;

public interface UrlService {

     List<Url> getAllUrls();

     Url createUrl(LongUrlDto longUrlDto);

     Url getUrl(Long id);

     void deleteUrl(Long id);

}
