package main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class RemoteProvider implements DataProvider {
    private String url;

    @Override
    public byte[] getData(String url) {
        try{
            URLConnection conn = new URL(url).openConnection();
            try (InputStream is = conn.getInputStream()) {
                byte[] byteChunk = new byte[4096];
                int n;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                while ( (n = is.read(byteChunk)) > 0 ) {
                    baos.write(byteChunk, 0, n);
                }
                return baos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
