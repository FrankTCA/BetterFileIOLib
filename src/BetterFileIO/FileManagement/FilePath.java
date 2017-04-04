package BetterFileIO.FileManagement;

import java.io.File;

public class FilePath {
  String path = null;
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
  
  public String getPath() {
    return path;
  }
  
  public File convertPathToStandardFile() {
    File file = new File(path);
    return file;
  }
  
  public String convertUnixOrUnixBasedOperatingSystemPathToWindows() {
    char[] pathCh = path.toCharArray();
    for (int i = pathCh.length; i > -1; i--) {
      if (pathCh[i] == "/") {
        pathCh[i] = '\\';
      }
    }
    return new String(pathCh);
  }
  
  public String convertWindowsPathToUnixOrUnixBasedOperatingSystemPath() {
    char[] pathCh = path.toCharArray();
    for (int i = pathCh.length; i > -1; i--) {
      if (pathCh[i] == '\\') {
        pathCh[i] = '/';
      }
    }
    return new String(pathCh);
  }
  
  public void rewritePathWithoutUsingUniversalOperatingSystemConversion(String path1) {
    path = path1;
  }
  
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
