import java.util.*;

class Patient {
    String id, name, age, gender, history, appointment;

    Patient(String id, String name, String age, String gender, String history) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.history = history;
        this.appointment = "None";
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender +
               ", History: " + history + ", Appointment: " + appointment;
    }
}

public class HospitalInformationSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Hospital Information System ---");
            System.out.println("1. Register Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Update Patient Info");
            System.out.println("4. Book Appointment");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) registerPatient();
            else if (choice == 2) viewPatients();
            else if (choice == 3) updatePatient();
            else if (choice == 4) bookAppointment();
            else if (choice == 5) break;
            else System.out.println("Invalid choice.");
        }
    }

    static void registerPatient() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        if (findPatient(id) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        String age = sc.nextLine();
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter Medical History: ");
        String history = sc.nextLine();

        patients.add(new Patient(id, name, age, gender, history));
        System.out.println("Patient registered.");
    }

    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patient records.");
        } else {
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
    }

    static void updatePatient() {
        System.out.print("Enter Patient ID to update: ");
        String id = sc.nextLine();
        Patient p = findPatient(id);
        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter New Name: ");
        p.name = sc.nextLine();
        System.out.print("Enter New Age: ");
        p.age = sc.nextLine();
        System.out.print("Enter New Gender: ");
        p.gender = sc.nextLine();
        System.out.print("Enter New Medical History: ");
        p.history = sc.nextLine();

        System.out.println("Patient updated.");
    }

    static void bookAppointment() {
        System.out.print("Enter Patient ID to book appointment: ");
        String id = sc.nextLine();
        Patient p = findPatient(id);
        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Enter Appointment Date (e.g., 10-05-2025): ");
        p.appointment = sc.nextLine();
        System.out.println("Appointment booked.");
    }

    static Patient findPatient(String id) {
        for (Patient p : patients) {
            if (p.id.equalsIgnoreCase(id)) return p;
        }
        return null;
    }
}
