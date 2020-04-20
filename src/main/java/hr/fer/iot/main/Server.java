package hr.fer.iot.main;

import hr.fer.iot.resource.LargeFileResource;
import hr.fer.iot.resource.SensorsResource;
import org.eclipse.californium.core.CoapServer;

import java.util.Random;

public class Server {

    public static CoapServer server = new CoapServer();

    public static void main(String [] args){

        server.add(new SensorsResource("sensors"));

        LargeFileResource largeFileResource = new LargeFileResource("longFile");
        byte[] b = new byte[2048];
        new Random().nextBytes(b);
        largeFileResource.setField(b);

        server.add(new LargeFileResource("longFile"));
        server.start();
    }

}
