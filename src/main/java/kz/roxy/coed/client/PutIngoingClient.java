package kz.roxy.coed.client;

import local.tsoed.ws.processing.index.ArrayOfCorrespondent;
import local.tsoed.ws.processing.index.ObjectFactory;
import local.tsoed.ws.processing.index.PutIngoing;
import local.tsoed.ws.processing.index.PutIngoingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class PutIngoingClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(PutIngoingClient.class);

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public String putIngoing(
            ArrayOfCorrespondent correspondentFrom,
            ArrayOfCorrespondent correspondentFromKz,
            ArrayOfCorrespondent performers,
            ArrayOfCorrespondent performersKz

    ) {
        ObjectFactory factory = new ObjectFactory();

        PutIngoing putIngoing = factory.createPutIngoing();
        putIngoing.setCorrespondentFrom(correspondentFrom);
        putIngoing.setCorrespondentFromKz(correspondentFromKz);
        putIngoing.setPerformers(performers);
        putIngoing.setPerformersKz(performersKz);
        //putIngoing.


        PutIngoingResponse putIngoingResponse = (PutIngoingResponse) webServiceTemplate.marshalSendAndReceive(putIngoing);

        LOGGER.info("Client received response='{}'", putIngoingResponse.getPutIngoingResult());
        return putIngoingResponse.getPutIngoingResult();
    }
}
