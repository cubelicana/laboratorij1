package hr.fer.iot.resource;

import hr.fer.iot.main.Server;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.core.server.resources.Resource;

import java.util.Random;

import static java.lang.Thread.sleep;

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
        changeTempValue(childPath);
    }

    private String getRandomNumber(){
        Random random = new Random();
        int rand_int = random.nextInt(1000);
        return String.valueOf(rand_int);
    }

    private void changeTempValue(String childPath){
        while(true) {
            try {
                sleep(3000);
                TemperatureResource temperatureResource = new TemperatureResource(childPath);
                String temp = getRandomNumber();
                temperatureResource.setTemperature(temp);
                this.add(temperatureResource);
                Server.server.add(this);
                //System.out.println("Temperature set to: " + temp);
                changed();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
