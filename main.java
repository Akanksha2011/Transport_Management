import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

//=======================border===========================//

// Note: Java doesn't have built-in console cursor positioning like C++.
// You can use third-party libraries or a different approach for console applications.

//=======================time difference===========================//

LocalDate now = LocalDate.now();

int[] monthDays = { 31, 59, 90, 120, 151, 181, 212, 243,
                    273, 304, 334, 365 };

int countLeapYearDays(int[] d) {
    int years = d[2];
    if (d[1] <= 2)
        years--;
    return ((years / 4) - (years / 100) + (years / 400));
}

int countNoOfDays(int[] date1, int[] date2) {
    long dayCount1 = (date1[2] * 365);
    dayCount1 += monthDays[date1[1] - 1];
    dayCount1 += date1[0];
    dayCount1 += countLeapYearDays(date1);
    long dayCount2 = (date2[2] * 365);
    dayCount2 += monthDays[date2[1] - 1];
    dayCount2 += date2[0];
    dayCount2 += countLeapYearDays(date2);
    return Math.abs((int)(dayCount1 - dayCount2 - 693991));
}

//===============classes===================================//

class Node_Vaahan {
    String NameofVaahan;
    String NumberPlate;
    String Ventilation;
    int Count;
    int charges;
    Node_Vaahan next;

    // Parameterised Constructor
    Node_Vaahan(String NameofVaahan, String NumberPlate, String Ventilation, int Count, int charges) {
        this.NameofVaahan = NameofVaahan;
        this.NumberPlate = NumberPlate;
        this.Ventilation = Ventilation;
        this.Count = Count;
        this.charges = charges;
        this.next = null;
    }
}

class Vaahan {
    protected Node_Vaahan head_car;
    protected Node_Vaahan head_bus;
    protected Node_Vaahan head_bike;

    Vaahan() {
        head_car = null;
        head_bus = null;
        head_bike = null;
    }

    void insertNodecar(String NameofVaahan, String NumberPlate, String Ventilation, int Count, int charges) {
        Node_Vaahan newNode = new Node_Vaahan(NameofVaahan, NumberPlate, Ventilation, Count, charges);
        newNode.next = head_car;
        head_car = newNode;
    }

    void insertNodebus(String NameofVaahan, String NumberPlate, String Ventilation, int Count, int charges) {
        Node_Vaahan newNode = new Node_Vaahan(NameofVaahan, NumberPlate, Ventilation, Count, charges);
        newNode.next = head_bus;
        head_bus = newNode;
    }

    void insertNodebike(String NameofVaahan, String NumberPlate, String Ventilation, int Count, int charges) {
        Node_Vaahan newNode = new Node_Vaahan(NameofVaahan, NumberPlate, Ventilation, Count, charges);
        newNode.next = head_bike;
        head_bike = newNode;
    }
    void createcarList();
    void createbusList();
    void createbikeList();

    void display_all_Vaahan();
    void display_all_cars();
    void display_all_bus();
    void display_all_bikes();
    void display_all_available();
    void display_available_cars();
    void display_available_bus();
    void display_available_bikes();
    void addVaahan();
    void RepairVaahan();
}
class Node_User {
    String NameofUser;
    String Password;
    int balance;
    String LicenseNumber;
    String PhoneNumber;
    Node_User next;

    // Parameterised Constructor
    Node_User(String NameofUser, String Password, int balance, String LicenseNumber, String PhoneNumber) {
        this.NameofUser = NameofUser;
        this.Password = Password;
        this.balance = balance;
        this.LicenseNumber = LicenseNumber;
        this.PhoneNumber = PhoneNumber;
        this.next = null;
    }
}

class User extends Vaahan {
    private Node_User head_user;

    public User() {
        head_user = null;
    }

    void insertNodeUser(String NameofUser, String Password, int balance, String LicenseNumber, String PhoneNumber) {
        Node_User newNode = new Node_User(NameofUser, Password, balance, LicenseNumber, PhoneNumber);
        newNode.next = head_user;
        head_user = newNode;
    }

    void createUserList();
    void Sign_up();

    void display_all_users();

    void display_my_details(String user);

    void Login_admin();
    void AfterLoginAdmin(String admin);
    void PreLogin_Customer();
    void Login_customer();
    void AfterLoginCustomer(String customer);
    void add_money(String user);
    void rent(String user);
    void rentCar(String user);
    void rentBus(String user);
    void rentBike(String user);
    @Override
    protected void finalize() {
        try (BufferedWriter fout = new BufferedWriter(new FileWriter("cars.txt"))) {
            Node_Vaahan ptr1 = head_car;
            while (ptr1 != null) {
                fout.write(ptr1.NameofVaahan);
                fout.newLine();
                fout.write(ptr1.NumberPlate);
                fout.newLine();
                fout.write(ptr1.Ventilation);
                fout.newLine();
                fout.write(Integer.toString(ptr1.Count));
                fout.newLine();
                fout.write(Integer.toString(ptr1.charges));
                fout.newLine();
                ptr1 = ptr1.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter fout = new BufferedWriter(new FileWriter("bus.txt"))) {
            Node_Vaahan ptr2 = head_bus;
            while (ptr2 != null) {
                fout.write(ptr2.NameofVaahan);
                fout.newLine();
                fout.write(ptr2.NumberPlate);
                fout.newLine();
                fout.write(ptr2.Ventilation);
                fout.newLine();
                fout.write(Integer.toString(ptr2.Count));
                fout.newLine();
                fout.write(Integer.toString(ptr2.charges));
                fout.newLine();
                ptr2 = ptr2.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter fout = new BufferedWriter(new FileWriter("bikes.txt"))) {
            Node_Vaahan ptr3 = head_bike;
            while (ptr3 != null) {
                fout.write(ptr3.NameofVaahan);
                fout.newLine();
                fout.write(ptr3.NumberPlate);
                fout.newLine();
                fout.write(ptr3.Ventilation);
                fout.newLine();
                fout.write(Integer.toString(ptr3.Count));
                fout.newLine();
                fout.write(Integer.toString(ptr3.charges));
                fout.newLine();
                ptr3 = ptr3.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter fout = new BufferedWriter(new FileWriter("Users.txt"))) {
            Node_User ptr4 = head_user;
            while (ptr4 != null) {
                fout.write(ptr4.NameofUser);
                fout.newLine();
                fout.write(ptr4.Password);
                fout.newLine();
                fout.write(Integer.toString(ptr4.balance));
                fout.newLine();
                fout.write(ptr4.LicenseNumber);
                fout.newLine();
                fout.write(ptr4.PhoneNumber);
                fout.newLine();
                ptr4 = ptr4.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class NodeVaahan {
    String NameofVaahan;
    String NumberPlate;
    String Ventilation;
    int Count;
    int charges;
    NodeVaahan next;

    NodeVaahan(String NameofVaahan, String NumberPlate, String Ventilation, int Count, int charges) {
        this.NameofVaahan = NameofVaahan;
        this.NumberPlate = NumberPlate;
        this.Ventilation = Ventilation;
        this.Count = Count;
        this.charges = charges;
        this.next = null;
    }
}

class Vaahan {
    NodeVaahan head_car;
    NodeVaahan head_bus;
    NodeVaahan head_bike;

    Vaahan() {
        head_car = null;
        head_bus = null;
        head_bike = null;
    }

    // Methods to insert and manage vehicles can be added here
}

class NodeUser {
    String NameofUser;
    String Password;
    int balance;
    String LicenseNumber;
    String PhoneNumber;
    NodeUser next;

    NodeUser(String NameofUser, String Password, int balance, String LicenseNumber, String PhoneNumber) {
        this.NameofUser = NameofUser;
        this.Password = Password;
        this.balance = balance;
        this.LicenseNumber = LicenseNumber;
        this.PhoneNumber = PhoneNumber;
        this.next = null;
    }
}

class User extends Vaahan {
    NodeUser head_user;

    User() {
        head_user = null;
    }

    void insertNodeUser(String NameofUser, String Password, int balance, String LicenseNumber, String PhoneNumber) {
        NodeUser newNode = new NodeUser(NameofUser, Password, balance, LicenseNumber, PhoneNumber);

        if (head_user == null) {
            head_user = newNode;
            return;
        }

        NodeUser temp = head_user;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void createUserList() {
        try (BufferedReader fin = new BufferedReader(new FileReader("Users.txt"))) {
            String NameofUser1;
            String Password1;
            int balance1;
            String LicenseNumber1;
            String PhoneNumber1;

            while ((NameofUser1 = fin.readLine()) != null) {
                Password1 = fin.readLine();
                balance1 = Integer.parseInt(fin.readLine().trim());
                LicenseNumber1 = fin.readLine();
                PhoneNumber1 = fin.readLine();
                insertNodeUser(NameofUser1, Password1, balance1, LicenseNumber1, PhoneNumber1);
            }
        } catch (IOException e) {
            System.out.println("Error reading Users.txt file!");
        }
    }

    void displayAllUsers() {
        NodeUser temp = head_user;
        System.out.println("\n\n\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb USERS LIST \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\n");

        if (head_user == null) {
            System.out.println("\n\t\t\t\t\t\t\tList empty");
            return;
        }

        while (temp != null) {
            System.out.println("\n\t\t\t\t\t\t\tName - " + temp.NameofUser);
            System.out.println("\n\t\t\t\t\t\t\tPassword - " + temp.Password);
            System.out.println("\n\t\t\t\t\t\t\tBalance - Rs." + temp.balance);
            System.out.println("\n\t\t\t\t\t\t\tLicense number - " + temp.LicenseNumber);
            System.out.println("\n\t\t\t\t\t\t\tPhone number - " + temp.PhoneNumber);
            System.out.println("\n\t\t\t\t\t\t\t*************************************");
            temp = temp.next;
        }
        System.out.println();
    }

    void displayMyDetails(String username) {
        NodeUser temp = head_user;

        if (head_user == null) {
            System.out.println("\n\n\t\t\t\t\t\t\tList empty");
            return;
        }

        while (temp != null) {
            if (temp.NameofUser.equals(username)) {
                System.out.println("\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb MY DETAILS \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\n");
                System.out.println("\n\t\t\t\t\t\t\tName - " + temp.NameofUser);
                System.out.println("\t\t\t\t\t\t\tPassword - " + temp.Password);
                System.out.println("\t\t\t\t\t\t\tBalance - Rs." + temp.balance);
                System.out.println("\t\t\t\t\t\t\tLicense number - " + temp.LicenseNumber);
                System.out.println("\t\t\t\t\t\t\tPhone number - " + temp.PhoneNumber);
                System.out.println("\t\t\t\t\t\t\t*************************************");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    void rent(String username) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n\n\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb RENT A VAAHAN \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\n");
            System.out.println("\n\t\t\t\t\t\t\tWhich Vaahan would you like to rent?");
            System.out.println("\t\t\t\t\t\t\t1. Car\n\t\t\t\t\t\t\t2. Bus\n\t\t\t\t\t\t\t3. Bike\n\t\t\t\t\t\t\t99. Back\n\n\t\t\t\t\t\t\tYour choice: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    rentCar(username);
                    break;
                case 2:
                    rentBus(username);
                    break;
                case 3:
                    rentBike(username);
                    break;
                case 99:
                    break;
                default:
                    System.out.println("\n\n\t\t\t\t\t\t\tPlease enter valid input!");
                    break;
            }
        } while (choice != 99);
    }

    void rentCar(String username) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb RENT CAR \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\n");
        System.out.println("\n\t\t\t\t\t\t\tEnter the no of days for which you would like to rent the car: ");
        int rent_days = sc.nextInt();
        System.out.println("\n\t\t\t\t\t\t\tEnter car name which you would like to rent: ");
        String chkcar = sc.next();

        NodeVaahan ptr = head_car;
        NodeUser ptr2 = head_user;
        while (ptr2 != null) {
            if (ptr2.NameofUser.equals(username)) {
                break;
            }
            ptr2 = ptr2.next;
        }

        boolean flag = false;

        while (ptr != null) {
            if (ptr.NameofVaahan.equals(chkcar)) {
                flag = true;
                if (ptr.Count > 0) {
                    if ((rent_days * ptr.charges) < ptr2.balance) {
                        System.out.println("\t\t\t\t\t\t\tDear customer, your Vaahan is booked.");
                        System.out.println("\n\t\t\t\t\t\t\tDetails - \n\t\t\t\t\t\t\tName - " + ptr.NameofVaahan);
                        System.out.println("\t\t\t\t\t\t\tNumber - " + ptr.NumberPlate + "\n\t\t\t\t\t\t\tVentilation type - " + ptr.Ventilation);
                        ptr2.balance -= (rent_days * ptr.charges);
                        System.out.println("\t\t\t\t\t\t\tRs." + (rent_days * ptr.charges) + " were deducted from your account.");
                        System.out.println("\t\t\t\t\t\t\tCurrent balance - Rs." + ptr2.balance);
                        ptr.Count--;

                        try (PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("CarsOnRent.txt", true)))) {
                            fout.println(ptr2.NameofUser);
                            fout.println(ptr.NameofVaahan);
                            fout.println(ptr.NumberPlate);
                            fout.println(java.time.LocalDate.now().getDayOfMonth());
                            fout.println(java.time.LocalDate.now().getMonthValue());
                            fout.println(java.time.LocalDate.now().getYear());
                            fout.println(rent_days);
                        } catch (IOException e) {
                            System.out.println("Error writing to CarsOnRent.txt file!");
                        }
                    } else {
                        System.out.println("\n\t\t\t\t\t\t\tInsufficient funds!\n\t\t\t\t\t\t\tAdd money to your account and try again...");
                    }
                } else {
                    System.out.println("\n\t\t\t\t\t\t\t" + ptr.NameofVaahan + " is currently unavailable.");
                }
            }
            ptr = ptr.next;
        }
        if (!flag) {
            System.out.println("\n\t\t\t\t\t\tnot found\n");
        }
        /*
         void rent(String username) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n\nWhich Vaahan would you like to rent?");
            System.out.println("1. Car\n2. Bus\n3. Bike\n99. Back\nYour choice: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    rentCar(username);
                    break;
                case 2:
                    rentBus(username);
                    break;
                case 3:
                    rentBike(username);
                    break;
                case 99:
                    break;
                default:
                    System.out.println("\n\nPlease enter valid input!");
                    break;
            }
        } while (choice != 99);
    }

    void rentCar(String username) {
        Scanner sc = new Scanner(System.in);
        System.out.println("For how many days would you like to rent?");
        int rent_days = sc.nextInt();
        System.out.println("\nWhich car would you like to rent?");
        String chkcar = sc.next();

        NodeVaahan ptr = head_car;
        NodeUser ptr2 = head_user;
        while (ptr2 != null) {
            if (ptr2.NameofUser.equals(username)) {
                break;
            }
            ptr2 = ptr2.next;
        }

        boolean flag = false;

        while (ptr != null) {
            if (ptr.NameofVaahan.equals(chkcar)) {
                flag = true;
                if (ptr.Count > 0) {
                    if ((rent_days * ptr.charges) < ptr2.balance) {
                        System.out.println("Dear customer, your Vaahan is booked.");
                        System.out.println("Details - \nName - " + ptr.NameofVaahan);
                        System.out.println("Number - " + ptr.NumberPlate + "\n" + ptr.Ventilation);
                        ptr2.balance -= (rent_days * ptr.charges);
                        System.out.println("Rs." + (rent_days * ptr.charges) + " were deducted from your account.");
                        System.out.println("Current balance - Rs." + ptr2.balance);
                        ptr.Count--;

                        try (PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("CarsOnRent.txt", true)))) {
                            fout.println(ptr2.NameofUser);
                            fout.println(ptr.NameofVaahan);
                            fout.println(ptr.NumberPlate);
                            Calendar calendar = Calendar.getInstance();
                            fout.println(calendar.get(Calendar.DAY_OF_MONTH));
                            fout.println(calendar.get(Calendar.MONTH) + 1);
                            fout.println(calendar.get(Calendar.YEAR));
                            fout.println(rent_days);
                        } catch (IOException e) {
                            System.out.println("Error writing to CarsOnRent.txt file!");
                        }
                    } else {
                        System.out.println("Insufficient funds!\nAdd money to your account and try again...");
                    }
                } else {
                    System.out.println(ptr.NameofVaahan + " is currently unavailable.");
                }
            }
            ptr = ptr.next;
        }
        if (!flag) {
            System.out.println("Car not found!");
        }
    }

    void rentBus(String username) {
        Scanner sc = new Scanner(System.in);
        System.out.println("For how many days would you like to rent?");
        int rent_days = sc.nextInt();
        System.out.println("\nWhich bus would you like to rent?");
        String chkbus = sc.next();

        NodeVaahan ptr = head_bus;
        NodeUser ptr2 = head_user;
        while (ptr2 != null) {
            if (ptr2.NameofUser.equals(username)) {
                break;
            }
            ptr2 = ptr2.next;
        }

        boolean flag = false;

        while (ptr != null) {
            if (ptr.NameofVaahan.equals(chkbus)) {
                flag = true;
                if (ptr.Count > 0) {
                    if ((rent_days * ptr.charges) < ptr2.balance) {
                        System.out.println("Dear customer, your Vaahan is booked.");
                        System.out.println("Details - \nName - " + ptr.NameofVaahan);
                        System.out.println("Number - " + ptr.NumberPlate + "\n" + ptr.Ventilation);
                        ptr2.balance -= (rent_days * ptr.charges);
                        System.out.println("Rs." + (rent_days * ptr.charges) + " were deducted from your account.");
                        System.out.println("Current balance - Rs." + ptr2.balance);
                        ptr.Count--;

                        try (PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("BusOnRent.txt", true)))) {
                            fout.println(ptr2.NameofUser);
                            fout.println(ptr.NameofVaahan);
                            fout.println(ptr.NumberPlate);
                            Calendar calendar = Calendar.getInstance();
                            fout.println(calendar.get(Calendar.DAY_OF_MONTH));
                            fout.println(calendar.get(Calendar.MONTH) + 1);
                            fout.println(calendar.get(Calendar.YEAR));
                            fout.println(rent_days);
                        } catch (IOException e) {
                            System.out.println("Error writing to BusOnRent.txt file!");
                        }
                    } else {
                        System.out.println("Insufficient funds!\nAdd money to your account and try again...");
                    }
                } else {
                    System.out.println(ptr.NameofVaahan + " is currently unavailable.");
                }
            }
            ptr = ptr.next;
        }
        if (!flag) {
            System.out.println("Bus not found!");
        }
    }

    void rentBike(String username) {
        Scanner sc = new Scanner(System.in);
        System.out.println("For how many days would you like to rent?");
        int rent_days = sc.nextInt();
        System.out.println("\nWhich bike would you like to rent?");
        String chkbike = sc.next();

        NodeVaahan ptr = head_bike;
        NodeUser ptr2 = head_user;
        while (ptr2 != null) {
            if (ptr2.NameofUser.equals(username)) {
                break;
            }
            ptr2 = ptr2.next;
        }

        boolean flag = false;

        while (ptr != null) {
            if (ptr.NameofVaahan.equals(chkbike)) {
                flag = true;
                if (ptr.Count > 0) {
                    if ((rent_days * ptr.charges) < ptr2.balance) {
                        System.out.println("Dear customer, your Vaahan is booked.");
                        System.out.println("Details - \nName - " + ptr.NameofVaahan);
                        System.out.println("Number - " + ptr.NumberPlate + "\n" + ptr.Ventilation);
                        ptr2.balance -= (rent_days * ptr.charges);
                        System.out.println("Rs." + (rent_days * ptr.charges) + " were deducted from your account.");
                        System.out.println("Current balance - Rs." + ptr2.balance);
                        ptr.Count--;

                        try (PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("BikesOnRent.txt", true)))) {
                            fout.println(ptr2.NameofUser);
                            fout.println(ptr.NameofVaahan);
                            fout
         */     
            public void addMoney(String username) {
                Node_User ptr = head_user;
                Scanner scanner = new Scanner(System.in);
                int addMoney;
                while (ptr != null) {
                    if (ptr.NameofUser.equals(username)) {
                        System.out.println("\n\n\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb ADD MONEY \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\n");
                        System.out.print("\t\t\t\t\t\t\tEnter the amount you want to add (in rupees): ");
                        addMoney = scanner.nextInt();
                        ptr.balance += addMoney;
                        System.out.println("\t\t\t\t\t\t\tMoney added to your account successfully !");
                        System.out.println("\t\t\t\t\t\t\tBalance - Rs." + ptr.balance);
                    }
                    ptr = ptr.next;
                }
            }
        
            public void returnVaahan(String username) {
                Scanner scanner = new Scanner(System.in);
                int choice;
                do {
                    System.out.println("\n\n\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb RETURN VAAHAN \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\n");
                    System.out.println("\t\t\t\t\t\t\tSelect the type of vaahan you want to return - ");
                    System.out.println("\t\t\t\t\t\t\t1.car\n\t\t\t\t\t\t\t2.bus\n\t\t\t\t\t\t\t3.bike\n\t\t\t\t\t\t\t99.back\n\n\t\t\t\t\t\t\tYour choice : ");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            returnCar(username);
                            break;
                        case 2:
                            returnBus(username);
                            break;
                        case 3:
                            returnBike(username);
                            break;
                        case 99:
                            break;
                        default:
                            System.out.println("\t\t\t\t\t\t\tPlease enter valid input !");
                            break;
                    }
                } while (choice != 99);
            }
        
            public void returnCar(String username) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\n\n\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb RETURN CAR \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\n");
                System.out.print("\t\t\t\t\t\t\tEnter the name of car: ");
                String NameofVaahan1 = scanner.next();
                System.out.print("\t\t\t\t\t\t\tEnter the number plate of car: ");
                String NumberPlate1 = scanner.next();
                boolean flag = true, flag2 = true;
                try (BufferedReader fin = new BufferedReader(new FileReader("CarsOnRent.txt"))) {
                    String chkNameofVaahan, chkNumberPlate, chkusername;
                    int rent_days2, day2, month2, year2;
                    int[] dateReturn = {ltm.tm_mday, ltm.tm_mon, ltm.tm_year};
                    String line;
                    while ((line = fin.readLine()) != null) {
                        chkusername = line.trim();
                        chkNameofVaahan = fin.readLine().trim();
                        chkNumberPlate = fin.readLine().trim();
                        day2 = Integer.parseInt(fin.readLine().trim());
                        month2 = Integer.parseInt(fin.readLine().trim());
                        year2 = Integer.parseInt(fin.readLine().trim());
                        rent_days2 = Integer.parseInt(fin.readLine().trim());
                        if (chkusername.equals(username)) {
                            flag = false;
                            if (chkNameofVaahan.equals(NameofVaahan1) && chkNumberPlate.equals(NumberPlate1)) {
                                flag2 = false;
                                int[] dateIssue = {day2, month2, year2};
                                Node_User ptr1 = head_user;
                                Node_Vaahan ptr2 = head_car;
        
                                System.out.println("\n\t\t\t\t\t\t\t" + NameofVaahan1 + " - " + NumberPlate1 + " returned successfully !");
        
                                while (ptr2 != null) {
                                    if (ptr2.NameofVaahan.equals(NameofVaahan1)) {
                                        ptr2.Count++;
                                    }
                                    ptr2 = ptr2.next;
                                }
        
                                // fine for late return
                                if (countNoOfDays(dateIssue, dateReturn) > rent_days2) {
                                    int LateDays = countNoOfDays(dateIssue, dateReturn) - rent_days2;
                                    System.out.println("\t\t\t\t\t\t\tYou have to pay fine of Rs." + LateDays * 300 + "/- for " + LateDays + " days of late return.");
                                    ptr1.balance -= LateDays * 300;
                                    System.out.println("\t\t\t\t\t\t\tBalance - Rs." + ptr1.balance);
                                } else {
                                    while (ptr1 != null) {
                                        if (ptr1.NameofUser.equals(username)) {
                                            ptr1.balance += 20;
                                            System.out.println("\t\t\t\t\t\t\tYayyy! You earned Rs.20 Loyalty bonus !");
                                            System.out.println("\t\t\t\t\t\t\tBalance - Rs." + ptr1.balance);
                                        }
                                        ptr1 = ptr1.next;
                                    }
                                }
                            }
                        }
                    }
                    if (flag2)
                        System.out.println("\t\t\t\t\t\t\tCar and its number you are trying to return doesn't match !\n\t\t\t\t\t\t\tTry again...");
                    if (flag)
                        System.out.println("\t\t\t\t\t\t\tNo user found to return any Vaahan type you've chosen.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        
            public void returnBus(String username) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\n\n\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb RETURN BUS \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\n");
                System.out.print("\t\t\t\t\t\t\tEnter the name of bus: ");
                String NameofVaahan1 = scanner.next();
                System.out.print("\t\t\t\t\t\t\tEnter the number plate of bus: ");
                String NumberPlate1 = scanner.next();
                boolean flag = true, flag2 = true;
                try (BufferedReader fin = new BufferedReader(new FileReader("BusOnRent.txt"))) {
                    String chkNameofVaahan, chkNumberPlate, chkusername;
                    int rent_days2, day2, month2, year2;
                    int[] dateReturn = {ltm.tm_mday, ltm.tm_mon, ltm.tm_year};
                    String line;
                    while ((line = fin.readLine()) != null) {
                        chkusername = line.trim();
                        chkNameofVaahan = fin.readLine().trim();
                        chkNumberPlate = fin.readLine().trim();
                        day2 = Integer.parseInt(fin.readLine().trim());
                        month2 = Integer.parseInt(fin.readLine().trim());
                        year2 = Integer.parseInt(fin.readLine().trim());
                        rent_days2 = Integer.parseInt(fin.readLine().trim());
                        if (chkusername.equals(username)) {
                            flag = false;
                            if (chkNameofVaahan.equals(NameofVaahan1) && chkNumberPlate.equals(NumberPlate1)) {
                                flag2 = false;
                                int[] dateIssue = {day2, month2, year2};
                                Node_User ptr1 = head_user;
                                Node_Vaahan ptr2 = head_bus;
        
                                System.out.println("\n\t\t\t\t\t\t\t" + NameofVaahan1 + " - " + NumberPlate1 + " returned successfully !");
        
                                while (ptr2 != null) {
                                    if (ptr2.NameofVaahan.equals(NameofVaahan1)) {
                                        ptr2.Count++;
                                    }
                                    ptr2 = ptr2.next;
                                }
        
                                // fine for late return
                                if (countNoOfDays(dateIssue, dateReturn) > rent_days2) {
                                    int LateDays = countNoOfDays(dateIssue, dateReturn) - rent_days2;
                                    System.out.println("\t\t\t\t\t\t\tYou have to pay fine of Rs." + LateDays * 400 + "/- for " + LateDays + " days of late return.");
                                    ptr1.balance -= LateDays * 300;
                                    System.out.println("\t\t\t\t\t\t\tBalance - Rs." + ptr1.balance);
                                } else {
                                    while (ptr1 != null) {
                                        if (ptr1.NameofUser.equals(username)) {
                                            ptr1.balance += 30;
                                            System.out.println("\t\t\t\t\t\t\tYayyy! You earned Rs.30 Loyalty bonus !");
                                            System.out.println("\t\t\t\t\t\t\tBalance - Rs." + ptr1.balance);
                                        }
                                        ptr1 = ptr1.next;
                                    }
                                }
                            }
                        }
                    }
                    if (flag2)
                        System.out.println("\t\t\t\t\t\t\tBus and its number you are trying to return doesn't match !\n\t\t\t\t\t\t\tTry again...");
                    if (flag)
                        System.out.println("\t\t\t\t\t\t\tNo user found to return any Vaahan type you've chosen.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            void insertNodecar(String NameofVaahan, String NumberPlate, String Ventilation, int Count, int charges) {
                Node_Vaahan newNode = new Node_Vaahan(NameofVaahan, NumberPlate, Ventilation, Count, charges);
                if (head_car == null) {
                    head_car = newNode;
                    return;
                }
                Node_Vaahan temp = head_car;
                while (temp.next != null) temp = temp.next;
                temp.next = newNode;
            }
        
            void insertNodebus(String NameofVaahan, String NumberPlate, String Ventilation, int Count, int charges) {
                Node_Vaahan newNode = new Node_Vaahan(NameofVaahan, NumberPlate, Ventilation, Count, charges);
                if (head_bus == null) {
                    head_bus = newNode;
                    return;
                }
                Node_Vaahan temp = head_bus;
                while (temp.next != null) temp = temp.next;
                temp.next = newNode;
            }
        
            void insertNodebike(String NameofVaahan, String NumberPlate, String Ventilation, int Count, int charges) {
                Node_Vaahan newNode = new Node_Vaahan(NameofVaahan, NumberPlate, Ventilation, Count, charges);
                if (head_bike == null) {
                    head_bike = newNode;
                    return;
                }
                Node_Vaahan temp = head_bike;
                while (temp.next != null) temp = temp.next;
                temp.next = newNode;
            }
        
            void createcarList() {
                try (BufferedReader fin = new BufferedReader(new FileReader("cars.txt"))) {
                    String line;
                    while ((line = fin.readLine()) != null) {
                        String NameofVaahan1 = line.trim();
                        String NumberPlate1 = fin.readLine().trim();
                        String Ventilation1 = fin.readLine().trim();
                        int Count1 = Integer.parseInt(fin.readLine().trim());
                        int charges1 = Integer.parseInt(fin.readLine().trim());
                        insertNodecar(NameofVaahan1, NumberPlate1, Ventilation1, Count1, charges1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        
            void createbusList() {
                try (BufferedReader fin = new BufferedReader(new FileReader("bus.txt"))) {
                    String line;
                    while ((line = fin.readLine()) != null) {
                        String NameofVaahan1 = line.trim();
                        String NumberPlate1 = fin.readLine().trim();
                        String Ventilation1 = fin.readLine().trim();
                        int Count1 = Integer.parseInt(fin.readLine().trim());
                        int charges1 = Integer.parseInt(fin.readLine().trim());
                        insertNodebus(NameofVaahan1, NumberPlate1, Ventilation1, Count1, charges1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        
            void createbikeList() {
                try (BufferedReader fin = new BufferedReader(new FileReader("bikes.txt"))) {
                    String line;
                    while ((line = fin.readLine()) != null) {
                        String NameofVaahan1 = line.trim();
                        String NumberPlate1 = fin.readLine().trim();
                        String Ventilation1 = fin.readLine().trim();
                        int Count1 = Integer.parseInt(fin.readLine().trim());
                        int charges1 = Integer.parseInt(fin.readLine().trim());
                        insertNodebike(NameofVaahan1, NumberPlate1, Ventilation1, Count1, charges1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            void insertNodecar(String NameofVaahan, String NumberPlate, String Ventilation, int Count, int charges) {
                Node_Vaahan newNode = new Node_Vaahan(NameofVaahan, NumberPlate, Ventilation, Count, charges);
                if (head_car == null) {
                    head_car = newNode;
                    return;
                }
                Node_Vaahan temp = head_car;
                while (temp.next != null) temp = temp.next;
                temp.next = newNode;
            }
        
            void insertNodebus(String NameofVaahan, String NumberPlate, String Ventilation, int Count, int charges) {
                Node_Vaahan newNode = new Node_Vaahan(NameofVaahan, NumberPlate, Ventilation, Count, charges);
                if (head_bus == null) {
                    head_bus = newNode;
                    return;
                }
                Node_Vaahan temp = head_bus;
                while (temp.next != null) temp = temp.next;
                temp.next = newNode;
            }
        
            void insertNodebike(String NameofVaahan, String NumberPlate, String Ventilation, int Count, int charges) {
                Node_Vaahan newNode = new Node_Vaahan(NameofVaahan, NumberPlate, Ventilation, Count, charges);
                if (head_bike == null) {
                    head_bike = newNode;
                    return;
                }
                Node_Vaahan temp = head_bike;
                while (temp.next != null) temp = temp.next;
                temp.next = newNode;
            }
        
            void createcarList() {
                try (BufferedReader fin = new BufferedReader(new FileReader("cars.txt"))) {
                    String line;
                    while ((line = fin.readLine()) != null) {
                        String NameofVaahan1 = line.trim();
                        String NumberPlate1 = fin.readLine().trim();
                        String Ventilation1 = fin.readLine().trim();
                        int Count1 = Integer.parseInt(fin.readLine().trim());
                        int charges1 = Integer.parseInt(fin.readLine().trim());
                        insertNodecar(NameofVaahan1, NumberPlate1, Ventilation1, Count1, charges1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        
            void createbusList() {
                try (BufferedReader fin = new BufferedReader(new FileReader("bus.txt"))) {
                    String line;
                    while ((line = fin.readLine()) != null) {
                        String NameofVaahan1 = line.trim();
                        String NumberPlate1 = fin.readLine().trim();
                        String Ventilation1 = fin.readLine().trim();
                        int Count1 = Integer.parseInt(fin.readLine().trim());
                        int charges1 = Integer.parseInt(fin.readLine().trim());
                        insertNodebus(NameofVaahan1, NumberPlate1, Ventilation1, Count1, charges1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        
            void createbikeList() {
                try (BufferedReader fin = new BufferedReader(new FileReader("bikes.txt"))) {
                    String line;
                    while ((line = fin.readLine()) != null) {
                        String NameofVaahan1 = line.trim();
                        String NumberPlate1 = fin.readLine().trim();
                        String Ventilation1 = fin.readLine().trim();
                        int Count1 = Integer.parseInt(fin.readLine().trim());
                        int charges1 = Integer.parseInt(fin.readLine().trim());
                        insertNodebike(NameofVaahan1, NumberPlate1, Ventilation1, Count1, charges1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

void display_all_Vaahan() {
                System.out.println("\n\n\t\t\t\t\t\t\tALL VAAHAN LIST\n");
                int choice;
                do {
                    System.out.println("\n\t\t\t\t\t\t\tChoose type of Vaahan");
                    System.out.println("\t\t\t\t\t\t\t1.Car.");
                    System.out.println("\t\t\t\t\t\t\t2.Bus.");
                    System.out.println("\t\t\t\t\t\t\t3.Bike.");
                    System.out.println("\t\t\t\t\t\t\t99.back.");
                    System.out.print("\n\t\t\t\t\t\t\tYour choice: ");
                    choice = Integer.parseInt(System.console().readLine());
                    switch (choice) {
                        case 1:
                            display_all_cars();
                            break;
                        case 2:
                            display_all_bus();
                            break;
                        case 3:
                            display_all_bikes();
                            break;
                        case 99:
                            break;
                        default:
                            System.out.println("\t\t\t\t\t\t\tPlease enter valid input !");
                            break;
                    }
                } while (choice != 99);
            }
        
            void display_all_cars() {
                System.out.println("\n\n\t\t\t\t\t\t\tALL CARS\n");
                Node_Vaahan temp = head_car;
                if (head_car == null) {
                    System.out.println("\n\t\t\t\t\t\t\tList empty");
                    return;
                }
        
                while (temp != null) {
                    System.out.println("\n\t\t\t\t\t\t\tName - " + temp.NameofVaahan);
                    System.out.println("\t\t\t\t\t\t\tNumber plate - " + temp.NumberPlate);
                    System.out.println("\t\t\t\t\t\t\tventilation type - " + temp.Ventilation);
                    System.out.println("\t\t\t\t\t\t\tCharges per hour - Rs." + temp.charges);
                    temp = temp.next;
                    System.out.println("\t\t\t\t\t\t\t*************************************");
                }
                System.out.println("\n");
            }


void Vaahan::display_all_available()
{
    system("cls");
    int choice;
    do
    {

        cout << endl
             << endl;
        char a[] = "\n\n\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb CHOOSE VAAHAN \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\n";
        int size;
        size = strlen(a);
        for (int i = 0; i < size; i++)
        {
            Sleep(1);
            cout << a[i];
        }

        cout << "\n\t\t\t\t\t\t\tChoose type of Vaahan\n\t\t\t\t\t\t\t1.Car.\n\t\t\t\t\t\t\t2.Bus.\n\t\t\t\t\t\t\t3.Bike.\n\t\t\t\t\t\t\t99.back.\n\n\t\t\t\t\t\t\tYour choice : ";
        cin >> choice;
        system("cls");
        switch (choice)
        {
        case 1:

            display_available_cars();
            break;
        case 2:

            display_available_bus();
            break;
        case 3:

            display_available_bikes();
            break;
        case 99:
            break;
        default:
            cout << "\n\n\t\t\t\t\t\t\tPlease enter valid input !" << endl;
            break;
        }

    } while (choice != 99);
}

void Vaahan::display_available_cars()
{
    clearScreen();
        printTitle("AVAILABLE CARS");

        NodeVaahan temp = headCar;

        if (headCar == null) {
            System.out.println("\t\t\t\t\t\t\tList empty");
            return;
        }

        while (temp != null) {
            if (temp.count > 0) {
                System.out.println("\n\t\t\t\t\t\t\tName - " + temp.nameOfVaahan);
                System.out.println("\t\t\t\t\t\t\tNumber plate - " + temp.numberPlate);
                System.out.println("\t\t\t\t\t\t\tVentilation type - " + temp.ventilation);
                System.out.println("\t\t\t\t\t\t\tCharges per hour - Rs." + temp.charges);
                System.out.println("\t\t\t\t\t\t\t*************************************");
            }
            temp = temp.next;
        }
        System.out.println();
}

void Vaahan::display_available_bus()
{
   clearScreen();
        printTitle("AVAILABLE BUSES");

        NodeVaahan temp = headBus;

        if (headBus == null) {
            System.out.println("\t\t\t\t\t\t\tList empty");
            return;
        }

        while (temp != null) {
            if (temp.count > 0) {
                System.out.println("\n\t\t\t\t\t\t\tName - " + temp.nameOfVaahan);
                System.out.println("\t\t\t\t\t\t\tNumber plate - " + temp.numberPlate);
                System.out.println("\t\t\t\t\t\t\tVentilation type - " + temp.ventilation);
                System.out.println("\t\t\t\t\t\t\tCharges per hour - Rs." + temp.charges);
                System.out.println("\t\t\t\t\t\t\t*****");
            }
            temp = temp.next;
        }
        System.out.println();
}

void Vaahan::display_available_bikes()
{
    clearScreen();
        printTitle("AVAILABLE BIKES");

        NodeVaahan temp = headBike;

        if (headBike == null) {
            System.out.println("\t\t\t\t\t\t\tList empty");
            return;
        }

        while (temp != null) {
            if (temp.count > 0) {
                System.out.println("\n\t\t\t\t\t\t\tName - " + temp.nameOfVaahan);
                System.out.println("\t\t\t\t\t\t\tNumber plate - " + temp.numberPlate);
                System.out.println("\t\t\t\t\t\t\tCharges per hour - Rs." + temp.charges);
                System.out.println("\t\t\t\t\t\t\t*************");
            }
            temp = temp.next;
        }
        System.out.println();
}

void Vaahan::addVaahan()
{
     clearScreen();
        printTitle("ADD VAAHAN DETAILS");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\tEnter the type of Vaahan you want to add (car / bus / bike): ");
        String choice = scanner.nextLine();
        
        System.out.println("\t\t\t\t\t\t\tPlease enter the Name of Vaahan: ");
        String nameOfVaahan = scanner.nextLine();
        System.out.println("\t\t\t\t\t\t\tPlease enter the number plate: ");
        String numberPlate = scanner.nextLine();
        System.out.println("\t\t\t\t\t\t\tPlease enter the ventilation type: ");
        String ventilation = scanner.nextLine();
        System.out.println("\t\t\t\t\t\t\tPlease enter the charges (in Rs.) per day: ");
        int charges = scanner.nextInt();

        switch (choice.toLowerCase()) {
            case "car":
                insertNodeCar(nameOfVaahan, numberPlate, ventilation, 1, charges);
                System.out.println("\n\t\t\t\t\t\t\tCar added successfully to list.");
                break;
            case "bus":
                insertNodeBus(nameOfVaahan, numberPlate, ventilation, 1, charges);
                System.out.println("\n\t\t\t\t\t\t\tBus added successfully to list.");
                break;
            case "bike":
                insertNodeBike(nameOfVaahan, numberPlate, ventilation, 1, charges);
                System.out.println("\n\t\t\t\t\t\t\tBike added successfully to list.");
                break;
            default:
                System.out.println("\n\t\t\t\t\t\t\tPlease enter a valid argument and try again!");
                break;
        }
void Vaahan::RepairVaahan()
{clearScreen();
        printTitle("REPAIR VAAHAN");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\tEnter the type of Vaahan you want to repair (car / bus / bike): ");
        String choice = scanner.nextLine();
        System.out.println("\t\t\t\t\t\t\tEnter the name of Vaahan you want to repair: ");
        String nameOfVaahan = scanner.nextLine();
        System.out.println("\t\t\t\t\t\t\tEnter the Number plate of Vaahan: ");
        String numberPlate = scanner.nextLine();

        switch (choice.toLowerCase()) {
            case "car":
                repairVaahanHelper(headCar, nameOfVaahan, numberPlate);
                break;
            case "bus":
                repairVaahanHelper(headBus, nameOfVaahan, numberPlate);
                break;
            case "bike":
                repairVaahanHelper(headBike, nameOfVaahan, numberPlate);
                break;
            default:
                System.out.println("\n\t\t\t\t\t\t\tInvalid input, please try again.");
                break;
        }
    }

    private void repairVaahanHelper(NodeVaahan head, String nameOfVaahan, String numberPlate) {
        boolean found = false;
        NodeVaahan ptr = head;
        Scanner scanner = new Scanner(System.in);

        while (ptr != null) {
            if (ptr.nameOfVaahan.equals(nameOfVaahan) && ptr.numberPlate.equals(numberPlate)) {
                found = true;
                if (ptr.count > 0) {
                    System.out.println("\n\t\t\t\t\t\t\t" + ptr.nameOfVaahan + " with number " + ptr.numberPlate
                            + " will be sent to the garage for repair.");
                    System.out.println("\n\t\t\t\t\t\t\tPlease wait, mechanic is checking the condition of the vaahan...");
                    showPercentCompleteFast();
                    System.out.println("\n\n\t\t\t\t\t\t\tCheck-up done!");
                    System.out.println("\n\t\t\t\t\t\t\tYou need to wait for a while until the vaahan gets repaired.");
                    System.out.println("\n\t\t\t\t\t\t\tDo you want to continue with the repair process (yes / no)?: ");
                    String rentDays = scanner.nextLine();
                    if (rentDays.equalsIgnoreCase("yes")) {
                        System.out.println("\n\t\t\t\t\t\t\tMechanic is repairing your vaahan...");
                        showPercentCompleteSlow();
                        System.out.println("\n\t\t\t\t\t\t\tVaahan repair success!");
                    } else if (rentDays.equalsIgnoreCase("no")) {
                        System.out.println("\n\t\t\t\t\t\t\tOk! Vaahan not sent for repair.");
                    } else {
                        System.out.println("\n\t\t\t\t\t\t\tEnter valid input and try again!");
                    }
                } else {
                    System.out.println("\n\t\t\t\t\t\t\tDear admin, " + nameOfVaahan + " is not available with you currently.\n"
                            + "\t\t\t\t\t\t\tCheck whether it is given for rent or already sent to mechanic.");
                }
            }
            ptr = ptr.next;
        }
        if (!found) {
            System.out.println("\n\t\t\t\t\t\t\tVaahan not found with name " + nameOfVaahan + " and number " + numberPlate + ", try again later.");
        }
    }

    private void clearScreen() {
        // This method simulates clearing the screen, as Java does not have a direct equivalent of system("cls").
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    private void printTitle(String title) {
        String decoration = "\n\n\t\t\t\t\t\t\t==================== " + title + " ====================\n";
        for (char c : decoration.toCharArray()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(c);
        }
    }

    private void showPercentCompleteFast() {
        // Simulate progress indicator
        for (int i = 0; i <= 100; i += 20) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(i + "% ");
        }
        System.out.println();
    }

    private void showPercentCompleteSlow() {
        // Simulate progress indicator
        for (int i = 0; i <= 100; i += 10) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(i + "% ");
        }
        System.out.println();
    }
}
//===================Login / sign-up==========================//

void User::PreLogin_Customer()
{
    system("cls");
    int choice;
    do
    {
        system("cls");

        cout << endl
             << endl;

        char a[] = "\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb CUSTOMER \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\n";
        int size;
        size = strlen(a);
        for (int i = 0; i < size; i++)
        {
            Sleep(1);
            cout << a[i];
        }
        cout << "\n\t\t\t\t\t\t\t1.Login.\n\t\t\t\t\t\t\t2.Sign-up.\n\t\t\t\t\t\t\t99.Exit.\n\n\t\t\t\t\t\t\tYour option : ";
        cin >> choice;
        switch (choice)
        {
        case 1:
            system("cls");
            Login_customer();
            break;
        case 2:
            Sign_up();
            break;
        case 99:
            break;
        default:
            cout << "\n\t\t\t\t\t\t\tPlease enter valid input !" << endl;
            break;
        }
    } while (choice != 99);
}

void User::Login_customer()
{
    char a[] = "\n\n\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb LOGIN DETAILS \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\n";
    int size;
    size = strlen(a);
    for (int i = 0; i < size; i++)
    {
        Sleep(1);
        cout << a[i];
    }
    string username;
    string password;
    cout << "\n\t\t\t\t\t\t\tEnter your username : ";
    cin >> username;
    cout << "\n\t\t\t\t\t\t\tEnter your password : ";
    cin >> password;
    bool flag = 1;
    Node_User *ptr = head_user;
    while (ptr != NULL)
    {
        if (ptr->NameofUser == username && ptr->Password == password)
        {
            flag = 0;
            AfterLoginCustomer(username);
        }
        ptr = ptr->next;
    }
    if (flag)
    {
        cout << "\n\t\t\t\t\t\t\tInvalid username or password !" << endl;
        sleep(3);
    }
}

void User::AfterLoginCustomer(string username)
{
    system("cls");
    int choice;
    do
    {

        cout << endl
             << endl;
        char a[] = "\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb DASHBOARD \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\n";
        int size;
        size = strlen(a);
        for (int i = 0; i < size; i++)
        {
            Sleep(1);
            cout << a[i];
        }
        cout << "\n\t\t\t\t\t\t\t1.Check for available Vaahan.\n\t\t\t\t\t\t\t2.Rent a Vaahan.\n\t\t\t\t\t\t\t3.Return Vaahan.\n\t\t\t\t\t\t\t4.Add Money.\n\t\t\t\t\t\t\t5.Display my details.\n\t\t\t\t\t\t\t99.Log-out.\n\n\t\t\t\t\t\t\tYour option : ";
        cin >> choice;
        switch (choice)
        {
        case 1:
            display_all_available();
            break;
        case 2:
            rent(username);
            break;
        case 3:
            returnVaahan(username);
            break;
        case 4:
            add_money(username);
            break;
        case 5:
            display_my_details(username);
            break;
        case 99:
            break;
        default:
            system("cls");
            cout << "\n\t\t\t\t\t\t\tPlease enter valid input !" << endl;
            break;
        }

    } while (choice != 99);
}

void User::Login_admin()
{
    system("cls");
    cout << endl
         << endl;
    char a[] = "\n\n\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb ADMIN \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\n";
    int size;
    size = strlen(a);
    for (int i = 0; i < size; i++)
    {
        Sleep(1);
        cout << a[i];
    }
    string username;
    string password;
    cout << "\n\t\t\t\t\t\t\tDear admin, to login enter your username : ";
    cin >> username;
    cout << "\n\t\t\t\t\t\t\tPlease enter your password : ";
    cin >> password;
    string chk_username;
    string chk_password;

    ifstream fin;
    bool flag = 1;
    fin.open("admin.txt");
    while (!fin.eof())
    {
        getline(fin >> ws, chk_username);
        getline(fin >> ws, chk_password);

        if (username == chk_username && password == chk_password)
        {
            flag = 0;
            AfterLoginAdmin(username);
        }
    }
    if (flag)
        cout << "\n\t\t\t\t\t\t\tInvalid username or password !" << endl;
    system("cls");
    fin.close();
}

void User::AfterLoginAdmin(string username)
{
    system("cls");
    int choice;
    do
    {
        cout << endl
             << endl;
        char a[] = "\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb LOGIN DASHBOARD \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\n";
        int size;
        size = strlen(a);
        for (int i = 0; i < size; i++)
        {
            Sleep(1);
            cout << a[i];
        }
        cout << "\n\t\t\t\t\t\t\t1.Add Vaahan.\n\t\t\t\t\t\t\t2.Repair Vaahan.\n\t\t\t\t\t\t\t3.Display all Vaahans.\n\t\t\t\t\t\t\t4.Display available Vaahans for rent.\n\t\t\t\t\t\t\t5.Display all users data.\n\t\t\t\t\t\t\t99.Exit.\n\n\t\t\t\t\t\t\t Your Choice : ";
        cin >> choice;
        switch (choice)
        {
        case 1:
            addVaahan();
            break;
        case 2:
            RepairVaahan();
            break;
        case 3:
            display_all_Vaahan();
            break;
        case 4:
            display_all_available();
            break;
        case 5:
            display_all_users();
            break;
        case 99:
            break;
        default:
            cout << "Please enter valid input !" << endl;
            break;
        }
    } while (choice != 99);
}

void User::Sign_up()
{
    string NameofUser1;
    string password1;
    int balance1;
    string LicenseNumber1;
    string PhoneNumber1;
    cout << "\n\t\t\t\t\t\t\tYour Name : ";
    cin >> NameofUser1;
    cout << "\t\t\t\t\t\t\tChoose a strong password : ";
    cin >> password1;
    cout << "\t\t\t\t\t\t\tAdd money to your account : Rs.";
    cin >> balance1;
    cout << "\t\t\t\t\t\t\tLicense number : ";
    cin >> LicenseNumber1;
    cout << "\t\t\t\t\t\t\tPhone number - ";
    cin >> PhoneNumber1;
    insertNodeUser(NameofUser1, password1, balance1, LicenseNumber1, PhoneNumber1);
}

//====================main=============================//

int main()
{
    system("cls");

    // intro();
    //  system("cls");
    system("color F0");
    // first number for bg color and second for font color
    User obj;
    obj.createUserList();
    obj.createcarList();
    obj.createbusList();
    obj.createbikeList();
    int choice;
    do
    {
        system("cls");
        // for (int k = 0; k < 160; k++)
        // {
        //     cout << char(177);
        // }
        // system("color 08");
        cout << endl
             << endl;
        for (int i = 0; i < 1; i++)
        {
            int x = 0;
            int y = 1;
            for (y = 1; y < 20; y++)
            {
                gotoXY(x, y);
                cout << "\xB1\xB1";
                Sleep(1);
                // gotoXY(x,y);
                // cout << "                                                     ";
            }
            y = 19;
            for (x = 2; x < 160; x++)
            {
                gotoXY(x, y);
                cout << "\xB1";
                Sleep(1);
                // gotoXY(x,y);
                // cout << "                                                     ";
            }
            x = 158;
            for (y = 18; y > 0; y--)
            {
                gotoXY(x, y);
                cout << "\xB1\xB1";
                Sleep(1);

                // cout << "                                                     ";
            }
            y = 0;

            for (x = 159; x > -1; x--)
            {
                gotoXY(x, y);
                cout << "\xB1";
                Sleep(1);
                // gotoXY(x,y);
                // cout << "                                                     ";
            }
            y = 3, x = 5;
            gotoXY(x, y);
        }
        char a[] = "\n\t\t\t\t\t\t\t\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb VAAHAN WALLAH \xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb\xdb";
        int size;
        size = strlen(a);
        for (int i = 0; i < size; i++)
        {
            Sleep(1);
            cout << a[i];
        }

        cout << endl
             << endl;
        Sleep(0);
        cout << "\t\t\t\t\t\t\t\t\t     Welcome\n";
        cout << "\t\t\t\t\t\t\t1.Customer.\n\t\t\t\t\t\t\t2.Admin.\n\t\t\t\t\t\t\t99.Exit.\n\n\t\t\t\t\t\t\t";
        cout << "Select Your Option : ";

        cin >> choice;
        switch (choice)
        {
        case 1:
            system("cls");
            obj.PreLogin_Customer();
            break;
        case 2:
            system("cls");
            obj.Login_admin();
            break;
        case 99:
            system("cls");
            break;
        default:
            system("cls");
            cout << "Please enter valid input ! \nTry again..." << endl;
            break;
        }
    } while (choice != 99);
}
