package kz.roxy.tsoed.webservice.client;

import local.tsoed.ws.processing.notification.ArrayOfCorrespondent;
import local.tsoed.ws.processing.notification.PutNotification;
import local.tsoed.ws.processing.notification.PutNotificationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class PutNotificationClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(PutNotificationClient.class);

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public String putNotification(
            ArrayOfCorrespondent correspondentFrom

    ) {
        local.tsoed.ws.processing.notification.ObjectFactory factory = new local.tsoed.ws.processing.notification.ObjectFactory();

        PutNotification putNotification = factory.createPutNotification();

        putNotification.setCorrespondentFrom(correspondentFrom);


        PutNotificationResponse putNotificationResponse = (PutNotificationResponse) webServiceTemplate.marshalSendAndReceive(putNotification);

        LOGGER.info("Client received response='{}'", putNotificationResponse.getPutNotificationResult());
        return putNotificationResponse.getPutNotificationResult();
    }

}
