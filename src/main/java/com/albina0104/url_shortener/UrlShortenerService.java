package com.albina0104.url_shortener;

import io.seruco.encoding.base62.Base62;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlShortenerService {

    private UrlShortenerConfiguration config;

    public UrlShortenerService(UrlShortenerConfiguration config) {
        this.config = config;
    }

    public UrlPair shortenUrl(String url) {
        UUID uuid = UUID.randomUUID();
        String encodedUuid = convertToBase62(uuid.toString());
        String shortUrl = "https://" + config.getShortUrlDomain() + "/" + encodedUuid;
        return new UrlPair(shortUrl, url);
    }

    private String convertToBase62(String str) {
        Base62 base62 = Base62.createInstance();
        final byte[] encoded = base62.encode(str.getBytes());
        return new String(encoded);
    }
}
