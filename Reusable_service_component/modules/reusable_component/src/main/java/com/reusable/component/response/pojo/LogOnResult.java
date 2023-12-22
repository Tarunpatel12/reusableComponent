package com.reusable.component.response.pojo;
public class LogOnResult {
    private String ServiceId;
    private String ClientAccessKey;
    private String Token;
    private String Status;
    private String StatusMessage;
    private String InstanceKey;

    public String getServiceId() {
        return ServiceId;
    }

    public void setServiceId(String serviceId) {
        ServiceId = serviceId;
    }

    public String getClientAccessKey() {
        return ClientAccessKey;
    }

    public void setClientAccessKey(String clientAccessKey) {
        ClientAccessKey = clientAccessKey;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStatusMessage() {
        return StatusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        StatusMessage = statusMessage;
    }

    public String getInstanceKey() {
        return InstanceKey;
    }

    public void setInstanceKey(String instanceKey) {
        InstanceKey = instanceKey;
    }
}