package co.com.utils.ucm.common;

import java.util.HashMap;
import java.util.List;

import oracle.stellent.ridc.protocol.ServiceResponse;


public class ResponseGetViewsDual {
    private List<String> listaNombres;
    private HashMap<String, List<HashMap<String, String>>> listaResultados;
    private ServiceResponse response;
    private Exception exception;

    public ResponseGetViewsDual() {
    }

    public ResponseGetViewsDual(List<String> ln, ServiceResponse sr) {
        this.listaNombres = ln;
        this.response = sr;
    }

    public ResponseGetViewsDual(HashMap<String, List<HashMap<String, String>>> lr, ServiceResponse sr) {
        this.listaResultados = lr;
        this.response = sr;
    }

    public void setListaNombres(List<String> listaNombres) {
        this.listaNombres = listaNombres;
    }

    public List<String> getListaNombres() {
        return this.listaNombres;
    }

    public void setResponse(ServiceResponse response) {
        this.response = response;
    }

    public ServiceResponse getResponse() {
        return this.response;
    }

    public void setListaResultados(HashMap<String, List<HashMap<String, String>>> listaResultados) {
        this.listaResultados = listaResultados;
    }

    public HashMap<String, List<HashMap<String, String>>> getListaResultados() {
        return this.listaResultados;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return this.exception;
    }
}
