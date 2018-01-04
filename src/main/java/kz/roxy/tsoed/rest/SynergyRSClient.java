package kz.roxy.tsoed.rest;

import com.google.gson.Gson;
import kz.roxy.tsoed.ApplicationYml;
import kz.roxy.tsoed.rest.domain.synergy.AsformsDataData;
import kz.roxy.tsoed.rest.domain.synergy.AsformsDataResponse;
import kz.roxy.tsoed.rest.domain.synergy.AsformsDataSaveResponse;
import kz.roxy.tsoed.rest.domain.synergy.CreateDocResponse;
import kz.roxy.tsoed.rest.resttemplate.RestUtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

        ResponseEntity<CreateDocResponse> response = appRestTemplate.exchange(
                url,
                HttpMethod.GET,
                restUtilService.buildHttpEntity(),
                CreateDocResponse.class
        );

        return response.getBody();
    }

    public AsformsDataResponse callAsformsData(String dataUUID) {
        String url = config.getSynergy().getBaseUrl() + config.getSynergy().getAsformsDataUrl() + dataUUID;

        ResponseEntity<AsformsDataResponse> response = appRestTemplate.exchange(
                url,
                HttpMethod.GET,
                restUtilService.buildHttpEntity(),
                AsformsDataResponse.class
        );

        return response.getBody();
    }


    public AsformsDataSaveResponse callAsformsDataSave(String uuid, List<AsformsDataData> asformsDataDataList) {
        // код Исходящие_документы_ЦОЭД
        /*
        URL rest/api/asforms/data/save?
        Method POST
        Поле data с данными должно иметь формат:
        "data": [{"id":"field1_id", "value": "field1_value", "type":"widgetType1"}, ..., {{"id":"fieldN_id", "value": "fieldN_value", "type":"widgetType1"}}]

        Пример использования можно посмотреть в классе kz.arta.synergy.rest.api.sample.registry.CreateAndFillDocExample
Parameters:
formUUID - UUID формы (параметр запроса). В случае если идентификатор формы не указан он будет получен по идентификатору данных. Отсутствие идентификатор формы приводит к повышенной нагрузки при сохранении данных по форме.
formCode - код формы
uuid - UUID данных по форме (параметр запроса)
parentID - идентификатор папки в хранилище, в которой должен быть создан файл по форме (обязателен, если не передан uuid)
data - усеченный json с данными по форме (параметр формы). Смотри пример данных
eventProperties - @FormParam json с параметрами для отправки в событие изменения данных по форме (необязательный параметр)
Returns:
В случае успешного выполнения возвращает json с полями:
errorCode - код результата выполнения (0)
uuid - uuid данных по форме
В случае не выполнения, возвращает json с полями:
errorCode - код выполнения (число, отличное от 0)
errorMessage - сообщение об ошибке
        */
        // String dataUUID = "8cece052-ceb3-454e-8972-73025a929096";
        ApplicationYml.Synergy synergy = config.getSynergy();
//      String url = config.getSynergy().getBaseUrl() + synergy.getAsformsDataSaveUrl() + code+"&"+responsecallAsformsData.getBody().getUuid()+"&"+ "\"data\": "+responsecallAsformsData.getBody().getData();
        String url = config.getSynergy().getBaseUrl() + synergy.getAsformsDataSaveUrl();
        String dataJson = new Gson().toJson(asformsDataDataList);
        ResponseEntity<AsformsDataSaveResponse> response = appRestTemplate.exchange(
                url,
                HttpMethod.POST,
                restUtilService.buildHttpEntity(),
                AsformsDataSaveResponse.class,
                uuid,
                dataJson
        );
        return response.getBody();
    }
}
