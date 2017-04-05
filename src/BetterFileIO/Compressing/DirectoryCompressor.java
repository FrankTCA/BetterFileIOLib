package BetterFileIO.Compressing;

import BetterFileIO.FileManagement.Directory;
import BetterFileIO.FileManagement.File;
import java.util.List;

public class DirectoryCompressor {
  
  // important variables
  Directory inputFile;
  File outputFile;
  
  // class initializer
  public DirectoryCompressor(Directory inputFile1, FilePath outputFilePath) {
    inputFile = inputFile1;
    outputFile = new File(outputFilePath);
  }
  
  // compresser
  public void compress() {
    byte[] buffer = new byte[1024];
    String source = inputFile.getFilePath().getPathAsString();
    FileOutputStream fos = null;
    ZipOutputStream zos = null;
    
    FileInputStream in = null;
    
    for (String file : )
  }
}
