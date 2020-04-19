package hr.fer.iot.main;

import hr.fer.iot.resource.MyResource;
import hr.fer.iot.resource.SensorsResource;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;

public class Server {

    public static CoapServer server = new CoapServer();
    public static void main(String [] args){


        server.add(new MyResource("hello"));

        server.add(new SensorsResource("sensors"));

        //server.add(new MyResource("hello"));
        server.start();
    }
}
