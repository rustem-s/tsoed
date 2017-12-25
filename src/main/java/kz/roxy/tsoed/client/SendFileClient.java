package kz.roxy.tsoed.client;

import local.tsoed.ws.processing.sendfile.FileContent;
import local.tsoed.ws.processing.sendfile.ObjectFactory;
import local.tsoed.ws.processing.sendfile.SendFile;
import local.tsoed.ws.processing.sendfile.SendFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SendFileClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(SendFileClient.class);

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    /**
     * Реализация метода sendFile для ЦОЭД
     * @param fileId
     * @return
     */
    public FileContent sendFile(
            String fileId
    ) {
        ObjectFactory factory = new ObjectFactory();

        SendFile sendFile = factory.createSendFile();

        sendFile.setSFileId(fileId);

        SendFileResponse sendFileResponse = (SendFileResponse) webServiceTemplate.marshalSendAndReceive(sendFile);

        LOGGER.info("Client received response='{}'", sendFileResponse);

        return sendFileResponse.getSendFileResult();
    }

}
