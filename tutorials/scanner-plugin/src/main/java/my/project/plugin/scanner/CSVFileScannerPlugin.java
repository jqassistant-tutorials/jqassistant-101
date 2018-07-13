package my.project.plugin.scanner;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.core.scanner.api.ScannerContext;
import com.buschmais.jqassistant.core.scanner.api.ScannerPlugin.Requires;
import com.buschmais.jqassistant.core.scanner.api.Scope;
import com.buschmais.jqassistant.core.store.api.Store;
import com.buschmais.jqassistant.plugin.common.api.model.FileDescriptor;
import com.buschmais.jqassistant.plugin.common.api.scanner.AbstractScannerPlugin;
import com.buschmais.jqassistant.plugin.common.api.scanner.filesystem.FileResource;

import com.opencsv.CSVReader;
import my.project.plugin.scanner.model.CSVColumnDescriptor;
import my.project.plugin.scanner.model.CSVFileDescriptor;
import my.project.plugin.scanner.model.CSVRowDescriptor;

// tag::class[]
/**
 * A CSV file scanner plugin.
 */
@Requires(FileDescriptor.class) // The file descriptor is created by the file scanner plugin and enriched by
                                // this one
public class CSVFileScannerPlugin extends AbstractScannerPlugin<FileResource, CSVFileDescriptor> {

    @Override
    public boolean accepts(FileResource item, String path, Scope scope) {
        return path.toLowerCase().endsWith(".csv");
    }

    @Override
    public CSVFileDescriptor scan(FileResource item, String path, Scope scope, Scanner scanner) throws IOException {
        ScannerContext context = scanner.getContext();
        final Store store = context.getStore();
        // Open the input stream for reading the file.
        try (InputStream stream = item.createStream()) {
            // Retrieve the scanned file node from the scanner context.
            final FileDescriptor fileDescriptor = context.getCurrentDescriptor();
            // Add the CSV label.
            final CSVFileDescriptor csvFileDescriptor = store.addDescriptorType(fileDescriptor, CSVFileDescriptor.class);
            // Parse the stream using OpenCSV.
            CSVReader csvReader = new CSVReader(new InputStreamReader(stream));
            String[] columns;
            int row = 0;
            while ((columns = csvReader.readNext()) != null) {
                // Create the node for a row
                CSVRowDescriptor rowDescriptor = store.create(CSVRowDescriptor.class);
                csvFileDescriptor.getRows().add(rowDescriptor);
                rowDescriptor.setLineNumber(row);
                for (int i = 0; i < columns.length; i++) {
                    // Create the node for a column
                    CSVColumnDescriptor columnDescriptor = store.create(CSVColumnDescriptor.class);
                    rowDescriptor.getColumns().add(columnDescriptor);
                    columnDescriptor.setIndex(i);
                    columnDescriptor.setValue(columns[i]);
                }
                row++;
            }
            return csvFileDescriptor;
        }
    }
}
// end::class[]