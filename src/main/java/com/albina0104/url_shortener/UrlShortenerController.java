package com.albina0104.url_shortener;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortenerController {

    private UrlShortenerService urlShortenerService;

    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/shortenUrl")
    public UrlPair shortenUrl(@RequestParam String url) {
        return urlShortenerService.shortenUrl(url);
    }
}
