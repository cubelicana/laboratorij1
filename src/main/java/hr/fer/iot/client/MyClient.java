package hr.fer.iot.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.elements.exception.ConnectorException;

import java.io.IOException;


public class MyClient {

    public static void main(String [] args){
        CoapClient client = new CoapClient("coap://localhost/hello");
        System.out.println(client.getURI());
        client.useNONs();   //useNONs
        System.out.println("PING resource:" + client.ping());
        try {
            String text = client.get().getResponseText();
            System.out.println("Response: "+ text);
        } catch (ConnectorException | IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
        System.out.println("KRAJ");
    }

}
