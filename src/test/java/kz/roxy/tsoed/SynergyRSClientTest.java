package kz.roxy.tsoed;

import kz.roxy.tsoed.rest.SynergyRSClient;
import kz.roxy.tsoed.rest.domain.synergy.CreateDocResponse;
import org.junit.Test;
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
    public void getCreateDoc() throws Exception {
        ResponseEntity<CreateDocResponse> response = synergyRSClient.callRegistryCreateDoc();

        CreateDocResponse createDocResponse = response.getBody();
        if (createDocResponse == null) {
            throw new TsoedException("createDocResponse is null");
        }
        LOGGER.info("response: getErrorCode = {}, getDocumentID = {}, getAsfNodeID = {}, getDataUUID = {}",
                createDocResponse.getErrorCode(), createDocResponse.getDocumentID(), createDocResponse.getAsfNodeID(), createDocResponse.getDataUUID());
    }
}
