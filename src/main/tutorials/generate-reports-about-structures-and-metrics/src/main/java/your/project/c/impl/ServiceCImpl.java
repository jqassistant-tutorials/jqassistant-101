package your.project.c.impl;

import your.project.a.api.ServiceA;
import your.project.b.api.ServiceB;

public class ServiceCImpl {

    private final ServiceA serviceA;

    private final ServiceB serviceB;

    public ServiceCImpl(ServiceA serviceA, ServiceB serviceB) {
        this.serviceA = serviceA;
        this.serviceB = serviceB;
    }

    public void run() {
        serviceA.hello("World");
        serviceB.helloWorld();
    }
}
