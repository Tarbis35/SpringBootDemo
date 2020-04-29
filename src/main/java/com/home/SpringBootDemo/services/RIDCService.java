package com.home.SpringBootDemo.services;

import co.com.utils.ucm.common.ConfRidc;
import co.com.utils.ucm.common.DualInit;
import co.com.utils.ucm.common.ResponseSearchDual;
import co.com.utils.ucm.operations.Search;
import com.home.SpringBootDemo.config.UcmConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class RIDCService {

    @Autowired
    private UcmConfig ucmConfig;

    private static DualInit idcDual ;

    private static final Logger logger = LoggerFactory.getLogger(ConfRidc.class);

    public void SearchDocs(){
        idcDual = new ConfRidc().iniciarCliente(ucmConfig);

        String queryText = "dDocTitle <CONTAINS> `Brief`";
        ResponseSearchDual searchResponse;
        HashMap extraProp = new HashMap();
        extraProp.put("ResultCount", "1");
        searchResponse = Search.quickSearch(idcDual, queryText, extraProp);

        logger.info("Numero de resultados : "+searchResponse.getListaResultados().size());

        for(HashMap map : searchResponse.getListaResultados()){
            for(Object obj : map.entrySet()){
                if(obj != null){
                    logger.info(((Map.Entry)obj).getKey()+" : "+((Map.Entry)obj).getValue());

                }
            }
        }
    }
}
