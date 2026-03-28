import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BikeRental {
    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;

    private UserRegistration userRegistration = new UserRegistration();
    private ActiveRental activeRental;
    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private Scanner sc = new Scanner(System.in);

    public void simulateApplicationInput() {
        System.out.println("\n===== E-Bike Rental Process Simulation =====");

        System.out.print("Are you a registered user (true/false): ");
        isRegisteredUser = Boolean.parseBoolean(sc.nextLine());

        System.out.print("Enter email address: ");
        emailAddress = sc.nextLine();

        System.out.print("Enter rental location: ");
        location = sc.nextLine();

        System.out.println("\n----- Analyzing Rental Request -----");
        bikeID = analyseRequest(isRegisteredUser, emailAddress, location);

        if (!locationValid) {
            return;
        }

        System.out.println("\n----- Simulating E-Bike Reservation... -----");
        reserveBike(bikeID);

        System.out.println("\n----- Displaying Current Active Rentals... -----");
        viewActiveRentals();

        System.out.println("\n----- Simulating Trip Completion... -----");
        removeTrip(bikeID);

        System.out.println("\n----- Displaying Active Rentals After Trip... -----");
        viewActiveRentals();
    }

    private String analyseRequest(boolean isRegistered, String email, String loc) {
        if (isRegistered) {
            System.out.println("Welcome back, " + email + "!");
        } else {
            System.out.println("You are not a registered user. Please register.");
            userRegistration.registration();
        }
        return validateLocation(loc);
    }

    private String validateLocation(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equalsIgnoreCase(location) && bike.isAvailable()) {
                System.out.println("Bikes are available at your requested location.");
                locationValid = true;
                return bike.getBikeID();
            }
        }
        System.out.println("Sorry, no bikes available at your requested location. Please try again later.");
        locationValid = false;
        return null;
    }

    private void reserveBike(String bikeID) {
        if (bikeID == null) {
            System.out.println("Sorry, we cannot reserve a bike at this time. Please try again later.");
            return;
        }

        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                tripStartTime = LocalDateTime.now();
                bike.setAvailable(false);
                bike.setLastUsedTime(tripStartTime);

                System.out.println("Reserving bike with ID: " + bikeID + ". Please follow on-screen instructions to find your bike and enjoy your ride.");

                activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
                activeRentalsList.add(activeRental);
                break;
            }
        }
    }

    private void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals currently.");
            return;
        }
        for (ActiveRental rental : activeRentalsList) {
            System.out.println(rental);
        }
    }

    private void removeTrip(String bikeID) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getBikeID().equals(bikeID)) {
                iterator.remove();
                break;
            }
        }

        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Your trip has ended. Thank you for riding with us.");
                break;
            }
        }
    }
}
