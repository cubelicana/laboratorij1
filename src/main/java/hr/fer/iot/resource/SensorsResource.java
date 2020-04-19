package hr.fer.iot.resource;

import hr.fer.iot.main.Server;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.core.server.resources.Resource;

import java.util.Random;

public class SensorsResource extends CoapResource {

    public SensorsResource(String name) {
        super(name);
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        exchange.respond(CoAP.ResponseCode.METHOD_NOT_ALLOWED, "This method is not allowed");
    }

    @Override
    public void handlePOST(CoapExchange exchange){
        exchange.accept();
        String childPath = exchange.getRequestText();

        Resource resource = this;

        TemperatureResource temperatureResource = new TemperatureResource(childPath);
        temperatureResource.setTemperature(getRandomNumber());
        resource.add(temperatureResource);

        System.out.println("Added resource: " + temperatureResource.getName());
        Server.server.add(resource);

        exchange.respond(CoAP.ResponseCode.CREATED, "New resource is added to server");
    }

    private String getRandomNumber(){
        Random random = new Random();
        int rand_int = random.nextInt(1000);
        return String.valueOf(rand_int);
    }
}
