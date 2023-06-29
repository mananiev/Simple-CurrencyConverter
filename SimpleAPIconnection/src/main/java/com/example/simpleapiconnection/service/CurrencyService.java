package com.example.simpleapiconnection.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyService {

    private final String API_KEY = "NyxpleoowMUNhbbPcCh1XlsWRwmzpaJSS8OmYDpQ";
    private final String API_URL = "https://api.freecurrencyapi.com/v1/latest?apikey=" + API_KEY; //&currencies=BGN&base_currency=EUR";

    private final String FROM_CURRENCY_PREFIX = "&base_currency=";
    private final String TO_CURRENCY_PREFIX = "&currencies=";

    public double Convert(String from , String to) {
        RestTemplate restTemplate = new RestTemplate();
        String buildingLink = API_URL+TO_CURRENCY_PREFIX+to+FROM_CURRENCY_PREFIX+from;
        ResponseEntity<Map> response = restTemplate.getForEntity(buildingLink, Map.class);
        Map<String, Object> body = response.getBody();
        Map<String, Object> rate = (Map<String, Object>) body.get("data");

         return (double) rate.get(to);
    };
}
