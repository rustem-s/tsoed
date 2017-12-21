package kz.roxy.coed.service;

import local.edocs523.ws.tsoed.putreference.ArrayOfCorrespondents;
import local.edocs523.ws.tsoed.putreference.Correspondents;
import local.edocs523.ws.tsoed.putreference.ObjectFactory;
import local.edocs523.ws.tsoed.putreference.PutCorrespondentsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class PutReferenceEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(PutReferenceEndpoint.class);

    private static final String RESPONSE_OK = "OK";

    @PayloadRoot(namespace = "http://edocs523.local/ws/tsoed/putreference", localPart = "putCorrespondents")
    @ResponsePayload
    public PutCorrespondentsResponse putCorrespondents(@RequestPayload ArrayOfCorrespondents putCorrespondentsIn) {
        LOGGER.info("putCorrespondentsIn='{}'", putCorrespondentsIn);

        ObjectFactory factory = new ObjectFactory();
        PutCorrespondentsResponse response = factory.createPutCorrespondentsResponse();

        try {


            List<Object> objectList = putCorrespondentsIn.getAny();

            for (Object object : objectList) {
                Correspondents correspondents = (Correspondents) object;
                System.out.println(correspondents.getCode());
            }


            response.setPutCorrespondentsResult(RESPONSE_OK);

            LOGGER.info("Endpoint sending response='{}'", response.getPutCorrespondentsResult());

        } catch (Exception e) {
            response.setPutCorrespondentsResult(e.getMessage());
        }
        return response;
    }
}
