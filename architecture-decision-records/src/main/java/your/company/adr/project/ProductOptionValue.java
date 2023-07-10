package your.company.adr.project;

import org.jqassistant.contrib.plugin.ddd.annotation.DDD;

@DDD.ValueObject
public class ProductOptionValue<T> {

    private T value;

}
