package BetterFileIO.FileManagement;

import java.io.IOException;
import java.io.FileNotFoundException;

public class Directory {
  java.io.File directory;
  FilePath path;
  
  public Directory(FilePath path1) {
    path = path1;
    directory = new File(path1.getPathAsString());
  }
  
  public boolean create() throws IOException {
    if (!directory.exists()) {
      directory.mkdir();
      return true;
    }
    return false;
  }
  
  public File[] findAllChildren(int buffer) {
    File[] children = new File[buffer];
    int x = 0;
    for (java.io.File f : directory.listFiles()) {
      children[x] = new File(new FilePath(f.getAbsolutePath()));
      x++;
    }
    return children;
  }
  
  public boolean delete(int directoryBuffer) throws FileNotFoundException, IOException {
    if (directory.exists()) {
      File[] children = findAllChildren(directoryBuffer);
      int index = 0;
      while (children.getFilePath().getPathAsString() != null) {
        children[index].delete();
        index++;
      }
      directory.delete();
      return true;
    }
    return false;
  }
  
  public java.io.File getStandardLibraryFile() {
    return directory;
  }
  
  public FilePath getFilePath() {
    return path;
  }
}
