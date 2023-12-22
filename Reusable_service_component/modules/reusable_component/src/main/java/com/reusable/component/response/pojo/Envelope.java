package com.reusable.component.response.pojo;

//@JacksonXmlRootElement(localName = "Envelope", namespace = "http://www.w3.org/2003/05/soap-envelope")
public class Envelope {

    private Header header;

    private LogOnResponse logOnResponse;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public LogOnResponse getLogOnResponse() {
        return logOnResponse;
    }

    public void setLogOnResponse(LogOnResponse logOnResponse) {
        this.logOnResponse = logOnResponse;
    }
}