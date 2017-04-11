package BetterFileIO.FileManagement.readwrite;

import BetterFileIO.FileManagement.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SimpleFileReader {
    
    // important variables
    File file = null;
    
    // class initializer
    public SimpleFileReader(File file1) {
        file = file1;
    }
    
    // reads entire file and returns the text inside of the file in the form of a string
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
    
    // reads entire file and returns the text inside as a String array, sperated by lines. (Requires buffer)
    public String[] convertFileToArrayOfLines(int buffer) throws FileNotFoundException, IOException {
        java.io.File theFile = new java.io.File(file.getFilePath().getPathAsString());
        BufferedReader reader = new BufferedReader(new FileReader(theFile));
        String line;
        String[] wholeFile = new String[buffer];
        int x = 0;
        while ((line = reader.readLine()) != null) {
            wholeFile[x] = line;
            x++;
        }
        return wholeFile;
    }
    
    // gets a certain line in a file by the number of the line. Returns as a String.
    public String getLineByNumber(int lineID) throws FileNotFoundException, IOException {
        java.io.File theFile = new java.io.File(file.getFilePath().getPathAsString());
        BufferedReader reader = new BufferedReader(new FileReader(theFile));
        String line;
        int x = 0;
        while ((line = reader.readLine()) != null) {
            if (x == lineID) {
                return line;
            }
            x++;
        }
        return null;
    }
    
    // returns the file that is being read.
    public File getFile() {
        return file;
    }
}
