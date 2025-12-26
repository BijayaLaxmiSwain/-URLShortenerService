package com.example.demo.service;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UrlMapping;
import com.example.demo.repository.UrlRepository;

@Service   // ⭐ THIS ANNOTATION IS REQUIRED
public class UrlServiceImpl implements UrlService {

    private final UrlRepository repository;

    public UrlServiceImpl(UrlRepository repository) {
        this.repository = repository;
    }

    @Override
    public UrlMapping shortenUrl(String originalUrl) {
        UrlMapping url = new UrlMapping();
        url.setOriginalUrl(originalUrl);
        url.setShortCode(UUID.randomUUID().toString().substring(0, 6));
        url.setHitCount(0L);
        return repository.save(url);
    }
    @Override
    public UrlMapping getAnalytics(String shortCode) {
        return repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));
    }
}
