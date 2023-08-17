package your.company.project.order;

import org.jmolecules.ddd.annotation.Repository;
import org.jmolecules.ddd.annotation.Service;

@Repository
public interface OrderRepository {

    Order findById(long id);

    Order save(Order order);

}
