package co.com.utils.ucm.common;

import java.util.HashMap;

import oracle.stellent.ridc.protocol.ServiceResponse;


public class ResponseDocInfoDual {
    private HashMap<String, String> dataObject;
    private ServiceResponse response;
    private Exception exception;

    public ResponseDocInfoDual() {
    }

    public ResponseDocInfoDual(HashMap<String, String> dto, ServiceResponse sr) {
        this.dataObject = dto;
        this.response = sr;
    }

    public void setResponse(ServiceResponse response) {
        this.response = response;
    }

    public ServiceResponse getResponse() {
        return this.response;
    }

    public void setDataObject(HashMap<String, String> dataObject) {
        this.dataObject = dataObject;
    }

    public HashMap<String, String> getDataObject() {
        return this.dataObject;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return this.exception;
    }
}
