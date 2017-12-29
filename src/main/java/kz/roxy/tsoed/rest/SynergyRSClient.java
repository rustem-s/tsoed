package kz.roxy.tsoed.rest;

import kz.roxy.tsoed.ApplicationConfig;
import kz.roxy.tsoed.rest.domain.synergy.CreateDocResponse;
import kz.roxy.tsoed.rest.resttemplate.RestUtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SynergyRSClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SynergyRSClient.class);

    @Autowired
    private ApplicationConfig config;

    @Autowired
    private RestUtilService restUtilService;

    @Autowired
    private RestTemplate appRestTemplate;

    public ResponseEntity<CreateDocResponse> callRegistryCreateDoc() {
        String url = config.getSynergy().getBaseUrl() + config.getSynergy().getCreateDocUrl();

        ResponseEntity<CreateDocResponse> response = appRestTemplate.exchange(
                url,
                HttpMethod.GET,
                restUtilService.buildHttpEntity(),
                CreateDocResponse.class
        );

        return response;
    }
}
