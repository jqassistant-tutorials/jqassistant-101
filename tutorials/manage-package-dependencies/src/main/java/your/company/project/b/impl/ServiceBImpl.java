package your.company.project.b.impl;

import your.company.project.a.api.ServiceA;
import your.company.project.b.api.ServiceB;

public class ServiceBImpl implements ServiceB {

    private final ServiceA serviceA;

    public ServiceBImpl(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
