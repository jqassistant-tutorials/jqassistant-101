package your.company.project.order;

import lombok.Getter;
import org.jqassistant.contrib.plugin.ddd.annotation.DDD;

@Getter
@DDD.ValueObject
public class OrderItemPrice {

    private double originalPrice;

    private double discounPercentage;

    private double finalPrice;

    public OrderItemPrice(double originalPrice, double discounPercentage) {
        this.originalPrice = originalPrice;
        this.discounPercentage = discounPercentage;
        this.finalPrice = originalPrice * (1 - discounPercentage);
    }

}
