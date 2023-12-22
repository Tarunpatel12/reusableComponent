package com.reusable.component.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "http://www.ultipro.com/dataservices/bidata/2")
public class LogOn {
    @XmlElement(name = "logOnRequest", namespace = "http://www.ultipro.com/dataservices/bidata/2")
    private LogOnRequest logOnRequest;

    public LogOnRequest getLogOnRequest() {
        return logOnRequest;
    }

    public void setLogOnRequest(LogOnRequest logOnRequest) {
        this.logOnRequest = logOnRequest;
    }
}

