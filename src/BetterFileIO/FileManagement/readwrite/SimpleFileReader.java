package BetterFileIO.FileManagement.readwrite;

import BetterFileIO.FileManagement.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SimpleFileReader {
    
    File file = null;
    
    public SimpleFileReader(File file1) {
        file = file1;
    }
    
    public String convertFileToString() throws FileNotFoundException, IOException {
        java.io.File theFile = new java.io.File(file.getFilePath().getPathAsString());
        BufferedReader reader = new BufferedReader(new FileReader(theFile));
        String line;
        String wholeFile = "";
        while ((line = reader.readLine()) != null) {
            wholeFile = wholeFile + line;
        }
        return wholeFile;
    }
    
    
}
