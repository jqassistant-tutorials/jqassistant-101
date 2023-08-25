package your.company.project.order;

import lombok.AllArgsConstructor;
import org.jmolecules.ddd.annotation.AggregateRoot;

import java.util.List;

@AggregateRoot
@AllArgsConstructor
public class Order {

    private List<OrderItem> orderItems;

    public double getTotalPrice() {
        return orderItems.stream().mapToDouble(o -> o.getOrderItemPrice().getFinalPrice()).sum();
    }

}
