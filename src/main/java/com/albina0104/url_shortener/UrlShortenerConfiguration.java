package com.albina0104.url_shortener;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "url-shortener")
@Data
public class UrlShortenerConfiguration {

    private String shortUrlDomain = "example.com";
}
