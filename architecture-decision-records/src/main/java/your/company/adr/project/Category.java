package your.company.adr.project;


import java.util.List;
import org.jmolecules.ddd.annotation.*;

@AggregateRoot
public class Category {

    private List<ProductOption> productOptions;

}
