package com.reusable.component.response.pojo;
class Action {
    //@JacksonXmlProperty(isAttribute = true)
    private String mustUnderstand;

    private String value;

    public String getMustUnderstand() {
        return mustUnderstand;
    }

    public void setMustUnderstand(String mustUnderstand) {
        this.mustUnderstand = mustUnderstand;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}