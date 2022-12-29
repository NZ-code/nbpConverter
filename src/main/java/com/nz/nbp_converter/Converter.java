package com.nz.nbp_converter;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
public class Converter {
    public double convertUsdToPln(double usd){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/?format=json";
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);

        if(response.getStatusCode()== HttpStatus.OK){
            String jsonText = response.getBody();
            try {
                JSONObject obj=new JSONObject(jsonText);
                double bid = obj.getJSONArray("rates").getJSONObject(0).getDouble("ask");
                System.out.println(bid);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return 0;
    }
}
