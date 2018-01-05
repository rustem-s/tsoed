package kz.roxy.tsoed;

import kz.roxy.tsoed.rest.SynergyRSClient;
import kz.roxy.tsoed.rest.domain.synergy.AsformsDataResponse;
import kz.roxy.tsoed.rest.domain.synergy.AsformsDataSaveResponse;
import kz.roxy.tsoed.rest.domain.synergy.CreateDocResponse;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SynergyRSClientTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SynergyRSClientTest.class);

    @Autowired
    private SynergyRSClient synergyRSClient;

    @Test
    @Ignore
    public void сreateDocTest() throws Exception {

        CreateDocResponse response = synergyRSClient.callRegistryCreateDoc();

        if (response == null) {
            throw new TsoedException("createDocResponse is null");
        }
        LOGGER.info("response: getErrorCode = {}, getDocumentID = {}, getAsfNodeID = {}, getDataUUID = {}",
                response.getErrorCode(), response.getDocumentID(), response.getAsfNodeID(), response.getDataUUID());
    }

    @Test
    @Ignore
    public void callAsformsDataTest() throws Exception {

        String dataUUID = "8cece052-ceb3-454e-8972-73025a929096";

        AsformsDataResponse response = synergyRSClient.callAsformsData(dataUUID);

        if (response == null) {
            throw new TsoedException("asformsDataResponse is null");
        }
        LOGGER.info("response: getForm = {}; getFormVersion = {}; getUuid = {}; getData.size = {}", response.getForm(), response.getFormVersion(), response.getUuid(), response.getData().size());
    }

    @Test
    public void callAsformsDataSaveTest() throws Exception {

        String formUUID =
                "8cece052-ceb3-454e-8972-73025a929096";
//        "952c9122-19e9-4142-a2ba-2d6f7e942024";

        AsformsDataResponse asformsDataResponse = synergyRSClient.callAsformsData(formUUID);

        if (asformsDataResponse == null) {
            throw new TsoedException("asformsDataResponse is null");
        }

        AsformsDataSaveResponse response = synergyRSClient.callAsformsDataSave(
                asformsDataResponse.getUuid(),
                asformsDataResponse.getData()
        );

        if (response == null) {
            throw new TsoedException("response is null");
        }
        LOGGER.info("response: {}",  response);
    }



}
