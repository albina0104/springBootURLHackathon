package com.albina0104.url_shortener;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortenerController {

    private UrlShortenerService urlShortenerService;

    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/shortenUrl")
    public UrlPair shortenUrl(@PathVariable("url") String url) {
        return urlShortenerService.shortenUrl(url);
    }
}
