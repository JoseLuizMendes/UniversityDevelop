package Algorithm;
import java.io.*;
import java.util.*;

public class ReadShow {
    
    public static void alert() {
        System.out.println(">>> Reading file...");
    }

    public static int[] readFile(String fileName) {
        List<Integer> tempNumbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line);
                tempNumbers.add(num);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File " + fileName + " not found!");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: The file contains invalid (non-integer) data.");
        }

        int[] numbers = new int[tempNumbers.size()];
        for (int i = 0; i < tempNumbers.size(); i++) {
            numbers[i] = tempNumbers.get(i);
        }
        return numbers;
    }

    public static void showNumbers(int[] numbers, String fileName) {
        if (numbers.length == 0) {
            System.out.println("The file " + fileName + " is empty or could not be read.");
        } else {
            System.out.println("\n--- File content: " + fileName + " ---\n");
            for (int num : numbers) {
                System.out.println(num);
            }
            System.out.println("--------------------------------------\n");
        }
    }
    
    public static void read(Scanner sc) {
        System.out.print("Enter the file name (without extension): ");
        String fileName = sc.next() + ".txt";
        
        int[] numbers = readFile(fileName);   
        showNumbers(numbers, fileName);                
    }
}
