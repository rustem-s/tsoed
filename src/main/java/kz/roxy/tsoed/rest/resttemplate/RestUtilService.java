package kz.roxy.tsoed.rest.resttemplate;

import kz.roxy.tsoed.ApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class RestUtilService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestUtilService.class);

    @Autowired
    private ApplicationConfig applicationConfig;

    public HttpEntity buildHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        String authCode = applicationConfig.getAuthCode();
        headers.set("Authorization", "Basic " + authCode);
        headers.set("Accept", "*/*");
        return new HttpEntity(headers);
    }
}
