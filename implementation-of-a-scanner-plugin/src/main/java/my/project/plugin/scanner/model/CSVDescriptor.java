package my.project.plugin.scanner.model;

import com.buschmais.jqassistant.core.store.api.model.Descriptor;
import com.buschmais.xo.neo4j.api.annotation.Label;
// tag::class[]
/**
 * Defines the label which is shared by all nodes representing CSV structures.
 */
@Label("CSV")
public interface CSVDescriptor extends Descriptor {
}
// end::class[]