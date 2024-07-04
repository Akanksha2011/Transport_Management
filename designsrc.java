import java.util.Random;
import java.util.Scanner;

public class TransportationSystem {

    public static void fine(int LateDays) {
        System.out.println("You have to pay fine of Rs." + LateDays * 200 + "/- for " + LateDays + " days of late return.");
    }

    public static void ShowPercentCompleteFast() {
        Random rand = new Random();
        int incr_i; // increment i --> random integer between 15 & 25
        for (int i = 0; i <= 100; i += incr_i) {
            incr_i = 12 + rand.nextInt(20);
            System.out.print(i + "%\r");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("100%");
    }

    public static void ShowPercentCompleteSlow() {
        Random rand = new Random();
        int incr_i; // increment i --> random integer between 15 & 25
        for (int i = 0; i <= 100; i += incr_i) {
            incr_i = 7 + rand.nextInt(12);
            System.out.print(i + "%\r");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("100%");
    }

    public static void SetTextColorRED() {
        // In Java, changing console text color requires additional libraries
        // such as Jansi. Here, just a placeholder method.
        System.out.print("\033[0;31m"); // Set color to red
    }

    public static void SetTextColorWHITE() {
        // In Java, changing console text color requires additional libraries
        // such as Jansi. Here, just a placeholder method.
        System.out.print("\033[0;37m"); // Set color to white
    }

    public static void intro() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\033[2J\033[H"); // Clear the screen
            System.out.println("\033[0;30;47m"); // Set background to black and text to white

            String a = "\t\t\t████████████████ TRANSPORTATION SYSTEM ████████████████";
            for (char ch : a.toCharArray()) {
                System.out.print(ch);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("\n\n");
            System.out.println("                    \t\t1.Customer \n                    \t\t2.Admin \n                    \t\t99.Exit \n");
            System.out.println("Select Your Option :");

            int ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Customer option selected.");
                    break;
                case 2:
                    System.out.println("Admin option selected.");
                    break;
                case 99:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option selected.");
            }
        }
    }

    public static void main(String[] args) {
        intro();
    }
}
