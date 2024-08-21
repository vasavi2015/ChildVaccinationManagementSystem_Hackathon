import java.util.*;

class Child {
    private String name;
    private int age;
    private String parentName;
    private String contactNumber;
    private String vaccinationDate;
    private String vaccinationTime;   // New field for scheduling time
    private String vaccinationLocation; // New field for vaccination location
    private String vaccinationType;
    private int uniqueId;

    public Child(String name, int age, String parentName, String contactNumber, String vaccinationDate, String vaccinationTime, String vaccinationLocation, String vaccinationType, int uniqueId) {
        this.name = name;
        this.age = age;
        this.parentName = parentName;
        this.contactNumber = contactNumber;
        this.vaccinationDate = vaccinationDate;
        this.vaccinationTime = vaccinationTime;
        this.vaccinationLocation = vaccinationLocation;
        this.vaccinationType = vaccinationType;
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getParentName() {
        return parentName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getVaccinationDate() {
        return vaccinationDate;
    }

    public String getVaccinationTime() {
        return vaccinationTime;
    }

    public String getVaccinationLocation() {
        return vaccinationLocation;
    }

    public String getVaccinationType() {
        return vaccinationType;
    }

    public int getUniqueId() {
        return uniqueId;
    }
}

class VaccinationManagementSystem {
    private List<Child> childList = new ArrayList<>();
    private Random random = new Random();

    public void registerChild(String name, int age, String parentName, String contactNumber, String vaccinationDate, String vaccinationTime, String vaccinationLocation, String vaccinationType) {
        int uniqueId = random.nextInt(9000) + 1000; // Generates a 4-digit unique ID
        Child newChild = new Child(name, age, parentName, contactNumber, vaccinationDate, vaccinationTime, vaccinationLocation, vaccinationType, uniqueId);
        childList.add(newChild);
        System.out.println("Registration successful! Unique ID: " + uniqueId);
    }

    public void viewRecords() {
        System.out.printf("%-10s %-10s %-10s %-15s %-15s %-15s %-15s %-20s %-20s%n", "ID", "Name", "Age", "Parent Name", "Contact Number", "Vaccination Date", "Vaccination Time", "Vaccination Location", "Vaccination Type");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Child child : childList) {
            System.out.printf("%-10d %-10s %-10d %-15s %-15s %-15s %-15s %-20s %-20s%n", 
                child.getUniqueId(), child.getName(), child.getAge(), child.getParentName(), 
                child.getContactNumber(), child.getVaccinationDate(), child.getVaccinationTime(), 
                child.getVaccinationLocation(), child.getVaccinationType());
        }
    }
}

public class ChildVaccinationManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VaccinationManagementSystem vms = new VaccinationManagementSystem();

        while (true) {
            System.out.println("\n--- Child Vaccination Management System ---");
            System.out.println("1. Register a Child");
            System.out.println("2. View Records");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter child's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter child's age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter parent's name: ");
                    String parentName = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    System.out.print("Enter vaccination date (dd/mm/yyyy): ");
                    String vaccinationDate = scanner.nextLine();
                    System.out.print("Enter vaccination time (HH:mm): ");
                    String vaccinationTime = scanner.nextLine();
                    System.out.print("Enter vaccination location: ");
                    String vaccinationLocation = scanner.nextLine();
                    System.out.print("Enter vaccination type: ");
                    String vaccinationType = scanner.nextLine();

                    vms.registerChild(name, age, parentName, contactNumber, vaccinationDate, vaccinationTime, vaccinationLocation, vaccinationType);
                    break;
                case 2:
                    vms.viewRecords();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
