package Algorithm;

import java.util.*;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("\n\t    === MENU ===");
        System.out.println("1 - Generate and Save Data to File");
        System.out.println("2 - Read and Display Data from File");
        System.out.println("3 - Sort");
        System.out.println("0 - Exit");
        System.out.print("\nChoose an option: ");
    }

    public static void executeOption(int op) {
        switch (op) {
            case 1:
                GenRecord.alert();
                GenRecord.save(sc);
                break;
            case 2:
                ReadShow.alert();
                ReadShow.read(sc);
                break;
            case 3:
                System.out.print("Enter the file name (without extension): ");
                String fileName = sc.next() + ".txt";

                int[] numbers = ReadShow.readFile(fileName);

                if (numbers.length == 0) {
                    System.out.println("No numbers to sort.");
                } else {
                    System.out.println("\nOriginal numbers:");
                    System.out.println(Arrays.toString(numbers));

                    SearchOrd.menu(sc, numbers);

                    System.out.println("\nSorted numbers:");
                    System.out.println(Arrays.toString(numbers));
                }
                break;

            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
    }

    public static void main(String[] args) {
        int op;
        do {
            showMenu();
            op = sc.nextInt();
            executeOption(op);
        } while (op != 0);
        
        say();
    }

	private static void say() {
		// TODO Auto-generated method stub
		
	}
}
