package hr.fer.iot.main;

import hr.fer.iot.resource.MyResource;
import org.eclipse.californium.core.CoapServer;

public class Server {

    public static void main(String [] args){

        CoapServer server = new CoapServer();
        server.add(new MyResource("hello"));
        server.start();
    }
}
