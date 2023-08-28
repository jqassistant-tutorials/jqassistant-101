package your.company.adr.project;

import java.util.Map;
import org.jmolecules.ddd.annotation.*;

@AggregateRoot
public class Product {

    private Category category;

    private Map<ProductOption, ProductOptionValue<?>> options;

}
