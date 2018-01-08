package kz.roxy.tsoed.restservice.domain.synergy;

import java.util.List;

public class AsformsDataResponse {

    private String uuid;
    private Integer version;
    private String form;
    private Integer formVersion;
    private String modified;
    private String nodeUUID;
    private List<AsformsDataData> data = null;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Integer getFormVersion() {
        return formVersion;
    }

    public void setFormVersion(Integer formVersion) {
        this.formVersion = formVersion;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getNodeUUID() {
        return nodeUUID;
    }

    public void setNodeUUID(String nodeUUID) {
        this.nodeUUID = nodeUUID;
    }

    public List<AsformsDataData> getData() {
        return data;
    }

    public void setData(List<AsformsDataData> data) {
        this.data = data;
    }

}
