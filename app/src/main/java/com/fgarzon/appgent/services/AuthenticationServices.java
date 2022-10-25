package com.fgarzon.appgent.services;

import com.fgarzon.appgent.models.LoginResponse;
import com.fgarzon.appgent.models.Profile;

import org.json.JSONException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationServices {
    RestTemplate restTemplate;

    public AuthenticationServices() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
    }

    public void test() {
        String url = "https://ifeelsoftware.com/laravel/api/test";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println("RESPONSE:: ");
        System.out.println(response.getBody());
    }

    public void getProfileTest() throws JSONException {
        String url = "https://ifeelsoftware.com/laravel/api/get-profiles";

        // Send POST request
        ResponseEntity<Profile[]> responseEntity = restTemplate.getForEntity(url, Profile[].class);

        // Check response
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful: ");
            Profile[] profiles = responseEntity.getBody();
            System.out.println(profiles.length);
        } else {
            System.out.println("Request Failed");
            System.out.println(responseEntity.getStatusCode());
        }

    }

    public void login(String username, String password) {
        String url = "https://ifeelsoftware.com/laravel/api/login";

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Set body
        Map<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);

        // Build request
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        try {
            // Send POST request
            ResponseEntity<LoginResponse> responseEntity = restTemplate.postForEntity(url, entity, LoginResponse.class);
            // Check response
            System.out.println("Request Login Successful");
            LoginResponse loginResponse = responseEntity.getBody();
            System.out.println(loginResponse.getData().getEmail());
            System.out.println("Status: "+loginResponse.getStatus());

        } catch (Exception e) {
            throw e;
        }

    }

}
