package co.com.utils.ucm.common;

import oracle.stellent.ridc.IdcClient;
import oracle.stellent.ridc.IdcContext;


public class DualInit {
    private IdcClient client;
    private IdcContext context;
    private String tempDir;

    public DualInit() {
    }

    public DualInit(IdcClient ic, IdcContext ix, String td) {
        this.client = ic;
        this.context = ix;
        this.tempDir = td;
    }

    public void setClient(IdcClient client) {
        this.client = client;
    }

    public IdcClient getClient() {
        return this.client;
    }

    public void setContext(IdcContext context) {
        this.context = context;
    }

    public IdcContext getContext() {
        return this.context;
    }

    public void setTempDir(String tempDir) {
        this.tempDir = tempDir;
    }

    public String getTempDir() {
        return this.tempDir;
    }
}
