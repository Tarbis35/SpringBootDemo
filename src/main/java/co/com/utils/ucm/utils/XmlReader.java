package co.com.utils.ucm.utils;

import java.util.logging.Logger;

/*
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import java.security.CodeSource;
import java.security.ProtectionDomain;

import java.util.List;

import org.apache.log4j.Logger;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
*/
public class XmlReader {
    /*
    private static Logger logger;

    private static final String RESOURCES = "/co/com/soaint/compintucm/resources/";
    private String host;
    private String user;
    private String pass;
    private String socketTimeOut;
    private String connections;
    private String connectionWait;
    private String tempDir;

    public XmlReader(String nombreXML) {
        logger.info("------------------------ Ingreso a Propiedades Ridc ---------------------------------");

        SAXBuilder builder = new SAXBuilder();


        try {
            String ruta = "/co/com/soaint/compintucm/resources/" + nombreXML;
            InputStream is = XmlReader.class.getResourceAsStream(ruta);
            if (is == null) {
                //System.out.println(XmlReader.class.getCanonicalName());
                ClassLoader loader = XmlReader.class.getClassLoader();
                //System.out.println(loader.getResource("XmlReader.class"));
                try {
                    String path = XmlReader.class.getProtectionDomain()
                                                 .getCodeSource()
                                                 .getLocation()
                                                 .toURI()
                                                 .getPath();
                    path = path.substring(1, path.length() - 1);
                    path = path.substring(0, path.lastIndexOf("/"));
                    ruta = path + "/co/com/soaint/compintucm/resources/" + nombreXML;
                    //System.out.println("Ruta: " + ruta);
                    is = XmlReader.class.getResourceAsStream(ruta);
                } catch (URISyntaxException e) {
                }
            }
            if (is != null) {
                Document doc = builder.build(is);
                Element element = doc.getRootElement();
                //System.out.println("RootElement: " + element.toString());
                List children = element.getChildren();

                for (int j = 0; j < children.size(); j++) {
                    Element elementAux = (Element) children.get(j);
                    //System.out.println("Name: " + elementAux.getName() + " - Value: " + elementAux.getValue());
                    Object propiedad = elementAux.getName();
                    String propiedadValor = elementAux.getValue();
                    if (propiedad.toString().contains("host")) {
                        setHost(propiedadValor);
                    } else if (propiedad.toString().contains("user")) {
                        setUser(propiedadValor);
                    } else if (propiedad.toString().contains("pass")) {
                        setPass(propiedadValor);
                    } else if (propiedad.toString().contains("socketTimeOut")) {
                        setSocketTimeOut(propiedadValor);
                    } else if (propiedad.toString().contains("connections")) {
                        setConnections(propiedadValor);
                    } else if (propiedad.toString().contains("connectionWait")) {
                        setConnectionWait(propiedadValor);
                    } else if (propiedad.toString().contains("tempDir"))
                        setTempDir(propiedadValor);
                }
            } else {
                logger.info("--------------------------------------------------------------------------------------------------");
                logger.info("No se ha encontrado el archivo en la ruta: " + ruta);
                throw new IOException("No se ha encontrado el archivo en la ruta: " + ruta);
            }
            Document doc;
            logger.info("---------------------------------------------------------------------------------------");
        } catch (JDOMException e) {
            logger.info("--------------------------------------------------------------------------------------------------");
            logger.info("No se ha ejecutado correctamente la Obtencion de Propiedades para Ridc:");
            logger.info("*********************");
            e.printStackTrace();
            logger.info("*********************");
        } catch (IOException e) {
            logger.info("--------------------------------------------------------------------------------------------------");
            logger.info("No se ha ejecutado correctamente la Obtencion de Propiedades para Ridc:");
            logger.info("*********************");
            logger.info(e.getLocalizedMessage());
            logger.info("*********************");
        }
    }


    public String getHost() {
        return this.host;
    }


    public void setHost(String host) {
        this.host = host;
    }


    public String getUser() {
        return this.user;
    }


    public void setUser(String user) {
        this.user = user;
    }


    public String getPass() {
        return this.pass;
    }


    public void setPass(String pass) {
        this.pass = pass;
    }


    public String getSocketTimeOut() {
        return this.socketTimeOut;
    }


    public void setSocketTimeOut(String socketTimeOut) {
        this.socketTimeOut = socketTimeOut;
    }


    public String getConnections() {
        return this.connections;
    }


    public void setConnections(String connections) {
        this.connections = connections;
    }


    public String getConnectionWait() {
        return this.connectionWait;
    }


    public void setConnectionWait(String connectionWait) {
        this.connectionWait = connectionWait;
    }


    public String getTempDir() {
        return this.tempDir;
    }


    public void setTempDir(String tempDir) {
        this.tempDir = tempDir;
    }
*/
}
