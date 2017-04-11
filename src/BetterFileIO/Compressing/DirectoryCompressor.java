package BetterFileIO.Compressing;

import BetterFileIO.FileManagement.File;

public class DirectoryCompressor {
  // important variables
  File input;
  File output;
  
  // class initializer
  public DirectoryCompressor(File input1, File output1) {
    input = input1;
    output = output1;
  }
  
  // compress zip file
  public void compress() {
    ZipOutputStream zipFile = new ZipOutputStream(new FileOutputStream(input.getStandardLibraryFile()));
    compressDirectoryToZipFile(output.getFilePath().getPathAsString(), input.getFilePath().getPathAsString(), zipFile);
    IOUtils.closeQuietly(zipFile);
  }
  
  // private method. Do not use
  private static void compressDirectoryToZipFile(String rootDir, String sourceDir, ZipOutputStream out) {
      for (java.io.File file : new java.io.File(sourceDir).listFiles()) {
      if (file.isDirectory()) {
        compressDirectoryToZipFile(rootDir, sourceDir + java.io.File.seperator + file.getName(), out);
      } else {
        ZipEntry entry = new ZipEntry(sourceDir.replace(rootDir, "") + file.getName());
        out.putNextEntry(entry);
        
        FileInputStream in = new FileInputStream(sourceDir + file.getName());
        IOUtils.copy(in, out);
        IOUtils.closeQuietly(in);
      }
    }
  }
  
  // returns the input
  public File getInput() {
    return input;
  }
  
  // returns the output zip file
  public File getOutput() {
    return output;
  }
}
