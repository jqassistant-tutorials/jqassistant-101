package your.company.project.order;

import org.jqassistant.contrib.plugin.ddd.annotation.DDD;
import your.company.project.catalog.Product;

import java.util.List;
import java.util.stream.Collectors;

// tag::DDDType
@DDD.Service
public class OrderService {
// end::DDDType
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(List<Product> products, final double discountPercentage) {
        List<OrderItem> orderItems = products.stream()
                .map(p -> new OrderItem(p.getId(), new OrderItemPrice(p.getPrice().getPrice(), discountPercentage)))
                .collect(Collectors.toList());
        return orderRepository.save(new Order(orderItems));
    }

}
