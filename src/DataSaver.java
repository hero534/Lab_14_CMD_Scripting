import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        while (true) {
            System.out.println("Enter details (or type 'exit' to stop):");
            String firstName = SafeInput.getNonZeroLenString(in, "First Name");
            if (firstName.equalsIgnoreCase("exit")) break;
            String lastName = SafeInput.getNonZeroLenString(in, "Last Name");
            String idNumber = SafeInput.getRegExString(in, "ID Number (6 digits)", "\\d{6}");
            String email = SafeInput.getRegExString(in, "Email", "^[\\w.-]+@[\\w.-]+\\.\\w+$");
            int birthYear = SafeInput.getInt(in, "Year of Birth (4 digits): ");
            records.add(firstName + ", " + lastName + ", " + idNumber + ", " + email + ", " + birthYear);
        }
            System.out.print("\nEnter filename to save (.csv): ");
            String fileName = in.nextLine();
            saveRecords(records, "src/" + fileName);
            System.out.println("Data saved successfully!");
    } private static void saveRecords(ArrayList<String> records, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (String record : records) {
                writer.println(record);
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
