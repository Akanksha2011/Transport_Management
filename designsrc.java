import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi;
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
        System.out.print(Ansi.ansi().fg(Ansi.Color.RED));
    }

    public static void SetTextColorWHITE() {
        System.out.print(Ansi.ansi().fg(Ansi.Color.WHITE));
    }

    public static void intro() {
        Scanner scanner = new Scanner(System.in);
        AnsiConsole.systemInstall(); // Initialize the Jansi console

        while (true) {
            System.out.print(Ansi.ansi().eraseScreen().bg(Ansi.Color.BLACK).fg(Ansi.Color.WHITE)); // Clear the screen and set colors

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
                    AnsiConsole.systemUninstall(); // Uninstall the Jansi console
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
