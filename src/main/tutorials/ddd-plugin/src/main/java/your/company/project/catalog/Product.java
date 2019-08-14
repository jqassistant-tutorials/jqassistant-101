package your.company.project.catalog;

import lombok.Getter;
import org.jqassistant.contrib.plugin.ddd.annotation.DDD;

@Getter
@DDD.AggregateRoot
public class Product {

    private Long id;

    private String name;

    private ProductPrice price;

}
