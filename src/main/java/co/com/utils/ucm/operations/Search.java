package co.com.utils.ucm.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import co.com.utils.ucm.common.DualInit;
import co.com.utils.ucm.common.ResponseSearchDual;
import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.model.DataBinder;
import oracle.stellent.ridc.model.DataObject;
import oracle.stellent.ridc.model.DataResultSet;
import oracle.stellent.ridc.protocol.ServiceResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Search {
    private static final Logger logger = LoggerFactory.getLogger(Search.class);
    

    public static ResponseSearchDual quickSearch(DualInit idcDual, String queryText, HashMap extraProp) {

        try {
            
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "GET_SEARCH_RESULTS");
            binder.putLocal("QueryText", queryText);
            if (extraProp != null) {
                Iterator it = extraProp.entrySet().iterator();
                //System.out.println("------------------------ Ingreso ExtraProp al Binder ---------------------------------");
                while (it.hasNext()) {
                    Entry e = (Entry) it.next();
                    binder.putLocal(e.getKey().toString(), e.getValue().toString());

                    //System.out.println("extraProp: " + e.getKey().toString() + "=" + e.getValue().toString());
                }
            }


            ServiceResponse response = idcDual.getClient().sendRequest(idcDual.getContext(), binder);
            binder = response.getResponseAsBinder();
            DataResultSet resultSet = binder.getResultSet("SearchResults");
            List<HashMap<String, String>> listaResultados = new ArrayList();
            for (DataObject dataObject : resultSet.getRows()) {
                HashMap<String, String> docInfo = new HashMap();
                for (String key : dataObject.keySet()) {
                    docInfo.put(key, dataObject.get(key));
                }
                listaResultados.add(docInfo);
            }

            return new ResponseSearchDual(listaResultados, response);
        } catch (IdcClientException e) {
            logger.error("Error al ejecutar quicksearch", e);
        }
        return null;
    }


    public static ResponseSearchDual advancedSearch(DualInit idcDual, String queryText, String sortField,
                                                    String sortOrder, int resultCount, HashMap extraProp) {
        try {
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "GET_SEARCH_RESULTS");
            binder.putLocal("QueryText", queryText);
            if (sortField != null)
                binder.putLocal("SortField", sortField);
            if (sortOrder != null)
                binder.putLocal("SortOrder", sortOrder);
            if (resultCount != 0)
                binder.putLocal("ResultCount", Integer.toString(resultCount));
            if (extraProp != null) {
                Iterator it = extraProp.entrySet().iterator();
                //System.out.println("------------------------ Ingreso ExtraProp al Binder ---------------------------------");
                while (it.hasNext()) {
                    Entry e = (Entry) it.next();
                    binder.putLocal(e.getKey().toString(), e.getValue().toString());

                    //System.out.println("extraProp: " + e.getKey().toString() + "=" + e.getValue().toString());
                }
            }


            ServiceResponse response = idcDual.getClient().sendRequest(idcDual.getContext(), binder);
            binder = response.getResponseAsBinder();
            DataResultSet resultSet = binder.getResultSet("SearchResults");
            List<HashMap<String, String>> listaResultados = new ArrayList();
            for (DataObject dataObject : resultSet.getRows()) {
                HashMap<String, String> docInfo = new HashMap();
                for (String key : dataObject.keySet()) {
                    docInfo.put(key, dataObject.get(key));
                }
                listaResultados.add(docInfo);
            }

            return new ResponseSearchDual(listaResultados, response);
        } catch (IdcClientException e) {
            logger.error("Error al ejecutar advancedSearch.", e);
        }
        return null;
    }


    public static ResponseSearchDual navigationSearch(DualInit idcDual, String queryText, String sortField,
                                                      String sortOrder, int resultCount, int pageNumber, int startRow,
                                                      int endRow, HashMap extraProp) {
        try {
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "GET_SEARCH_RESULTS");
            binder.putLocal("QueryText", queryText);
            if (sortField != null)
                binder.putLocal("SortField", sortField);
            if (sortOrder != null)
                binder.putLocal("SortOrder", sortOrder);
            if (resultCount != 0)
                binder.putLocal("ResultCount", Integer.toString(resultCount));
            if (pageNumber != 0)
                binder.putLocal("PageNumber", Integer.toString(pageNumber));
            if (startRow != 0)
                binder.putLocal("StartRow", Integer.toString(startRow));
            if (endRow != 0)
                binder.putLocal("EndRow", Integer.toString(endRow));
            if (extraProp != null) {
                Iterator it = extraProp.entrySet().iterator();
                //System.out.println("------------------------ Ingreso ExtraProp al Binder ---------------------------------");
                while (it.hasNext()) {
                    Entry e = (Entry) it.next();
                    binder.putLocal(e.getKey().toString(), e.getValue().toString());

                    //System.out.println("extraProp: " + e.getKey().toString() + "=" + e.getValue().toString());
                }
            }


            ServiceResponse response = idcDual.getClient().sendRequest(idcDual.getContext(), binder);
            binder = response.getResponseAsBinder();
            DataResultSet resultSet = binder.getResultSet("SearchResults");
            List<HashMap<String, String>> listaResultados = new ArrayList();
            for (DataObject dataObject : resultSet.getRows()) {
                HashMap<String, String> docInfo = new HashMap();
                for (String key : dataObject.keySet()) {
                    docInfo.put(key, dataObject.get(key));
                }
                listaResultados.add(docInfo);
            }

            return new ResponseSearchDual(listaResultados, response);
        } catch (IdcClientException e) {
            logger.error("Error al ejecutar navigationSearch.",e);
        }
        return null;
    }
}
