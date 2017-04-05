package BetterFileIO.FileManagement;

import java.io.File;

public class FilePath {
    
  // important variables
  String path = null;
  
  // class initializer
  public FilePath(String path1) {
    String os = System.getProperty("os.name");
    if (os.equalsIgnoreCase("windows")) {
      char[] pathCh = path1.toCharArray();
      for (int i = pathCh.length; i > -1; i--) {
        if (pathCh[i] == '/') {
          pathCh[i] = '\\';
        }
      }
      path1 = new String(pathCh);
    }
    path = path1;
  }
  
  // get the file path as a string
  public String getPathAsString() {
    return path;
  }
  
  // converts file into BetterFileIO.FileManagement.File
  public File convertPathToStandardFile() {
    File file = new File(path);
    return file;
  }
  
  // Converts a unix based file path to a windows based file path because windows uses \ while unix-based operating systems use /.
  public String convertUnixOrUnixBasedOperatingSystemPathToWindows() {
    char[] pathCh = path.toCharArray();
    for (int i = pathCh.length; i > -1; i--) {
      if (pathCh[i] == '/') {
        pathCh[i] = '\\';
      }
    }
    return new String(pathCh);
  }
  
  // Vise-versa
  public String convertWindowsPathToUnixOrUnixBasedOperatingSystemPath() {
    char[] pathCh = path.toCharArray();
    for (int i = pathCh.length; i > -1; i--) {
      if (pathCh[i] == '\\') {
        pathCh[i] = '/';
      }
    }
    return new String(pathCh);
  }
  
  // rewrites the file path without change by operating system
  public void rewritePathWithoutUsingUniversalOperatingSystemConversion(String path1) {
    path = path1;
  }
  
  // rewrites the path with change by operating system.
  public void rewritePathWithUsingUniversalOperatingSystemConversion(String path1) {
    String os = System.getProperty("os.name");
    if (os.equalsIgnoreCase("windows")) {
      char[] pathCh = path1.toCharArray();
      for (int i = pathCh.length; i > -1; i--) {
        if (pathCh[i] == '/') {
          pathCh[i] = '\\';
        }
      }
      path1 = new String(pathCh);
    }
    path = path1;
  }
}
