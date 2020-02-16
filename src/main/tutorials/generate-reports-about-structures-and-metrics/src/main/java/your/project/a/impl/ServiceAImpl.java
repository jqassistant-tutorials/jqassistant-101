package your.project.a.impl;

import your.project.a.api.ServiceA;

public class ServiceAImpl implements ServiceA {

    public String hello(String value) {
        return value != null ? value : "Unknown";
    }
}
