package Strategy;

import Helper.ErrorDialog;
import fpt.com.*;
import fpt.com.Product;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

/**
 * Created by Team 1/2Hobbyte
 */
public class XMLStrategy implements SerializableStrategy {
    //ML made private
    private FileOutputStream fo;
    private FileInputStream fi;

    private XMLEncoder encoder;
    private XMLDecoder decoder;

    @Override
    public fpt.com.Product readObject() throws IOException {
        Product p = null;
        try {
            p = (Product) decoder.readObject();
        } catch (Exception e) {
            ErrorDialog.error("Unfortunately, the requested file was not found.");
            return null;
        }
        return p;
    }

    @Override
    public void writeObject(Product obj) throws IOException {
        encoder.writeObject(obj);
        encoder.flush();
        System.out.println(encoder + "naksdmkaslkdmas");
    }

    @Override
    public void close() throws IOException {
    }

    @Override
    public void open(InputStream input, OutputStream output) throws IOException {
        if (output != null) {
            this.encoder = new XMLEncoder(output);
        }
        if (input != null) {
            this.decoder = new XMLDecoder(input);
        }
    }
}