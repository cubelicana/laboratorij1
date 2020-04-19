package hr.fer.iot.resource;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class TemperatureResource extends CoapResource {

    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public TemperatureResource(String name) {
        super(name);
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        //exchange.accept();
        System.out.println("GET " + TemperatureResource.class.getName());
        exchange.respond(CoAP.ResponseCode.CONTENT, "Temperature: " + getTemperature()); // reply with 2.05 payload (text/plain)
    }
}
