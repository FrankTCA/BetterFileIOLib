package BetterFileIO.Compressing;

import BetterFileIO.FileManagement.File;
import BetterFileIO.FileManagement.readwrite.SimpleFileReader;
import org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator;
import org.apache.commons.compress.archivers.zip.ScatterZipOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntryRequest;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.parallel.InputStreamSupplier;

public class FileCompressor {
    // importand variables
    File input;
    File output;
    ParallelScatterZipCreator scatterZipCreator = new ParallelScatterZipCreator();
    ScatterZipOutputStream dirs = ScatterZipOutputStream.fileBased(java.io.File.createTempFile("scatter-dirs", "tmp"));
    
    // class initializer
    public FileCompressor(File input1, File output1) throws IOException {
        input = input1;
        output = output1;
        
    }
    
    // resource method. Do not use
    public void addEntry(ZipArchiveEntry zae, InputStreamSupplier iss) throws IOException {
        if (zae.isDirectory() && !zae.isUnixSymlink()) {
            dirs.addArchiveEntry(ZipArchiveEntryRequest.createZipArchiveEntryRequest(zae, iss));
        } else {
            scatterZipCreator.addArchiveEntry(zae, iss);
        }
    }
    
    // also resource
    public void writeTo(ZipArchiveOutputStream zaos) throws IOException, ExecutionException, InterruptedException {
        dirs.writeTo(zaos);
        dirs.close();
        scatterZipCreator.writeTo(zaos);
    }
    
    // compresses file
    public void compress() throws IOException {
        ZipArchiveEntry entry = new ZipArchiveEntry(input.getFilePath().getPathAsString());
        entry.setSize(input.getStandardLibraryFile().length());
        ZipArchiveOutputStream zaos = new ZipArchiveOutputStream(output.getStandardLibraryFile());
        zaos.putArchiveEntry(entry);
        SimpleFileReader sfr = new SimpleFileReader(input);
        zaos.write(sfr.convertFileToString().getBytes());
        zaos.closeArchiveEntry();
    }
    
    // gets the output file
    public File getToFile() {
        return output;
    }
    
    // get the input file
    public File getFromFile() {
        return input;
    }
}
