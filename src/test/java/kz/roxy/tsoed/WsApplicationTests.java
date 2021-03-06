package kz.roxy.tsoed;

import kz.roxy.tsoed.webservice.client.PutIngoingClient;
import local.tsoed.ws.processing.index.ArrayOfCorrespondent;
import local.tsoed.ws.processing.index.Correspondent;
import local.tsoed.ws.processing.index.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WsApplicationTests {

    @Autowired
    private PutIngoingClient putIngoingClient;

//    @Test
    public void testPutIngoing() {

        ObjectFactory factory = new ObjectFactory();
        ArrayOfCorrespondent correspondents = factory.createArrayOfCorrespondent();


        Correspondent correspondent = factory.createCorrespondent();

        correspondent.setCorrespondentEsedoid("qwerty");

        correspondents.getAny().add(correspondent);

        assertThat(putIngoingClient.putIngoing(correspondents, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, 0, 0, 0, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
    }
}
