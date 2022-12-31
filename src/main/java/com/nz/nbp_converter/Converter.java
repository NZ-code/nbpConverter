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
    // TODO SET PROPER DATE
    private String date = "2016-04-04";
    private String currency = "usd";
    public double convertUsdToPln(double usd){
        RestTemplate restTemplate = new RestTemplate();
        //TODO ASK OR BID?
        double ask = 0;

        String url = BASE+"exchangerates/rates/c/"+currency+"/"+date+"/?format=json";
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);

        if(response.getStatusCode()== HttpStatus.OK){
            String jsonText = response.getBody();
            try {
                JSONObject obj=new JSONObject(jsonText);
                ask = obj.getJSONArray("rates").getJSONObject(0).getDouble("ask");

                return ask;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            throw new RuntimeException();
        }
    }
}
