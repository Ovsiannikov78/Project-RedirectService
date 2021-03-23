package de.ovsiannikov.redirectservice.controller;

import de.ovsiannikov.redirectservice.entity.Url;
import de.ovsiannikov.redirectservice.service.UrlService;
import org.springframework.web.bind.annotation.*;


@RestController
public class UrlController {

    final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("short_server/{id}")
    public String redirectToLongUrl(@PathVariable Long id) {

        String longUrl = urlService.getLongUrl(id);

        return "redirect:/" + longUrl;
    }

    @PostMapping("server/urls")
    public Url addNewUrl(@RequestBody String url) {
        return urlService.saveUrl(url);
    }

    @DeleteMapping("server/urls/{id}")
    public String deleteUrl(@PathVariable Long id) {
        urlService.deleteUrl(id);

        return "Url with id " + id + " was deleted.";
    }
}
