import java.util.Scanner;

public class AdminPanel {
    private final Scanner sc = new Scanner(System.in);
    private final UserService userService = new UserService();
    private final BikeService bikeService = new BikeService();
    private final RentalService rentalService = new RentalService();
    private final UserRegistration userRegistration = new UserRegistration();

    public void userManagementOptions() {
        while (true) {
            System.out.println("\n===== Welcome to E-Ryder Admin Panel =====");
            System.out.println("1. Add New User");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered User");
            System.out.println("4. Update Registered User");
            System.out.println("5. Demo E-Bike Rental System");
            System.out.println("6. Check Balanced Brackets");
            System.out.println("7. Exit");
            System.out.print("Please enter your choice: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1": userService.addNewUsers(); break;
                case "2": userService.viewRegisteredUsers(); break;
                case "3": userService.removeRegisteredUsers(); break;
                case "4": userService.updateRegisteredUsers(); break;
                case "5": simulateRental(); break;
                case "6": new BracketChecker().checkBrackets(); break;
                case "7":
                    System.out.println("Exiting Admin Panel...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void simulateRental() {
        System.out.println("\n===== E-Bike Rental Process Simulation =====");

        System.out.print("Are you a registered user (true/false): ");
        boolean isRegistered = Boolean.parseBoolean(sc.nextLine());

        System.out.print("Enter email address: ");
        String email = sc.nextLine();

        System.out.print("Enter rental location: ");
        String location = sc.nextLine();

        System.out.println("\n----- Analyzing Rental Request -----");
        if (isRegistered) {
            System.out.println("Welcome back, " + email + "!");
        } else {
            System.out.println("You are not a registered user. Please register.");
            userRegistration.registration();
        }

        String bikeID = bikeService.validateLocation(location);
        if (bikeID == null) return;

        System.out.println("\n----- Simulating E-Bike Reservation... -----");
        java.time.LocalDateTime startTime = bikeService.reserveBike(bikeID);
        if (startTime == null) return;
        rentalService.startRental(bikeID, email, startTime);

        System.out.println("\n----- Displaying Current Active Rentals... -----");
        rentalService.viewActiveRentals();

        System.out.println("\n----- Simulating Trip Completion... -----");
        rentalService.terminateRental(bikeID);
        bikeService.releaseBike(bikeID);
        System.out.println("Your trip has ended. Thank you for riding with us.");

        System.out.println("\n----- Displaying Active Rentals After Trip... -----");
        rentalService.viewActiveRentals();
    }
}