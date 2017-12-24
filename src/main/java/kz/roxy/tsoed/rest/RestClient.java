package kz.roxy.tsoed.rest;

import kz.roxy.tsoed.rest.domain.synergy.Form;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestClient.class);

    private static String SYNERGY_REST_SERVICE = "http://localhost:8080/synergystub/form";

    public Form callGetForm(String formId) {
        LOGGER.info("formId = {}", formId);
        RestTemplate restTemplate = new RestTemplate();

        Form form = restTemplate.getForObject(SYNERGY_REST_SERVICE, Form.class, formId);
        return form;
    }
}
