package hr.fer.iot.resource;

import org.eclipse.californium.core.CoapResource;

public class LargeFileResource extends CoapResource {
    public LargeFileResource(String name) {
        super(name);
    }
}
