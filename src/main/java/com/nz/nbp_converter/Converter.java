package com.nz.nbp_converter;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
public class Converter {
    public Converter() {
    }

    private final String BASE = "http://api.nbp.pl/api/";

    private String date = "2022-12-29";
    private String currency = "usd";
    public double convertUsdToPln(double usdPrice){
        RestTemplate restTemplate = new RestTemplate();

        double ask = 0;

        String url = BASE+"exchangerates/rates/c/"+currency+"/"+date+"/?format=json";
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);

        if(response.getStatusCode()== HttpStatus.OK){
            String jsonText = response.getBody();
            try {
                JSONObject obj=new JSONObject(jsonText);
                ask = obj.getJSONArray("rates").getJSONObject(0).getDouble("ask");

                return ask  * usdPrice;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            throw new RuntimeException();
        }
    }
}
