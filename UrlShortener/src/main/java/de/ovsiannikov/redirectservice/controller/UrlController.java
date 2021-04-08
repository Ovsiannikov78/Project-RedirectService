package de.ovsiannikov.redirectservice.controller;

import de.ovsiannikov.redirectservice.dto.LongUrlDto;
import de.ovsiannikov.redirectservice.dto.ShortUrlDto;
import de.ovsiannikov.redirectservice.entity.Url;
import de.ovsiannikov.redirectservice.service.UrlService;
import de.ovsiannikov.redirectservice.validator.UrlsValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/urls")
    public ResponseEntity<ShortUrlDto> create(@RequestBody LongUrlDto longUrlDto) {

        Url url = urlService.createUrl(longUrlDto.getLongUrl(), longUrlDto.getCustomerNumber(), longUrlDto.getExpirationDate());
        return new ResponseEntity<>(new ShortUrlDto(url.getId(), url.getShortUrl()), HttpStatus.OK);
    }

    // TODO should I here also use ResponseEntity ?

    @DeleteMapping("server/urls/{id}")
    public String deleteUrl(@PathVariable Long id) {
        urlService.deleteUrl(id);

        return "Url with id " + id + " was deleted.";
    }
}
