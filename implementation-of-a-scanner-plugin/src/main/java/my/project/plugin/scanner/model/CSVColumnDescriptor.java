package my.project.plugin.scanner.model;

import com.buschmais.xo.neo4j.api.annotation.Label;

// tag::class[]
/**
 * Represents a column within a row of a CSV file.
 */
@Label("Column")
public interface CSVColumnDescriptor extends CSVDescriptor {

    String getValue();

    void setValue(String value);

    int getIndex();

    void setIndex(int index);

}
// end::class[]