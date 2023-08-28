package my.organization.rules;

import com.buschmais.jqassistant.core.report.api.model.Result;
import com.buschmais.jqassistant.core.report.api.model.Row;
import com.buschmais.jqassistant.core.rule.api.model.Constraint;
import com.buschmais.jqassistant.core.rule.api.model.RuleException;
import com.buschmais.jqassistant.plugin.java.api.model.TypeDescriptor;
import com.buschmais.jqassistant.plugin.java.test.AbstractJavaPluginIT;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static com.buschmais.jqassistant.core.report.api.model.Result.Status.FAILURE;
import static com.buschmais.jqassistant.core.report.api.model.Result.Status.SUCCESS;
import static com.buschmais.jqassistant.plugin.java.test.matcher.TypeDescriptorMatcher.typeDescriptor;
import static org.assertj.core.api.Assertions.assertThat;

// tag::Test[]
public class PackageTest extends AbstractJavaPluginIT {

    /**
     * Verifies that the constraint "package:RootPackage" is successful if all types
     * are located within the given root package.
     */
    @Test
    public void validRootPackage() throws RuleException {
        scanClassPathDirectory(getClassesDirectory(PackageTest.class));
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("rootPackage", PackageTest.class.getPackage().getName());

        assertThat(validateConstraint("package:RootPackage", parameters).getStatus()).isEqualTo(SUCCESS);
    }

    /**
     * Verifies that the constraint "package:RootPackage" is fails if any type is
     * located outside the given root package.
     */
    @Test
    public void invalidRootPackage() throws RuleException {
        scanClassPathDirectory(getClassesDirectory(PackageTest.class));
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("rootPackage", "org.jqassistant");

        Result<Constraint> result = validateConstraint("package:RootPackage", parameters);

        store.beginTransaction();
        assertThat(result.getStatus()).isEqualTo(FAILURE);
        List<Row> rows = result.getRows();
        assertThat(rows.size()).isEqualTo(1);
        Row row = rows.get(0);
        TypeDescriptor typeOutsideRootPackage = (TypeDescriptor) row.getColumns().get("TypeOutsideRootPackage").getValue();
        MatcherAssert.assertThat(typeOutsideRootPackage, typeDescriptor(PackageTest.class));
        store.commitTransaction();
    }
}
// end::Test[]
