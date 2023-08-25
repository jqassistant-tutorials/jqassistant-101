package your.company.project.catalog;

import lombok.Getter;
import lombok.Value;
import org.jmolecules.ddd.annotation.ValueObject;

@Value
@ValueObject
public class ProductPrice {

    private double price;

}
