package your.company.project.c.impl;

import your.company.project.a.api.ServiceA;
import your.company.project.b.api.ServiceB;
import your.company.project.c.api.ServiceC;

public class ServiceCImpl implements ServiceC {

    private final ServiceA serviceA;

    private final ServiceB serviceB;

    public ServiceCImpl(ServiceA serviceA, ServiceB serviceB) {
        this.serviceA = serviceA;
        this.serviceB = serviceB;
    }
}
