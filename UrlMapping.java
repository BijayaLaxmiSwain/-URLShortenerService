package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "URL_MAPPING")
public class UrlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ORIGINAL_URL", nullable = false, length = 1000)
    private String originalUrl;

    @Column(name = "SHORT_CODE", unique = true, nullable = false)
    private String shortCode;

    @Column(name = "HIT_COUNT")
    private Long hitCount = 0L;

    // getters & setters
    public Long getId() { return id; }
    public String getOriginalUrl() { return originalUrl; }
    public void setOriginalUrl(String originalUrl) { this.originalUrl = originalUrl; }

    public String getShortCode() { return shortCode; }
    public void setShortCode(String shortCode) { this.shortCode = shortCode; }

    public Long getHitCount() { return hitCount; }
    public void setHitCount(Long hitCount) { this.hitCount = hitCount; }
}
