package co.com.utils.ucm.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Conversor {
    private static final Logger logger = LoggerFactory.getLogger(Conversor.class);
    public static File inputStreamAFile(InputStream inputStream, String rutaSalida) {
        File archivo = null;
        try {
            archivo = new File(rutaSalida);
            OutputStream outputStream = new FileOutputStream(archivo);
            IOUtils.copy(inputStream, outputStream);
            //outputStream.write(IOUtils.readFully(inputStream, -1, true));
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return archivo;
    }


    public static File outputStreamAFile(OutputStream outputStream, String rutaSalida) {
        File archivo = null;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray());
            archivo = new File(rutaSalida);
            OutputStream outputStreamAux = new FileOutputStream(archivo);
            IOUtils.copy(bais, outputStream);
            //outputStreamAux.write(IOUtils.readFully(bais, -1, true));
            outputStreamAux.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return archivo;
    }


    public static void deleteFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.exists())
                file.delete();
        } catch (Exception e) {
            //System.out.println("deleteFile: " + e.getMessage());
        }
    }


    public static void deleteFile(File file) {
        try {
            if (file.exists())
                file.delete();
        } catch (Exception e) {
            //System.out.println("deleteFile: " + e.getMessage());
        }
    }
}
