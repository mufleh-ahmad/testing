package Util;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Mufleh on 24/03/2019.
 */
public class RestTestUtil {

    RestTemplate restTemplate = new  RestTemplate();


    public ResponseEntity postEntity (final String url, final String body){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(body,headers);
        return restTemplate.exchange(url, HttpMethod.POST,request,String.class);
    }

    public <T> T get(final String url, Class<T> responseType){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET,request,responseType);
        return response.getBody();
    }
}
