package Algorithm;
import java.io.*;
import java.util.*;

public class GenRecord {
    
    public static void alert() {
        System.out.println(">>> Generating and saving numbers...");
    }
    
    public static int[] generate(int qty) {
        int[] numbers = new int[qty];
        for (int i = 0; i < qty; i++) {
            numbers[i] = (int)(Math.random() * 100);
        }
        return numbers;
    }

    public static void saveToFile(String fileName, int[] numbers) {                
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int num : numbers) {
                writer.write(num + System.lineSeparator());
            }
            System.out.println("File " + fileName + " created successfully with " + numbers.length + " numbers");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void save(Scanner sc) {
        System.out.print("Enter the file name (without extension): ");
        String fileName = sc.next() + ".txt";
        
        System.out.print("Enter how many numbers you want to save: ");
        int qty = sc.nextInt();
        
        int[] numbers = generate(qty);  
        saveToFile(fileName, numbers);     
    }
}  
