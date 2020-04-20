package hr.fer.iot.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.observe.NotificationListener;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.elements.exception.ConnectorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Thread.sleep;
import static javafx.application.Platform.exit;

public class Client3 {

    public static void main(String[] args) throws InterruptedException {
        CoapClient client = new CoapClient("coap://localhost/sensors/temp");

        System.out.println("OBSERVE (press enter to exit)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Start");

        CoapObserveRelation relation = client.observe(
                new CoapHandler() {
                    @Override
                    public void onLoad(CoapResponse response) {
                        String content = response.getResponseText();
                        System.out.println("NOTIFICATION: " + content);
                    }

                    @Override
                    public void onError() {
                        System.err.println("OBSERVING FAILED (press enter to exit)");
                    }
                });
        while(true)
        //System.out.println("EXIT");
        // wait for user
        {
            System.out.println("CHECK");
            relation.reregister();
            System.out.println("Reregistration");
            sleep(3000);
        }

        //System.out.println("CANCELLATION");

        //relation.proactiveCancel();

        //exit();
    }
}
