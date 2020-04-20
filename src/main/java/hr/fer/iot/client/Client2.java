package hr.fer.iot.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.elements.exception.ConnectorException;

import java.io.IOException;

public class Client2 {

    public static void main(String [] args){
        CoapClient client = new CoapClient("coap://localhost/sensors");
        System.out.println(client.getURI());
        client.useCONs();   //useNONs

        //System.out.println("PING resource:" + client.ping());
        try {
            CoapResponse response = client.post("temp", MediaTypeRegistry.TEXT_PLAIN);
            System.out.println("Response: "+ response.getCode() + " - " + response.getResponseText());
        } catch (ConnectorException | IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
        System.out.println("END");
    }
}
