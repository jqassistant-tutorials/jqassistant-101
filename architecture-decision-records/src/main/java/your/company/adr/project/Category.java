package your.company.adr.project;

import org.jqassistant.contrib.plugin.ddd.annotation.DDD;

import java.util.List;

@DDD.AggregateRoot
public class Category {

    private List<ProductOption> productOptions;

}
