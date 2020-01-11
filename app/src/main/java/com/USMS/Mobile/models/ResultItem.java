package com.USMS.Mobile.models;

public class ResultItem {
    private String module;
    private String attOne;
    private String attTwo;

    public ResultItem(String module, String attOne, String attTwo) {
        this.module = module;
        this.attOne = attOne;
        this.attTwo = attTwo;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getAttOne() {
        return attOne;
    }

    public void setAttOne(String attOne) {
        this.attOne = attOne;
    }

    public String getAttTwo() {
        return attTwo;
    }

    public void setAttTwo(String attTwo) {
        this.attTwo = attTwo;
    }
}
