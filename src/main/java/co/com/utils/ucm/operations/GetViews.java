package co.com.utils.ucm.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import co.com.utils.ucm.common.DualInit;
import co.com.utils.ucm.common.ResponseGetViewsDual;

import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.model.DataBinder;
import oracle.stellent.ridc.model.DataObject;
import oracle.stellent.ridc.model.DataResultSet;
import oracle.stellent.ridc.protocol.ServiceResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetViews {
    private static final Logger logger = LoggerFactory.getLogger(GetViews.class);

    public static ResponseGetViewsDual getSchemaViews(DualInit idcDual) {
        try {
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "GET_SCHEMA_VIEWS");

            ServiceResponse response = idcDual.getClient().sendRequest(idcDual.getContext(), binder);

            binder = response.getResponseAsBinder();
            DataResultSet resultSet = binder.getResultSet("SchemaConfigData");

            List<String> nombreListas = new ArrayList();
            for (DataObject lista : resultSet.getRows()) {
                nombreListas.add(lista.get("schObjectName"));
            }

            return new ResponseGetViewsDual(nombreListas, response);
        } catch (IdcClientException e) {
            logger.info("--------------------------------------------------------------------------------------------------");
            logger.info("No se ha ejecutar correctamente el servicio getViews:");
            logger.info("*********************");
            logger.info(e.getLocalizedMessage());
            logger.info("*********************");
        }
        return null;
    }

    public static ResponseGetViewsDual getSchemaViewValues(DualInit idcDual, String Name) {
        try {
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "GET_SCHEMA_VIEW_VALUES");
            binder.putLocal("schViewName", Name);

            ServiceResponse response = idcDual.getClient().sendRequest(idcDual.getContext(), binder);

            binder = response.getResponseAsBinder();

            HashMap<String, List<HashMap<String, String>>> listaResultados = new HashMap();


            for (String resultSet : binder.getResultSetNames()) {
                List<HashMap<String, String>> listaFilas = new ArrayList();


                for (DataObject dataObject : binder.getResultSet(resultSet).getRows()) {
                    HashMap<String, String> viewInfo = new HashMap();

                    for (String key : dataObject.keySet()) {
                        viewInfo.put(key, dataObject.get(key));
                    }
                    listaFilas.add(viewInfo);
                }
                listaResultados.put(resultSet, listaFilas);
            }
            return new ResponseGetViewsDual(listaResultados, response);
        } catch (IdcClientException e) {
            logger.info("--------------------------------------------------------------------------------------------------");
            logger.info("No se ha ejecutar correctamente el servicio getViewsByName:");
            logger.info("*********************");
            logger.info(e.getLocalizedMessage());
            logger.info("*********************");
        }
        return null;
    }
}
