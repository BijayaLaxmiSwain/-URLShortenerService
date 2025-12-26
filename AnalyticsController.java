package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UrlMapping;
import com.example.demo.service.UrlService;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final UrlService service;

    public AnalyticsController(UrlService service) {
        this.service = service;
    }
    
    

    @GetMapping("/{code}")
    public UrlMapping getAnalytics(@PathVariable String code) {
        return service.getAnalytics(code);
        
    }
}
