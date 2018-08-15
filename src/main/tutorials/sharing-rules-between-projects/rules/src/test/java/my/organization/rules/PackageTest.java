package my.organization.rules;

import static com.buschmais.jqassistant.core.analysis.api.Result.Status.FAILURE;
import static com.buschmais.jqassistant.core.analysis.api.Result.Status.SUCCESS;
import static com.buschmais.jqassistant.plugin.java.test.matcher.TypeDescriptorMatcher.typeDescriptor;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.analysis.api.Result;
import com.buschmais.jqassistant.core.analysis.api.rule.Constraint;
import com.buschmais.jqassistant.core.analysis.api.rule.RuleException;
import com.buschmais.jqassistant.plugin.java.api.model.TypeDescriptor;
import com.buschmais.jqassistant.plugin.java.test.AbstractJavaPluginIT;

import org.junit.Test;

// tag::Test[]
public class PackageTest extends AbstractJavaPluginIT {

    /**
     * Verifies that the constraint "package:RootPackage" is successful if all types
     * are located within the given root package.
     */
    @Test
    public void validRootPackage() throws IOException, RuleException {
        scanClassPathDirectory(getClassesDirectory(PackageTest.class));
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("rootPackage", PackageTest.class.getPackage().getName());

        assertThat(validateConstraint("package:RootPackage", parameters).getStatus(), equalTo(SUCCESS));
    }

    /**
     * Verifies that the constraint "package:RootPackage" is fails if any type is
     * located outside the given root package.
     */
    @Test
    public void invalidRootPackage() throws IOException, RuleException {
        scanClassPathDirectory(getClassesDirectory(PackageTest.class));
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("rootPackage", "org.jqassistant");

        Result<Constraint> result = validateConstraint("package:RootPackage", parameters);

        store.beginTransaction();
        assertThat(result.getStatus(), equalTo(FAILURE));
        List<Map<String, Object>> rows = result.getRows();
        assertThat(rows.size(), equalTo(1));
        Map<String, Object> row = rows.get(0);
        TypeDescriptor typeOutsideRootPackage = (TypeDescriptor) row.get("TypeOutsideRootPackage");
        assertThat(typeOutsideRootPackage, typeDescriptor(PackageTest.class));
        store.commitTransaction();
    }
}
// end::Test[]
