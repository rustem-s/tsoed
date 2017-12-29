package kz.roxy.tsoed.service.client;

import local.tsoed.ws.processing.index.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.datatype.XMLGregorianCalendar;

@Component
public class PutIngoingClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(PutIngoingClient.class);

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public String putIngoing(
            ArrayOfCorrespondent correspondentFrom,
            ArrayOfCorrespondent correspondentFromKz,
            ArrayOfCorrespondent performers,
            ArrayOfCorrespondent performersKz,
            String documentid,
            String from,
            String doclogSendTime,
            String outgoingNumber,
            XMLGregorianCalendar outgoingDate,
            String author,
            String authorKz,
            String performer,
            String performerKz,
            String performerPhone,
            String documentLang,
            String documentFrom,
            String controlTypeCode,
            String controlType,
            String controlTypeKz,
            XMLGregorianCalendar externalDeadline,
            String rank,
            String rankKz,
            String  deliveryMethod,
            int page,
            int  app,
            int copy,
            String  documentTypeEsedoid,
            String documentTypeEsedoidKz,
            String questionTypeEsedoid,
            String questionTypeEsedoidKz,
            String content,
            ArrayOfFileLink attachments,
            ArrayOfFileLink attachments2,
            ArrayOfSign kancSign,
            ArrayOfSign rukSign,
            ArrayOfDocument answer,
            String docToNumber,
            String signerName,
            String signerNameKz,
            XMLGregorianCalendar preparedDate,
            String note,
            String resolution,
            String receiverFioRu,
            String requestAnswer,
            String sectionId,
            String userUin,
            String idPortalInternal,
            String docNoR,
            String documentReceiverKz

    ) {
        local.tsoed.ws.processing.index.ObjectFactory factory = new local.tsoed.ws.processing.index.ObjectFactory();

        PutIngoing putIngoing = factory.createPutIngoing();
        putIngoing.setCorrespondentFrom(correspondentFrom);
        putIngoing.setCorrespondentFromKz(correspondentFromKz);
        putIngoing.setPerformers(performers);
        putIngoing.setPerformersKz(performersKz);
        putIngoing.setDocumentid(documentid);
        putIngoing.setFrom(from);
        putIngoing.setDoclogSendTime(doclogSendTime);
        putIngoing.setOutgoingNumber(outgoingNumber);
        putIngoing.setOutgoingDate(outgoingDate);
        putIngoing.setAuthor(author);
        putIngoing.setAuthorKz(authorKz);
        putIngoing.setPerformer(performer);
        putIngoing.setPerformerKz(performerKz);
        putIngoing.setPerformerPhone(performerPhone);
        putIngoing.setDocumentLang(documentLang);
        putIngoing.setDocumentForm(documentFrom);
        putIngoing.setControlTypeCode(controlTypeCode);
        putIngoing.setControlType(controlType);
        putIngoing.setControlTypeKz(controlTypeKz);
        putIngoing.setExternalDeadline(externalDeadline);
        putIngoing.setRank(rank);
        putIngoing.setRankKz(rankKz);
        putIngoing.setDeliveryMethod(deliveryMethod);
        putIngoing.setPage(page);
        putIngoing.setApp(app);
        putIngoing.setCopy(copy);
        putIngoing.setDocumentTypeEsedoid(documentTypeEsedoid);
        putIngoing.setDocumentTypeEsedoidKz(documentTypeEsedoidKz);
        putIngoing.setQuestionTypeEsedoid(questionTypeEsedoid);
        putIngoing.setQuestionTypeEsedoidKz(questionTypeEsedoidKz);
        putIngoing.setContent(content);
        putIngoing.setAttachments(attachments);
        putIngoing.setAttachments2(attachments2);
        putIngoing.setKancSign(kancSign);
        putIngoing.setRukSign(rukSign);
        putIngoing.setAnswer(answer);
        putIngoing.setDocToNumber(docToNumber);
        putIngoing.setSignerName(signerName);
        putIngoing.setSignerNameKz(signerNameKz);
        putIngoing.setPreparedDate(preparedDate);
        putIngoing.setNote(note);
        putIngoing.setResolution(resolution);
        putIngoing.setReceiverFioRu(receiverFioRu);
        putIngoing.setRequestAnswer(requestAnswer);
        putIngoing.setSectionId(sectionId);
        putIngoing.setUserUin(userUin);
        putIngoing.setIdPortalInternal(idPortalInternal);
        putIngoing.setDocNoR(docNoR);
        putIngoing.setDocumentReceiverKz(documentReceiverKz);

        PutIngoingResponse putIngoingResponse = (PutIngoingResponse) webServiceTemplate.marshalSendAndReceive(putIngoing);

        LOGGER.info("Client received response='{}'", putIngoingResponse.getPutIngoingResult());
        return putIngoingResponse.getPutIngoingResult();
    }
}
