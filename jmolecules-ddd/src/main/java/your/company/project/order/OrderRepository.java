package your.company.project.order;

import org.jmolecules.ddd.annotation.Repository;
import org.jmolecules.ddd.annotation.Service;

// tag::dddType[]
@Repository
public interface OrderRepository {
    // end::dddType[]

    Order findById(long id);

    Order save(Order order);

}
