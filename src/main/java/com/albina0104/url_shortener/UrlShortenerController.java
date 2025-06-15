package com.albina0104.url_shortener;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlShortenerController {

    private UrlShortenerService urlShortenerService;

    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @GetMapping("/{shortUrlCode}")
    public ResponseEntity<Void> redirectToLongUrl(@PathVariable("shortUrlCode") String shortUrlCode) {
        String longUrl = urlShortenerService.getLongUrl(shortUrlCode);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Location", longUrl);
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }

    @PostMapping("/shortenUrl")
    public UrlPair shortenUrl(@RequestParam String url) {
        return urlShortenerService.shortenUrl(url);
    }

    @PostMapping("/getAliasUrl")
    public UrlPair getAliasUrl(@RequestParam String url, @RequestParam String alias) {
        return urlShortenerService.getAliasUrl(url, alias);
    }
}
