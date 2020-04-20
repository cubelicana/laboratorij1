package hr.fer.iot.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.elements.exception.ConnectorException;

import java.io.IOException;

public class Client4 {

    public static void main(String [] args){
        CoapClient client = new CoapClient("coap://localhost/longFile");
        System.out.println(client.getURI());
        client.useCONs();   //useNONs
        //System.out.println("PING resource:" + client.ping());
        try {
            String text = client.get(MediaTypeRegistry.APPLICATION_OCTET_STREAM).getResponseText();
            System.out.println("Response: "+ text);
        } catch (ConnectorException | IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
        System.out.println("END");
    }
}
