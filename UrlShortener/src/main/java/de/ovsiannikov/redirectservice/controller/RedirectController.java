package de.ovsiannikov.redirectservice.controller;

import de.ovsiannikov.redirectservice.service.RedirectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RedirectController {

    final RedirectService redirectService;

    public RedirectController(RedirectService redirectService) {
        this.redirectService = redirectService;
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> redirectToLongUrl(@PathVariable String shortUrl) {
        Optional<String> longUrl = redirectService.getRedirectUrl(shortUrl);

        return longUrl.map(c -> ResponseEntity.status(302).body(c))
                .orElse(ResponseEntity.notFound().build());
    }
}
