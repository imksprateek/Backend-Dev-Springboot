package me.ksprateek.urlshortenerartifact.controller;

import lombok.extern.slf4j.Slf4j;
import me.ksprateek.urlshortenerartifact.model.UrlRequest;
import me.ksprateek.urlshortenerartifact.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class UrlShortenerRestController {
    @Autowired
    private UrlShortenerService urlService;

    @PostMapping("/processUrl")
    public String processUrl(@RequestBody UrlRequest urlRequest){
        String shortUrl = urlService.getShortUrl(urlRequest.getLongUrl());
        return shortUrl;
    }
}
