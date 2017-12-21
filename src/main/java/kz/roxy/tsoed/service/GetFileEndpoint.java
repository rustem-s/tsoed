package kz.roxy.tsoed.service;

import local.edocs523.ws.tsoed.getfile.FileContent;
import local.edocs523.ws.tsoed.getfile.GetFile;
import local.edocs523.ws.tsoed.getfile.GetFileResponse;
import local.edocs523.ws.tsoed.getfile.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GetFileEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetFileEndpoint.class);

    @PayloadRoot(namespace = "http://edocs523.local/ws/tsoed/getfile", localPart = "getFile")
    @ResponsePayload
    public GetFileResponse getFile(@RequestPayload GetFile getFile) {
        LOGGER.info("request='{}'", getFile);

        ObjectFactory factory = new ObjectFactory();
        GetFileResponse response = factory.createGetFileResponse();

        String fileId = getFile.getSFileId();


        FileContent fileContent = factory.createFileContent();
        fileContent.setSFileName("fileName");
        fileContent.setSFileContent("fileContent");
        response.setGetFileResult(fileContent);

        LOGGER.info("Endpoint sending response='{}'", response);

        return response;
    }
}
