package kz.roxy.tsoed.service;

import local.edocs523.ws.tsoed.putdocument.ObjectFactory;
import local.edocs523.ws.tsoed.putdocument.PutIngoing;
import local.edocs523.ws.tsoed.putdocument.PutIngoingResponse;
import local.edocs523.ws.tsoed.putdocument.PutNotificationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PutDocumentEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(PutDocumentEndpoint.class);

    private static final String RESPONSE_OK = "OK";

    @PayloadRoot(namespace = "http://edocs523.local/ws/tsoed/putdocument", localPart = "putIngoing")
    @ResponsePayload
    public PutIngoingResponse putIngoing(@RequestPayload PutIngoing putIngoingIn) {
        LOGGER.info("putIngoingIn='{}'", putIngoingIn);

        ObjectFactory factory = new ObjectFactory();
        PutIngoingResponse response = factory.createPutIngoingResponse();

        try {

            response.setPutIngoingResult(RESPONSE_OK);
            LOGGER.info("Endpoint sending response='{}'", response);

        } catch (Exception e) {
            response.setPutIngoingResult(e.getMessage());
        }
        return response;
    }

    @PayloadRoot(namespace = "http://edocs523.local/ws/tsoed/putdocument", localPart = "putNotification")
    @ResponsePayload
    public PutNotificationResponse putNotification(@RequestPayload PutIngoing putNotificationIn) {
        LOGGER.info("putNotificationIn='{}'", putNotificationIn);

        ObjectFactory factory = new ObjectFactory();
        PutNotificationResponse response = factory.createPutNotificationResponse();

        try {

            response.setPutNotificationResult(RESPONSE_OK);
            LOGGER.info("Endpoint sending response='{}'", response);

        } catch (Exception e) {
            response.setPutNotificationResult(e.getMessage());
        }
        return response;
    }

}
