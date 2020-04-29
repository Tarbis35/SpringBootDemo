package co.com.utils.ucm.common;

import java.util.HashMap;
import java.util.List;

import oracle.stellent.ridc.protocol.ServiceResponse;


public class ResponseSearchDual {
    private List<HashMap<String, String>> listaResultados;
    private ServiceResponse response;
    private Exception exception;

    public ResponseSearchDual() {
    }

    public ResponseSearchDual(List<HashMap<String, String>> drs, ServiceResponse sr) {
        this.listaResultados = drs;
        this.response = sr;
    }

    public void setResponse(ServiceResponse response) {
        this.response = response;
    }

    public ServiceResponse getResponse() {
        return this.response;
    }

    public void setListaResultados(List<HashMap<String, String>> listaResultados) {
        this.listaResultados = listaResultados;
    }

    public List<HashMap<String, String>> getListaResultados() {
        return this.listaResultados;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return this.exception;
    }
}
