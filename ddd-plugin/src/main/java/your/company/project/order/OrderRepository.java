package your.company.project.order;

import org.jqassistant.contrib.plugin.ddd.annotation.DDD;

@DDD.Repository
public interface OrderRepository {

    Order findById(long id);

    Order save(Order order);

}
