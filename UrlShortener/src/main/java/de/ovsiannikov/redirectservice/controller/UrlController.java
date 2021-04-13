package de.ovsiannikov.redirectservice.controller;

import de.ovsiannikov.redirectservice.dto.LongUrlDto;
import de.ovsiannikov.redirectservice.dto.ShortUrlDto;
import de.ovsiannikov.redirectservice.entity.Url;
import de.ovsiannikov.redirectservice.kafka.KafkaConsumer;
import de.ovsiannikov.redirectservice.kafka.KafkaProducer;
import de.ovsiannikov.redirectservice.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/urls")
    public ResponseEntity<ShortUrlDto> create(@Valid @RequestBody LongUrlDto longUrlDto) {

        Url url = urlService.createUrl(longUrlDto.getLongUrl(), longUrlDto.getCustomerNumber(), longUrlDto.getExpirationDate());
        return new ResponseEntity<>(new ShortUrlDto(url.getId(), url.getShortUrl()), HttpStatus.OK);
    }

    @DeleteMapping("/urls/{id}")
    public String deleteUrl(@PathVariable Long id) {
        urlService.deleteUrl(id);

        return "Url with id " + id + " was deleted.";
    }
}

/*
@RestController
public class UrlController {

    private final KafkaConsumer consumer;
    private final KafkaProducer producer;
    private final UrlService urlService;

    public UrlController(KafkaConsumer consumer, KafkaProducer producer, UrlService urlService) {
        this.consumer = consumer;
        this.producer = producer;
        this.urlService = urlService;
    }

    @PostMapping("/urls")
    public ResponseEntity<ShortUrlDto> create(@Valid @RequestBody LongUrlDto longUrlDto) {

        Url url = urlService.createUrl(longUrlDto.getLongUrl(), longUrlDto.getCustomerNumber(), longUrlDto.getExpirationDate());

        ShortUrlDto shortUrlDto = new ShortUrlDto(url.getId(), url.getShortUrl());

        producer.produce(shortUrlDto);
        return new ResponseEntity<>(shortUrlDto, HttpStatus.OK);
    }

    @DeleteMapping("/urls/{id}")
    public String deleteUrl(@PathVariable Long id) {
        urlService.deleteUrl(id);

        return "Url with id " + id + " was deleted.";
    }
}
*/

