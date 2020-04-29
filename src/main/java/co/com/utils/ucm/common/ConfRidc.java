package co.com.utils.ucm.common;

import com.home.SpringBootDemo.config.UcmConfig;
import oracle.stellent.ridc.IdcClient;
import oracle.stellent.ridc.IdcClientConfig;
import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.IdcClientManager;
import oracle.stellent.ridc.IdcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfRidc {
    private static final Logger logger = LoggerFactory.getLogger(ConfRidc.class);

    public DualInit iniciarCliente(UcmConfig ucmConfig) {
        logger.info("Iniciando cliente IDC...");

        try {

            IdcClientManager idcClientManager = new IdcClientManager();
            IdcContext idcContext = new IdcContext(ucmConfig.getUsername(), ucmConfig.getPassword());

            IdcClient idcClient = idcClientManager.createClient(ucmConfig.getUrl());
            IdcClientConfig icfg = idcClient.getConfig();

            icfg.setSocketTimeout(Integer.parseInt(ucmConfig.getSocketTimeout()));
            icfg.setConnectionSize(Integer.parseInt(ucmConfig.getConnectionSize()));
            icfg.setConnectionWaitTime(Integer.parseInt(ucmConfig.getConnectionWaitTime()));
            return new DualInit(idcClient, idcContext, ucmConfig.getTmpDir());
        } catch (IdcClientException e) {
            logger.error("Error creando la configuracion",e);
            return null;
        } catch (Exception ex) {
            logger.error("Error creando la configuracion",ex);
        }
        return null;
    }
}
