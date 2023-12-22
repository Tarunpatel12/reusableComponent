package com.reusable.component.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Body {
    @XmlElement(name = "LogOn", namespace = "http://www.ultipro.com/dataservices/bidata/2")
    private LogOn logOn;

    public LogOn getLogOn() {
        return logOn;
    }

    public void setLogOn(LogOn logOn) {
        this.logOn = logOn;
    }
}

