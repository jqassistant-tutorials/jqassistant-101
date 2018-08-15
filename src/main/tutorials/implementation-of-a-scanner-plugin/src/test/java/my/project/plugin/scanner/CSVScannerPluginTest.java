package my.project.plugin.scanner;

import com.buschmais.jqassistant.core.scanner.api.DefaultScope;
import com.buschmais.jqassistant.core.store.api.model.Descriptor;
import com.buschmais.jqassistant.plugin.common.test.AbstractPluginIT;
import my.project.plugin.scanner.model.CSVColumnDescriptor;
import my.project.plugin.scanner.model.CSVFileDescriptor;
import my.project.plugin.scanner.model.CSVRowDescriptor;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

// tag::CSVScannerPluginTest[]
public class CSVScannerPluginTest extends AbstractPluginIT {

    @Test
    public void scanCSVFile() {
        store.beginTransaction();
        // Scan the test CSV file located as resource in the classpath
        File testFile = new File(getClassesDirectory(CSVScannerPluginTest.class), "/test.csv");

        // Scan the CSV file and assert that the returned descriptor is a CSVFileDescriptor
        assertThat(getScanner().scan(testFile, "/test.csv", DefaultScope.NONE), CoreMatchers.<Descriptor>instanceOf(CSVFileDescriptor.class));

        // Determine the CSVFileDescriptor by executing a Cypher query
        TestResult testResult = query("MATCH (csvFile:CSV:File) RETURN csvFile");
        List<CSVFileDescriptor> csvFiles = testResult.getColumn("csvFile");
        assertThat(csvFiles.size(), equalTo(1));

        CSVFileDescriptor csvFile = csvFiles.get(0);
        assertThat(csvFile.getFileName(), equalTo("/test.csv"));

        // Get rows and verify expected count
        List<CSVRowDescriptor> rows = csvFile.getRows();
        assertThat(rows.size(), equalTo(1));

        // Verify first (and only) row
        CSVRowDescriptor row0 = rows.get(0);
        assertThat(row0.getLineNumber(), equalTo(0));
        // Verify the columns of the first row
        List<CSVColumnDescriptor> row0Columns = row0.getColumns();
        assertThat(row0Columns.size(), equalTo(2));

        CSVColumnDescriptor headerColumn0 = row0Columns.get(0);
        assertThat(headerColumn0.getIndex(), equalTo(0));
        assertThat(headerColumn0.getValue(), equalTo("Indiana"));

        CSVColumnDescriptor headerColumn1 = row0Columns.get(1);
        assertThat(headerColumn1.getIndex(), equalTo(1));
        assertThat(headerColumn1.getValue(), equalTo("Jones"));

        store.commitTransaction();
    }
}
// end::CSVScannerPluginTest[]
