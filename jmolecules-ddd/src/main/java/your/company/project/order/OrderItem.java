package your.company.project.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jmolecules.ddd.annotation.Entity;
import your.company.project.catalog.Product;

@Getter
@AllArgsConstructor
@Entity
public class OrderItem {

    private long productId;

    private OrderItemPrice orderItemPrice;

}
