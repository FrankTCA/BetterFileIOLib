package BetterFileIO.FileManagement.readwrite;

import BetterFileIO.FileManagement.File;

public class SimpleFileWriter {
  
  // important variables
  File file = null;
  
  // class initializer
  public SimpleFileWriter(File file1) {
    file = file1;
  }
  
  // writes entire file from one string. Will ovverride any other text already included in file.
  public void writeFileFromString(String toWrite) {
    java.io.File theFile = new java.io.File(file.getFilePath().getPathAsString());
    BufferedWriter writer = new BufferedWriter(new FileWriter(theFile, false));
    writer.write(toWrite);
    writer.flush();
    writer.close();
  }
  
  public void writeNewLineToFile(String line) {
    java.io.File theFile = new java.io.File(file.getFilePath().getPathAsString());
    BufferedWriter writer = new BufferedWriter(new FileWriter(theFile));
    
  }
}
