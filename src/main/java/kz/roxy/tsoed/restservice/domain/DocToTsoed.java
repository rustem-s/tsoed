package kz.roxy.tsoed.restservice.domain;

import java.util.List;

public class DocToTsoed {

    private List<Correspondent> correspondentList;

    private String name;

    private List<Correspondent> correspondentFromList;

    private List<Correspondent> performerList;

    private List<Correspondent> performerKzList;

    private String documentId;

    public List<Correspondent> getCorrespondentList() {
        return correspondentList;
    }

    public void setCorrespondentList(List<Correspondent> correspondentList) {
        this.correspondentList = correspondentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
