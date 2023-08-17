package your.company.project.catalog;

import org.jmolecules.ddd.annotation.Repository;

@Repository
public interface ProductRepository {

    Product findProductById(long id);

    Product save(Product product);

}
