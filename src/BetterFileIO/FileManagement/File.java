package BetterFileIO.FileManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class File {
  FilePath path = null;
  java.io.File file = null;
  public File(FilePath path1) {
    path = path1;
    file = new java.io.File(path.getPathAsString());
  }
  
  public boolean create() {
    if (file.exists()) {
        try {
            file.createNewFile();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    return false;
  }
  
  public boolean delete() {
      if (file.exists()) {
          file.delete();
          return true;
      }
      return false;
  }
  
  public boolean rename(FilePath to) {
      java.io.File toFile = new java.io.File(to.getPathAsString());
      try {
          BufferedReader reader = new BufferedReader(new FileReader(file));
          String line = "";
          String fileText = "";
          try {
              while ((line = reader.readLine()) != null) {
                  fileText = fileText + "\n" + line;
              }
          } catch (IOException ex) {
              return false;
          }
          BufferedWriter writer = new BufferedWriter(new FileWriter(toFile));
          toFile.createNewFile();
          writer.write(fileText);
          writer.flush();
          writer.close();
          path = to;
          file = toFile;
          return true;
      } catch (FileNotFoundException ex) {
          return false;
      } catch (IOException ex) {
          return false;
      }
  }
  
  public java.io.File getStandardLibraryFile() {
      return file;
  }
  
  public FilePath getFilePath() {
      return path;
  }
}
