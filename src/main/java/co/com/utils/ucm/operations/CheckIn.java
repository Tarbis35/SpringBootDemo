package co.com.utils.ucm.operations;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


import co.com.utils.ucm.common.ConfRidc;
import co.com.utils.ucm.common.DualInit;
import co.com.utils.ucm.common.ResponseCheckInDual;
import co.com.utils.ucm.common.ResponseDocInfoDual;
import co.com.utils.ucm.utils.Conversor;
import oracle.stellent.ridc.IdcClient;
import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.model.DataBinder;
import oracle.stellent.ridc.protocol.ServiceResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckIn {
    private static final Logger logger = LoggerFactory.getLogger(CheckIn.class);
    
    public static final String RESULTADO_ESTADO = "status";
    public static final String RESULTADO_RESPONSE = "response";
    public static final String ESTADO_PUBLICADO = "RELEASED";

    public static ResponseCheckInDual checkInUniversal(DualInit idcDual, HashMap metadata, File archivoPrimario) {
        ResponseCheckInDual responseCheckInDual = new ResponseCheckInDual();
        try {
            
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "CHECKIN_UNIVERSAL");

            Iterator it = metadata.entrySet().iterator();
            //System.out.println("------------------------ Ingreso Metadatos al Binder ---------------------------------");
            while (it.hasNext()) {
                Entry e = (Entry) it.next();
                Object key = e.getKey();
                Object value = e.getValue();
                if (key != null) {
                    binder.putLocal(key.toString(), value != null ? value.toString() : "");
                }
                //System.out.println("Metadato: " + key + "=" + value);
            }
            //System.out.println("---------------------------------------------------------------------------------------");
            if (archivoPrimario != null)
                binder.addFile("primaryFile", archivoPrimario);
            ServiceResponse response = idcDual.getClient().sendRequest(idcDual.getContext(), binder);
            //System.out.println(response.getResponseAsString());
            int dID = Integer.parseInt(response.getResponseAsBinder().getLocal("dID"));
            responseCheckInDual = new ResponseCheckInDual(dID, response);
            Conversor.deleteFile(archivoPrimario);
        } catch (IdcClientException e) {
            responseCheckInDual.setException(e);
            //System.out.println("--------------------------------------------------------------------------------------------------");
            //System.out.println("No se ha ejecutado correctamente el servicio checkInUniversal:");
            //System.out.println("*********************");
            //System.out.println(e.getLocalizedMessage());
            //System.out.println("*********************");
        } catch (IOException e) {
            responseCheckInDual.setException(e);
            //System.out.println("--------------------------------------------------------------------------------------------------");
            //System.out.println("No se ha ejecutado correctamente el servicio checkInUniversal:");
            //System.out.println("*********************");
            //System.out.println(e.getLocalizedMessage());
            //System.out.println("*********************");
        }
        return responseCheckInDual;
    }


    public static HashMap checkInUniversal(DualInit idcDual, HashMap metadata, File archivoPrimario, int reintentos,
                                           int segundosEspera) {
        HashMap respuesta = new HashMap();
        String estado = null;
        ResponseCheckInDual responseCheckInDual = null;
        ResponseDocInfoDual responseDocInfoDual = new ResponseDocInfoDual();
        int contador = 0;
        if (segundosEspera <= 0)
            segundosEspera = 1;
        if (reintentos < 0)
            reintentos = 1;
        responseCheckInDual = checkInUniversal(idcDual, metadata, archivoPrimario);
        Conversor.deleteFile(archivoPrimario);
        String dDocName = null;
        if (responseCheckInDual.getResponse() == null) {
            //System.out.println("No se ha ejecutado correctamente el servicio checkInUniversal:");
            responseDocInfoDual.setException(responseCheckInDual.getException());
        } else {
            try {
                ServiceResponse ServiceResponse = responseCheckInDual.getResponse();
                dDocName = ServiceResponse.getResponseAsBinder().getLocal("dDocName");

                while (contador <= reintentos) {
                    responseDocInfoDual = DocInfo.docInfoByName(idcDual, dDocName);
                    ServiceResponse sr = responseDocInfoDual.getResponse();
                    HashMap<String, String> resultado = responseDocInfoDual.getDataObject();
                    //System.out.println("resultado obtenido");
                    estado = (String) resultado.get("dStatus");
                    //System.out.println("Estado: " + estado);
                    if ((resultado != null) && (estado.equalsIgnoreCase("RELEASED"))) {
                        break;
                    }
                    contador++;
                    try {
                        Thread.sleep(segundosEspera * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IdcClientException e) {
                responseDocInfoDual.setException(e);
                //System.out.println("--------------------------------------------------------------------------------------------------");
                //System.out.println("No se ha ejecutado correctamente el servicio checkInUniversal con Verificacion");
                //System.out.println("*********************");
                //System.out.println(e.getLocalizedMessage());
                //System.out.println("*********************");
            }
        }
        respuesta.put("response", responseDocInfoDual);
        respuesta.put("status", estado);
        return respuesta;
    }


    public static ServiceResponse checkOut(DualInit idcDual, int dID) {
        ServiceResponse response = null;
        ResponseCheckInDual responseCheckInDual = new ResponseCheckInDual();
        try {
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "CHECKOUT");
            binder.putLocal("dID", Integer.toString(dID));
            response = idcDual.getClient().sendRequest(idcDual.getContext(), binder);
            //System.out.println(response.getResponseAsString());
            responseCheckInDual = new ResponseCheckInDual(dID, response);
        } catch (IdcClientException e) {
            responseCheckInDual.setException(e);
            //System.out.println("--------------------------------------------------------------------------------------------------");
            //System.out.println("No se ha ejecutar correctamente el servicio checkOut:");
            //System.out.println("*********************");
            //System.out.println(e.getLocalizedMessage());
            //System.out.println("*********************");
        } catch (Exception e) {
            responseCheckInDual.setException(e);
            //System.out.println("--------------------------------------------------------------------------------------------------");
            //System.out.println("No se ha ejecutar correctamente el servicio checkOut:");
            //System.out.println("*********************");
            //System.out.println(e.getLocalizedMessage());
            //System.out.println("*********************");
        }
        return response;
    }


    public static ServiceResponse checkOutByName(DualInit idcDual, String dDocName) {
        ServiceResponse response = null;
        ResponseCheckInDual responseCheckInDual = new ResponseCheckInDual();
        try {
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "CHECKOUT_BY_NAME");
            binder.putLocal("dDocName", dDocName);
            response = idcDual.getClient().sendRequest(idcDual.getContext(), binder);
            //System.out.println(response.getResponseAsString());
            int dID = Integer.parseInt(response.getResponseAsBinder().getLocal("dID"));
            responseCheckInDual = new ResponseCheckInDual(dID, response);
        } catch (IdcClientException e) {
            responseCheckInDual.setException(e);
            //System.out.println("--------------------------------------------------------------------------------------------------");
            //System.out.println("No se ha ejecutar correctamente el servicio checkOutByName:");
            //System.out.println("*********************");
            //System.out.println(e.getLocalizedMessage());
            //System.out.println("*********************");
        } catch (Exception e) {
            responseCheckInDual.setException(e);
            //System.out.println("--------------------------------------------------------------------------------------------------");
            //System.out.println("No se ha ejecutar correctamente el servicio checkOutByName:");
            //System.out.println("*********************");
            //System.out.println(e.getLocalizedMessage());
            //System.out.println("*********************");
        }
        return response;
    }


    public static ServiceResponse undoCheckOut(DualInit idcDual, int dID) {
        try {
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "UNDO_CHECKOUT");
            binder.putLocal("dID", Integer.toString(dID));

            return idcDual.getClient().sendRequest(idcDual.getContext(), binder);
        } catch (IdcClientException e) {
            //System.out.println("--------------------------------------------------------------------------------------------------");
            //System.out.println("No se ha ejecutar correctamente el servicio undoCheckOut:");
            //System.out.println("*********************");
            //System.out.println(e.getLocalizedMessage());
            //System.out.println("*********************");
        }
        return null;
    }


    public static ServiceResponse undoCheckOutByName(DualInit idcDual, String dDocName) {
        try {
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "UNDO_CHECKOUT_BY_NAME");
            binder.putLocal("dDocName", dDocName);

            return idcDual.getClient().sendRequest(idcDual.getContext(), binder);
        } catch (IdcClientException e) {
            //System.out.println("--------------------------------------------------------------------------------------------------");
            //System.out.println("No se ha ejecutar correctamente el servicio undoCheckOutByName:");
            //System.out.println("*********************");
            //System.out.println(e.getLocalizedMessage());
            //System.out.println("*********************");
        }
        return null;
    }


    public static ServiceResponse updateDocInfo(DualInit idcDual, HashMap metadata) {
        try {
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "UPDATE_DOCINFO");

            Iterator it = metadata.entrySet().iterator();
            //System.out.println("------------------------ Ingreso Metadatos al Binder ---------------------------------");
            while (it.hasNext()) {
                Entry e = (Entry) it.next();
                Object key = e.getKey();
                Object value = e.getValue();
                if (key != null) {
                    binder.putLocal(key.toString(), value != null ? value.toString() : "");
                }
                //System.out.println("Metadato: " + key + "=" + value);
            }
            //System.out.println("---------------------------------------------------------------------------------------");

            ServiceResponse response = idcDual.getClient().sendRequest(idcDual.getContext(), binder);
            //System.out.println("Se ejecut� correctamente el servicio");
            return response;
        } catch (IdcClientException e) {
            //System.out.println("--------------------------------------------------------------------------------------------------");
            //System.out.println("No se ha ejecutado correctamente el servicio updateDocInfo:");
            //System.out.println("*********************");
            //System.out.println(e.getLocalizedMessage());
            //System.out.println("*********************");
        }
        return null;
    }


    public static ServiceResponse deleteRevision(DualInit idcDual, int dID) {
        try {
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "DELETE_REV");
            binder.putLocal("dID", Integer.toString(dID));

            return idcDual.getClient().sendRequest(idcDual.getContext(), binder);
        } catch (IdcClientException e) {
            //System.out.println("--------------------------------------------------------------------------------------------------");
            //System.out.println("No se ha ejecutar correctamente el servicio undoCheckOut:");
            //System.out.println("*********************");
            //System.out.println(e.getLocalizedMessage());
            //System.out.println("*********************");
        }
        return null;
    }
}
