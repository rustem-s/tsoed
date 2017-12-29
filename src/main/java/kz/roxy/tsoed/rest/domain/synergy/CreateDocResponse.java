package kz.roxy.tsoed.rest.domain.synergy;

public class CreateDocResponse {
    private String errorCode;
    private String documentID;
    private String dataUUID;
    private String asfNodeID;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getDataUUID() {
        return dataUUID;
    }

    public void setDataUUID(String dataUUID) {
        this.dataUUID = dataUUID;
    }

    public String getAsfNodeID() {
        return asfNodeID;
    }

    public void setAsfNodeID(String asfNodeID) {
        this.asfNodeID = asfNodeID;
    }
}
