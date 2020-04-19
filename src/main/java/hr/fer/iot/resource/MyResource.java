package hr.fer.iot.resource;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class MyResource extends CoapResource {

    public MyResource(String name) {
        super(name);
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        System.out.println("MyResource GET");
        exchange.respond("hello world, I'm pretty much alive"); // reply with 2.05 payload (text/plain)
    }
    @Override
    public void handlePOST(CoapExchange exchange) {
        System.out.println("MyResource POST");
        exchange.accept(); // make it a separate response
        /*if (exchange.getRequestOptions()) {
            // do something specific to the request options
        }*/
        exchange.respond(CoAP.ResponseCode.CREATED); // reply with response code only (shortcut)
    }

}
