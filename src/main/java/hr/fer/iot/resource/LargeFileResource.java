package hr.fer.iot.resource;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class LargeFileResource extends CoapResource {

    private byte[] field = new byte[2048];

    public LargeFileResource(String name) {
        super(name);
    }

    public byte[] getField() {
        return field;
    }

    public void setField(byte[] field) {
        this.field = field;
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        //exchange.accept();
        System.out.println("GET " + LargeFileResource.class.getName());
        exchange.respond(CoAP.ResponseCode.CONTENT, getField(), MediaTypeRegistry.APPLICATION_OCTET_STREAM); // reply with 2.05 payload (text/plain)

    }
}
