# Better File IO Lib

This is a useful library for working with files. It removes many of the difficult things that you have to do a lot for files and makes them simpler with methods.

# Changelog

Alpha 1.0.0:
 - Added File Class
 - Added Ability to simply read and write files
 - Added compressing methods
 - Added a way to decompress files
 - Things will be a lot simpler now.

# Documentation

Creating a new instance of the FilePath class:
  The file path class will make file paths universal. To write a file path in the code:
  
  FilePath path = new FilePath("/Path/To/File/Or/Directory");
  
  Always use the unix version of the file path with the /. If the operating system is Windows, it will replace the forward-slashes (/) with backslashes (\).
  
  Getting the path as a String:
  
  path.getPathAsString();
  
Creating a new instance of the File class:

  The File class is similar to the java.io.File class, but a lot easier to work with. How to make a File:
  
  File file = new File(FilePath);
  
Reading a file:

  Reading a file is a fairly simple operation.
  
  SimpleFileReader reader = new SimpleFileReader(file);
  String fileText = reader.convertFileToString();
  
  That's pretty much it.
Writing to a file:

  This will create a new line in the file with the text in it:
  
  SimpleFileWriter writer = new SimpleFileWriter();
  writer.writeNewLineToFile("Text to write as a new line.");
  
  This will replace all of the existing text in the file:
  
  SimpleFileWriter writer = new SimpleFileWriter(file);
  writer.writeFileFromString("Text to write to file");
  
Compressing a file:

  FileCompressor compressor = new FileCompressor(input, output);
  compressor.compress();
  
Compressing a directory:

  DirectoryCompressor compressor = new DirectoryCompressor(inputDirectory, outputFile);
  compressor.compress();
  
Decompressing a file or directory:
  
  FileDecompressor decompressor = new FileDecompressor(fileToUnzip, filePathToUnzipTo);
  decompressor.decompress();

# Liscense

There is a simple MIT liscense to the BetterFileIOLib. Please see LISCENSE for more information.
