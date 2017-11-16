package com.byjw.NLP;

import java.util.ArrayList;
import java.util.List;

public class NLAnalyzeVO {

    private List<String> nouns = new ArrayList<>();
    private List<String> adjs = new ArrayList<>();

    public List<String> getNouns() {
        return nouns;
    }

    public void setNouns(List<String> nouns) {
        this.nouns = nouns;
    }

    public List<String> getAdjs() {
        return adjs;
    }

    public void setAdjs(List<String> adjs) {
        this.adjs = adjs;
    }

    public void addNouns(String noun) {
        nouns.add(noun);
    }

    public void addAdjs(String adj) {
        adjs.add(adj);
    }
}
