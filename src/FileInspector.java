import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser(new File("src"));
        int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                    int lineCount = 0;
                    int wordCount = 0;
                    int characterCount = 0;
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lineCount++;
                        System.out.println(line);
                        String[] words = line.split("\\s+");
                        wordCount += words.length;
                        characterCount += line.length();
                    }
                        System.out.println("\n--- File Summary ---");
                        System.out.println("File Name: " + selectedFile.getName());
                        System.out.println("Number of lines: " + lineCount);
                        System.out.println("Number of words: " + wordCount);
                        System.out.println("Number of characters: " + characterCount);

                } catch (IOException e) {
                    System.err.println("An error occurred while reading the file: " + e.getMessage());
                }
            } else {
                System.out.println("No file selected.");
            }
    }
}
