package com.albina0104.url_shortener;

import org.springframework.data.repository.CrudRepository;

public interface UrlPairRepository extends CrudRepository<UrlPair, Long> {
}
