package me.ksprateek.urlshortenerartifact.service;

import com.opsmatters.bitly.Bitly;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkRequest;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {

    @Value("${BITLY_TOKEN}")
    private String BITLY_TOKEN;

    private Bitly client;

    @PostConstruct
    public void setup() {
        client = new Bitly(BITLY_TOKEN);
    }

    public String getShortUrl(String longUrl) {
        String link = "error";
        try{
            CreateBitlinkResponse response = client.bitlinks().shorten(longUrl).get();
            link = response.getLink();
        }catch (Exception e){

        }


        return link;
    }
}
