package com.fgarzon.appgent.services;

import android.os.NetworkOnMainThreadException;

import com.fgarzon.appgent.models.LoginResponse;
import com.fgarzon.appgent.models.Profile;
import com.fgarzon.appgent.models.RegisterData;
import com.fgarzon.appgent.models.RegisterResponse;

import org.json.JSONException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
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

    public LoginResponse login(String username, String password) {
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

            return loginResponse;

        } catch (HttpClientErrorException e) {
            System.out.println("Something was wrong!");
            System.out.println(e);

            return null;
        } catch (NetworkOnMainThreadException nte) {
            System.out.println("Something was wrong!");
            System.out.println(nte);

            return null;
        }
    }

    public boolean register(RegisterData registerData) {
        String url = "https://ifeelsoftware.com/laravel/api/register-person-user";
        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Set body
        Map<String, String> body = new HashMap<>();
        body.put("document_type_id", String.valueOf(registerData.getDocumentTypeId()));
        body.put("document", String.valueOf(registerData.getDocument()));
        body.put("city_id", String.valueOf(registerData.getCityId()));
        body.put("address", registerData.getAddress());
        body.put("first_name", registerData.getFirstName());
        body.put("second_name", registerData.getSecondName());
        body.put("first_lastname", registerData.getFirstLastname());
        body.put("second_lastname", registerData.getSecondLastname());
        body.put("gender", "no_data");
        body.put("phone", registerData.getPhone());
        body.put("email", registerData.getEmail());
        body.put("profile_id", String.valueOf(registerData.getProfileId()));
        body.put("password", registerData.getPassword());

        // Build request
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        try {
            // Send POST request
            ResponseEntity<RegisterResponse> responseEntity = restTemplate.postForEntity(url, entity, RegisterResponse.class);
            // Check response
            System.out.println("Request Register Successful");
            return true;

        } catch (HttpClientErrorException e) {
            System.out.println("Something was wrong HttpClientErrorException!");
            System.out.println(e);
            System.out.println(e.getResponseBodyAsString());

            return false;
        } catch (NetworkOnMainThreadException nte) {
            System.out.println("Something was wrong NetworkOnMainThreadException!");
            System.out.println(nte);

            return false;
        }
    }

}
