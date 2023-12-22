package com.reusable.component.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Header {
	@XmlElement(name = "Action", namespace = "http://www.w3.org/2005/08/addressing")
    private String action;

    @XmlElement(name = "ReplyTo", namespace = "http://www.w3.org/2005/08/addressing")
    private ReplyTo replyTo;

    @XmlElement(name = "To", namespace = "http://www.w3.org/2003/05/soap-envelope")
    private String to;


	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public ReplyTo getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(ReplyTo replyTo) {
		this.replyTo = replyTo;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
