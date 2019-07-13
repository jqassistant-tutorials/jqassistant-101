package your.company.project.order;

import lombok.AllArgsConstructor;
import org.jqassistant.contrib.plugin.ddd.annotation.DDD;

import java.util.List;

@DDD.Aggregate
@AllArgsConstructor
public class Order {

    private List<OrderItem> orderItems;

    public double getTotalPrice() {
        return orderItems.stream().mapToDouble(o -> o.getOrderItemPrice().getFinalPrice()).sum();
    }

}
