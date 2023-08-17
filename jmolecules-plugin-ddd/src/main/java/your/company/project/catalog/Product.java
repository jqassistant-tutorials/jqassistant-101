package your.company.project.catalog;

import lombok.*;
import org.jmolecules.ddd.annotation.AggregateRoot;

@Getter
@AggregateRoot
public class Product {

    private Long id;

    private String name;

    private ProductPrice price;
}
