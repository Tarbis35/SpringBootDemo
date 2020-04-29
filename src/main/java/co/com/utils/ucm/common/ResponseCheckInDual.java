package co.com.utils.ucm.common;

import oracle.stellent.ridc.protocol.ServiceResponse;

public class ResponseCheckInDual {
    private int dID;
    private ServiceResponse response;
    private Exception exception;

    public ResponseCheckInDual() {
        this.dID = -1;
        this.response = null;
    }


    public ResponseCheckInDual(int id, ServiceResponse sr) {
        this.dID = id;
        this.response = sr;
    }

    public void setResponse(ServiceResponse response) {
        this.response = response;
    }

    public ServiceResponse getResponse() {
        return this.response;
    }

    public void setDID(int dID) {
        this.dID = dID;
    }

    public int getDID() {
        return this.dID;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return this.exception;
    }
}
