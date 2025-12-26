package com.example.demo.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UrlMapping;
import com.example.demo.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/url/info")
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public UrlMapping shorten(@RequestBody Map<String, String> body) {
        return service.shortenUrl(body.get("url"));
    }
    
    @GetMapping("/{code}")
    public Map<String,String>  redirect(@PathVariable String code, HttpServletResponse response) throws IOException {
    	 UrlMapping url = service.getAnalytics(code);
         return Map.of(
             "shortUrl", url.getShortCode(),
             "longUrl", url.getOriginalUrl()
         );        
    }



}
