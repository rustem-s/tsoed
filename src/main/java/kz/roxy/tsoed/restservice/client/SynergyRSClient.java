package kz.roxy.tsoed.restservice.client;

import com.google.gson.Gson;
import kz.roxy.tsoed.ApplicationYml;
import kz.roxy.tsoed.restservice.domain.synergy.AsformsDataData;
import kz.roxy.tsoed.restservice.domain.synergy.AsformsDataResponse;
import kz.roxy.tsoed.restservice.domain.synergy.AsformsDataSaveResponse;
import kz.roxy.tsoed.restservice.domain.synergy.CreateDocResponse;
import kz.roxy.tsoed.restservice.client.resttemplate.RestUtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
public class SynergyRSClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SynergyRSClient.class);

    @Autowired
    private ApplicationYml config;

    @Autowired
    private RestUtilService restUtilService;

    @Autowired
    private RestTemplate appRestTemplate;

    public CreateDocResponse callRegistryCreateDoc() {
        String url = config.getSynergy().getBaseUrl() + config.getSynergy().getCreateDocUrl();

        HttpHeaders httpHeaders = restUtilService.buildHttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<CreateDocResponse> response = appRestTemplate.exchange(
                url,
                HttpMethod.GET,
                httpEntity,
                CreateDocResponse.class
        );

        return response.getBody();
    }

    public AsformsDataResponse callAsformsData(String dataUUID) {
        String url = config.getSynergy().getBaseUrl() + config.getSynergy().getAsformsDataUrl();

        HttpHeaders httpHeaders = restUtilService.buildHttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<AsformsDataResponse> response = appRestTemplate.exchange(
                url,
                HttpMethod.GET,
                httpEntity,
                AsformsDataResponse.class,
                dataUUID
        );

        return response.getBody();
    }


    public AsformsDataSaveResponse callAsformsDataSave(String uuid, List<AsformsDataData> asformsDataDataList) {
        ApplicationYml.Synergy synergy = config.getSynergy();
        String url = config.getSynergy().getBaseUrl() + synergy.getAsformsDataSaveUrl();
        String formCode = config.getSynergy().getFormCode();

        String dataJson = "\"data\":" + new Gson().toJson(asformsDataDataList);

        HttpHeaders httpHeaders = restUtilService.buildHttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("formCode", formCode);
        map.add("uuid", uuid);
        map.add("data", dataJson);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(map, httpHeaders);

        ResponseEntity<AsformsDataSaveResponse> response = appRestTemplate.exchange(
                url,
                HttpMethod.POST,
                httpEntity,
                AsformsDataSaveResponse.class
        );
        return response.getBody();
    }
}
