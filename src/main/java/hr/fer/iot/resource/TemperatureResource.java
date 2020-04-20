package hr.fer.iot.resource;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.observe.ObserveRelation;
import org.eclipse.californium.core.observe.ObserveRelationFilter;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.core.server.resources.ConcurrentCoapResource;

import java.util.TimerTask;

public class TemperatureResource extends CoapResource {

    private String temperature;

    private String getTemperature() {
        return temperature;
    }

    void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    TemperatureResource(String name) {
        super(name);
        setObservable(true);

        changed();
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        exchange.accept();
        System.out.println("GET " + TemperatureResource.class.getName());
        exchange.respond(CoAP.ResponseCode.CONTENT, "Temperature: " + getTemperature()); // reply with 2.05 payload (text/plain)
    }

    private class UpdateTask extends TimerTask {
        @Override
        public void run() {
            // .. periodic update of the resource
            System.out.println("CHANGED!");
            changed(); // notify all observers
        }
    }
}
