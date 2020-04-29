package co.com.utils.ucm.operations;

import co.com.utils.ucm.common.DualInit;
import co.com.utils.ucm.common.ResponseGetFileDual;

import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.model.DataBinder;
import oracle.stellent.ridc.protocol.ServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GetFile {
    private static final Logger logger = LoggerFactory.getLogger(GetFile.class);
    public static final String RENDITION_PRIMARY = "Primary";
    public static final String RENDITION_WEB = "Web";
    public static final String REVISION_LATEST = "Latest";
    public static final String REVISION_LATESTRELEASE = "LatestReleased";

    public static ResponseGetFileDual getFileByID(DualInit idcDual, int dID) {
        return getFileByID(idcDual, dID, null);
    }


    public static ResponseGetFileDual getFileByID(DualInit idcDual, int dID, String rendition) {
        try {
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "GET_FILE");
            binder.putLocal("dID", Integer.toString(dID));
            binder.putLocal("Rendition",
                            (rendition != null) && (!rendition.equalsIgnoreCase("")) ? rendition : "Primary");

            ServiceResponse response = idcDual.getClient().sendRequest(idcDual.getContext(), binder);
            return new ResponseGetFileDual(response.getResponseStream(), response);
        } catch (IdcClientException e) {
            //System.out.println("--------------------------------------------------------------------------------------------------");
            //System.out.println("No se ha ejecutar correctamente el servicio getFileByID:");
            //System.out.println("*********************");
            //System.out.println(e.getLocalizedMessage());
            //System.out.println("*********************");
        }
        return null;
    }

    public static ResponseGetFileDual getFileByName(DualInit idcDual, String dDocName, String revisionSelectionMethod) {
        return getFileByName(idcDual, dDocName, revisionSelectionMethod, null);
    }

    public static ResponseGetFileDual getFileByName(DualInit idcDual, String dDocName, String revisionSelectionMethod,
                                                    String rendition) {
        try {
            DataBinder binder = idcDual.getClient().createBinder();
            binder.putLocal("IdcService", "GET_FILE");
            binder.putLocal("dDocName", dDocName);
            binder.putLocal("RevisionSelectionMethod", revisionSelectionMethod);

            binder.putLocal("Rendition",
                            (rendition != null) && (!rendition.equalsIgnoreCase("")) ? rendition : "Primary");

            ServiceResponse response = idcDual.getClient().sendRequest(idcDual.getContext(), binder);
            return new ResponseGetFileDual(response.getResponseStream(), response);
        } catch (IdcClientException e) {
            //System.out.println("--------------------------------------------------------------------------------------------------");
            //System.out.println("No se ha ejecutar correctamente el servicio getFileByName:");
            //System.out.println("*********************");
            //System.out.println(e.getLocalizedMessage());
            //System.out.println("*********************");
        }
        return null;
    }
}
