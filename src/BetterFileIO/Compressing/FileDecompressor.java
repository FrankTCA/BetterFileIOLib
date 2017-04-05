package BetterFileIO.Compressing;

import BetterFileIO.FileManagement.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileDecompressor {
  
  // important variables
  List<String> fileList;
  File inputFile;
  File outputFile;
  
  // class initializer
  public FileDecompressor(File inputFile1, File outputFile1) {
    inputFile = inputFile1;
    outputFile = outputFile1;
  }
  
  // decompress file
  public void decompress() {
    byte[] buffer = new byte[1024];
    
    try {
      outputFile.create();
      
      ZipInputStream zis = new ZipInputStream(new FileInputStream(new File(inputFile.getFilePath().getPathAsString())));
      ZipEntry ze = zis.getNextEntry();
      String fileName = ze.getName();
      FileOutputStream fos = new FileOutputStream(outputFile);
      int len;
      while ((len = zis.read(buffer)) > 0) {
        fos.write(buffer, 0, len);
      }
        
      fos.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
  
  // get the input file
  public File getInputFile() {
    return inputFile;
  }
  
  // get the output file
  public File getOutputFile() {
    return outputFile;
  }
}
