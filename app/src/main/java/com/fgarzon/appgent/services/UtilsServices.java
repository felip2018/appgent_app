package com.fgarzon.appgent.services;

import com.fgarzon.appgent.models.Notification;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class UtilsServices {

    RestTemplate restTemplate;

    public UtilsServices() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
    }

    public Notification[] getNotificationsByCustomerId(int customerId) {
        return null;
    }
}
