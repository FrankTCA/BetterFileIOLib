package BetterFileIO.FileManagement.readwrite;

import BetterFileIO.FileManagement.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SimpleFileWriter {
  
  // important variables
  File file = null;
  
  // class initializer
  public SimpleFileWriter(File file1) {
    file = file1;
  }
  
  // writes entire file from one string. Will ovverride any other text already included in file.
  public void writeFileFromString(String toWrite) throws FileNotFoundException, IOException {
    java.io.File theFile = new java.io.File(file.getFilePath().getPathAsString());
    BufferedWriter writer = new BufferedWriter(new FileWriter(theFile, false));
    writer.write(toWrite);
    writer.newLine();
    writer.flush();
    writer.close();
  }
  
  // write a new line to the file
  public void writeNewLineToFile(String line) throws FileNotFoundException, IOException {
    java.io.File theFile = new java.io.File(file.getFilePath().getPathAsString());
    BufferedWriter writer = new BufferedWriter(new FileWriter(theFile, true));
    writer.write(line);
    writer.newLine();
    writer.flush();
    writer.close();
  }
  
  // get the Java SDK BufferedWriter class
  public BufferedWriter getBufferedWriter() {
    return new BufferedWriter(new FileWriter(new java.io.File(file.getFilePath().getPathAsString())));
  }
  
  // Get the BetterFileIO.FileManagement.File class within this class
  public File getFile() {
    return file;
  }
}
