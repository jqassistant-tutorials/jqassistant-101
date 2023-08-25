package your.company.project.catalog;

import lombok.*;
import org.jmolecules.ddd.annotation.AggregateRoot;

@Getter
// tag::dddType[]
@AggregateRoot
public class Product {
// end::dddType[]

    private Long id;

    private String name;

    private ProductPrice price;
}
