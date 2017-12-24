package kz.roxy.tsoed.rest.domain;

import java.util.List;

public class DocToTsoed {

    private List<Correspondent> correspondentList;

    public List<Correspondent> getCorrespondentList() {
        return correspondentList;
    }

    public void setCorrespondentList(List<Correspondent> correspondentList) {
        this.correspondentList = correspondentList;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
