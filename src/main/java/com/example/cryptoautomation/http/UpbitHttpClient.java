package com.example.cryptoautomation.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UpbitHttpClient {
    private final RestTemplate restTemplate; // RestTemplate 주입

    public UpbitTickerDto getTickerByMarket(String market) {
        try {
            String url = "https://api.upbit.com/v1/ticker?markets=" + market;
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");

            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(
                    url, HttpMethod.GET, entity, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.getBody(), new TypeReference<List<UpbitTickerDto>>() {})
                    .stream().findFirst().orElseThrow(() -> new RuntimeException("No data found"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch data from Upbit", e);
        }
    }
}
