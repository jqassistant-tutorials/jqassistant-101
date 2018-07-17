package your.project.c.impl;

import your.project.a.api.ServiceA;
import your.project.b.api.ServiceB;
import your.project.c.api.ServiceC;

public class ServiceCImpl implements ServiceC {

    private final ServiceA serviceA;

    private final ServiceB serviceB;

    public ServiceCImpl(ServiceA serviceA, ServiceB serviceB) {
        this.serviceA = serviceA;
        this.serviceB = serviceB;
    }
}
