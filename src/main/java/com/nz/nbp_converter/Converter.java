package com.nz.nbp_converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Converter {
    public double convertUsdToPln(double usd){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/?format=json";
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);

        if(response.getStatusCode()== HttpStatus.OK){
            ObjectMapper mapper = new ObjectMapper();
            try {
                JsonNode root = mapper.readTree(response.getBody());
                JsonNode rates = root;
                System.out.println(rates);

            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

        }
        return 0;
    }
}
