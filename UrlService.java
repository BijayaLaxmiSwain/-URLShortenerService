package com.example.demo.service;

import com.example.demo.entity.UrlMapping;

public interface UrlService {
    UrlMapping shortenUrl(String originalUrl);
    UrlMapping getAnalytics(String shortCode);
}
