package co.com.utils.ucm.common;

import java.io.InputStream;

import oracle.stellent.ridc.protocol.ServiceResponse;


public class ResponseGetFileDual {
    private InputStream inputStream;
    private ServiceResponse response;
    private Exception exception;

    public ResponseGetFileDual() {
    }

    public ResponseGetFileDual(InputStream is, ServiceResponse sr) {
        this.inputStream = is;
        this.response = sr;
    }

    public void setResponse(ServiceResponse response) {
        this.response = response;
    }

    public ServiceResponse getResponse() {
        return this.response;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return this.exception;
    }
}
