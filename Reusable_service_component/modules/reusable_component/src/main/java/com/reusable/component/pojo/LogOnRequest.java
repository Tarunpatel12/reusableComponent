package com.reusable.component.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "http://www.ultipro.com/dataservices/bidata/2")
public class LogOnRequest {
    @XmlElement(namespace = "http://www.ultipro.com/dataservices/bidata/2")
    private String UserName;

    @XmlElement(namespace = "http://www.ultipro.com/dataservices/bidata/2")
    private String Password;

    @XmlElement(namespace = "http://www.ultipro.com/dataservices/bidata/2")
    private String ClientAccessKey;

    @XmlElement(namespace = "http://www.ultipro.com/dataservices/bidata/2")
    private String UserAccessKey;

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getClientAccessKey() {
		return ClientAccessKey;
	}

	public void setClientAccessKey(String clientAccessKey) {
		this.ClientAccessKey = clientAccessKey;
	}

	public String getUserAccessKey() {
		return UserAccessKey;
	}

	public void setUserAccessKey(String userAccessKey) {
		this.UserAccessKey = userAccessKey;
	}
    
    
}
