package your.company.project.catalog;

import lombok.Getter;
import lombok.Value;
import org.jqassistant.contrib.plugin.ddd.annotation.DDD;

@Value
@DDD.ValueObject
public class ProductPrice {

    private double price;

}
