package hr.fer.iot.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.elements.exception.ConnectorException;

import java.io.IOException;

public class Client1 {

    public static void main(String [] args){
        CoapClient client = new CoapClient("coap://localhost/sensors/temp");
        System.out.println(client.getURI());
        client.useCONs();   //useNONs
        //System.out.println("PING resource:" + client.ping());
        try {
            String text = client.get().getResponseText();
            System.out.println("Response: "+ text);
        } catch (ConnectorException | IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
        System.out.println("END");
    }
}
