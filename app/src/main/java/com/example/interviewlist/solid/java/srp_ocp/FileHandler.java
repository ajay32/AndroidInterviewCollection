package com.example.interviewlist.solid.java.srp_ocp;

// ISP, DIP (File Printer), LSP does not apply
// SRP - could split in FileReader, FileWriter, FilePrinter
// no encapsulation violation
public class FileHandler {
    private String filePath; // no encapsulation violation

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    public String readFile() {
        // Code to read the file
        return "File content";
    }

    public void writeFile(String content) {
        // Code to write to the file
    }

    public void printFile() {
        // Code to print the file content
    }

    // ... other file operations ...
}


// you may find the improved version of the code

// Handles reading files
 class FileReader {
    private String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    public String readFile() {
        // Code to read the file
        return "File content";
    }
}

// Handles writing to files
 class FileWriter {
    private String filePath;

    public FileWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeFile(String content) {
        // Code to write to the file
    }
}

// Handles printing file content
 class FilePrinter {
    private FileReader fileReader;

    public FilePrinter(FileReader fileReader) { // DIP follows
        this.fileReader = fileReader;
    }

    public void printFile() {
        String content = fileReader.readFile();
        // Code to print the file content
    }
}
