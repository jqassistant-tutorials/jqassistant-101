package your.company.project.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jqassistant.contrib.plugin.ddd.annotation.DDD;
import your.company.project.catalog.Product;

@Getter
@AllArgsConstructor
@DDD.Entity
public class OrderItem {

    private long productId;

    private OrderItemPrice orderItemPrice;

}
