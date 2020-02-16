package your.project.b.impl;

import your.project.a.api.ServiceA;
import your.project.b.api.ServiceB;

public class ServiceBImpl implements ServiceB {

    private final ServiceA serviceA;

    public ServiceBImpl(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public String helloWorld() {
        return serviceA.hello("World");
    }
}
