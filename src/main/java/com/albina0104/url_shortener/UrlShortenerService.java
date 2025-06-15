package com.albina0104.url_shortener;

import io.seruco.encoding.base62.Base62;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlShortenerService {

    private UrlPairRepository repo;
    private UrlShortenerConfiguration config;

    public UrlShortenerService(UrlPairRepository repo, UrlShortenerConfiguration config) {
        this.repo = repo;
        this.config = config;
    }

    public UrlPair shortenUrl(String url) {
        UUID uuid = UUID.randomUUID();
        String encodedUuid = convertToBase62(uuid.toString());
        String shortUrl = "https://" + config.getShortUrlDomain() + "/" + encodedUuid.substring(0, 7);
        UrlPair urlPair = new UrlPair(shortUrl, url);
        return repo.save(urlPair);
    }

    private String convertToBase62(String str) {
        Base62 base62 = Base62.createInstance();
        final byte[] encoded = base62.encode(str.getBytes());
        return new String(encoded);
    }
}
