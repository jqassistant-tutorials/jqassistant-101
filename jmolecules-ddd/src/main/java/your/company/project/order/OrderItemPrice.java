package your.company.project.order;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@Getter
@ValueObject
public class OrderItemPrice {

    private final double originalPrice;

    private final double discountPercentage;

    private final double finalPrice;

    public OrderItemPrice(double originalPrice, double discountPercentage) {
        this.originalPrice = originalPrice;
        this.discountPercentage = discountPercentage;
        this.finalPrice = originalPrice * (1 - discountPercentage);
    }

}
