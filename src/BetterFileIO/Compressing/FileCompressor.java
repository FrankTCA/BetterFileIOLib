package BetterFileIO.Compressing;

import BetterFileIO.FileManagement.File;
import BetterFileIO.FileManagement.FilePath;

public class FileCompressor {
  
  // important variables
  File toFile;
  File fromFile;
  
  // class initializer
  public FileCompressor(File fromFile1, FilePath toFilePath) {
    fromFile = fromFile1;
    toFile = new File(toFilePath);
  }
  
  // compress file to file
  public void compressFile() throws FileNotFoundException, IOException {
    java.io.File toFile1 = new java.io.File(fromFile.getFilePath().getPathAsString());
    FileOutputStream fos = new FileOutputStream(fromFile.getFilePath().getPathAsString());
    ZipOutputStream zos = new ZipOutputSteam(fos);
    zos.putNextEntry(new ZipEntry(fromFile.getFilePath().getPathAsString()));
    byte[] bytes = Files.readAllBytes(Paths.get(fromFile.getFilePath().getPathAsString()));
    zos.write(bytes, 0, bytes.length);
    zos.closeEntry();
    zos.close();
  }
  
  // get file that will be/has been written to
  public void getToFile() {
    return toFile();
  }
  
  // get file that will be read from
  public void getFromFile() {
    return fromFile;
  }
}
