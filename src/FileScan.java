import javax.swing.*;
import java.io.File;

public class FileScan {
    public static void main(String[] args) {
        String filename;
        if (args.length > 0) {
            filename = args[0];
        } else {
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                filename = chooser.getSelectedFile().getAbsolutePath();
            } else {
                System.out.println("No file selected.");
                return;
            }
        }
        System.out.println("Processing file: " + filename);
    }
}