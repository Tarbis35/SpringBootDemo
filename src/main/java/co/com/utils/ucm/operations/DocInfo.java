package co.com.utils.ucm.operations;

import java.util.HashMap;

import co.com.utils.ucm.common.ConfRidc;
import co.com.utils.ucm.common.DualInit;
import co.com.utils.ucm.common.ResponseDocInfoDual;

import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.model.DataBinder;
import oracle.stellent.ridc.model.DataObject;
import oracle.stellent.ridc.model.DataResultSet;
import oracle.stellent.ridc.protocol.ServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DocInfo {
    private static final Logger logger = LoggerFactory.getLogger(DocInfo.class);
    
    public static ResponseDocInfoDual docInfoByID(DualInit idcDual, int dID) {
        try {
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "DOC_INFO");
            binder.putLocal("dID", Integer.toString(dID));

            ServiceResponse response = idcDual.getClient().sendRequest(idcDual.getContext(), binder);
            binder = response.getResponseAsBinder();
            DataResultSet resultSet = binder.getResultSet("DOC_INFO");
            HashMap<String, String> docInfo = new HashMap();
            for (String key : ((DataObject) resultSet.getRows().get(0)).keySet()) {
                docInfo.put(key, ((DataObject) resultSet.getRows().get(0)).get(key));
            }
            return new ResponseDocInfoDual(docInfo, response);


        } catch (IdcClientException e) {
            logger.error("No se ha ejecutar correctamente el servicio docInfoByID:", e);
        }
        return null;
    }


    public static ResponseDocInfoDual docInfoByName(DualInit idcDual, String dDocName) {
        try {
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "DOC_INFO_BY_NAME");
            binder.putLocal("dDocName", dDocName);

            ServiceResponse response = idcDual.getClient().sendRequest(idcDual.getContext(), binder);
            binder = response.getResponseAsBinder();
            DataResultSet resultSet = binder.getResultSet("DOC_INFO");
            HashMap<String, String> docInfo = new HashMap();
            for (String key : ((DataObject) resultSet.getRows().get(0)).keySet()) {
                docInfo.put(key, ((DataObject) resultSet.getRows().get(0)).get(key));
            }
            return new ResponseDocInfoDual(docInfo, response);

        } catch (IdcClientException e) {
            //System.out.println("--------------------------------------------------------------------------------------------------");
            logger.error("No se ha ejecutar correctamente el servicio docInfoByName:",e);
            //System.out.println("*********************");
            //System.out.println(e.getLocalizedMessage());
            //System.out.println("*********************");
        }
        return null;
    }
}
