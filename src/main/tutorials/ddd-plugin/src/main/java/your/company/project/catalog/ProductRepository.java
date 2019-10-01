package your.company.project.catalog;

import org.jqassistant.contrib.plugin.ddd.annotation.DDD;

@DDD.Repository
public interface ProductRepository {

    Product findProductById(long id);

    Product save(Product product);

}
