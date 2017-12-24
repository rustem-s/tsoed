package kz.roxy.tsoed;

import kz.roxy.tsoed.rest.RestClient;
import kz.roxy.tsoed.rest.domain.synergy.Form;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SynergyStubRsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SynergyStubRsTest.class);

    @Autowired
    private RestClient restClient;

    @Test
    public void getForm() throws Exception {
        Form form = restClient.callGetForm("1");
        LOGGER.info("form = {}, {}", form.getField1(), form.getField2());
    }
}
