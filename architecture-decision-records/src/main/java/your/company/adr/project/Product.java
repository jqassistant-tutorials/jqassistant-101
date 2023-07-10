package your.company.adr.project;

import org.jqassistant.contrib.plugin.ddd.annotation.DDD;

import java.util.Map;

@DDD.AggregateRoot
public class Product {

    private Category category;

    private Map<ProductOption, ProductOptionValue<?>> options;

}
