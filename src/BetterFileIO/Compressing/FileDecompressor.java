package BetterFileIO.Compressing;

import BetterFileIO.FileManagement.Directory;
import BetterFileIO.FileManagement.File;
import BetterFileIO.FileManagement.FilePath;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;

import org.apache.commons.io.FileUtils;

public class FileDecompressor {
  // important varables
  File zipFile;
  Directory unzipped;
  
  // class initializer
  public FileDecompressor(File zipFile1, FilePath unzipPath) {
    zipFile = zipFile1;
    unzipped = new Directory(unzipPath);
  }
  
  // decompress compressed archive
  public void decompress() throws FileNotFoundException, ArchiveException, IOException {
    InputStream is = new FileInputStream(zipFile.getStandardLibraryFile());
    ArchiveInputStream ais = new ArchiveStreamFactory().createArchiveInputStream("zip", is);
    ZipEntry entry = (ZipArchiveEntry) ais.getNextEntry();
    
    while (entry != null) {
      if (entry.getName().endsWith("/")) {
        java.io.File dir = new java.io.File(unzipped.getFilePath().getPathAsString() + java.io.File.pathSeparator + entry.getName());
        if (!dir.exists()) {
          dir.mkdirs();
        }
        entry = (ZipArchiveEntry) ais.getNextEntry();
        continue;
      }
      java.io.File outFile = new java.io.File(unzipped.getFilePath().getPathAsString() + java.io.File.pathSeparator + entry.getName());
      
      if (outFile.isDirectory()) {
        entry = (ZipArchiveEntry) ais.getNextEntry();
        continue;
      }
      
      if (outFile.exists()) {
        entry = (ZipArchiveEntry) ais.getNextEntry();
      }
      
      FileUtils.copyInputStreamToFile(ais, outFile);
      entry = (ZipArchiveEntry) ais.getNextEntry();
    }
  }
  
  // get input file
  public Directory getInputFile() {
    return unzipped;
  }
  
  // get output file
  public File getOutputFile() {
    return zipFile;
  }
}
