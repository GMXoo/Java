import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

class Bike {
    private String bikeID;
    private boolean isAvailable;
    private int batteryLevel;
    private LocalDateTime lastUsedTime;
    private String location;

    public Bike(String bikeID, boolean isAvailable, int batteryLevel, LocalDateTime lastUsedTime, String location) {
        this.bikeID = bikeID;
        this.isAvailable = isAvailable;
        this.batteryLevel = batteryLevel;
        this.lastUsedTime = lastUsedTime;
        this.location = location;
    }

    public String getBikeID() { return bikeID; }
    public void setBikeID(String bikeID) { this.bikeID = bikeID; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public int getBatteryLevel() { return batteryLevel; }
    public void setBatteryLevel(int batteryLevel) { this.batteryLevel = batteryLevel; }
    public LocalDateTime getLastUsedTime() { return lastUsedTime; }
    public void setLastUsedTime(LocalDateTime lastUsedTime) { this.lastUsedTime = lastUsedTime; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    @Override
    public String toString() {
        return "Bike{" + "bikeID='" + bikeID + '\'' + ", isAvailable=" + isAvailable +
                ", batteryLevel=" + batteryLevel + ", lastUsedTime=" + lastUsedTime +
                ", location='" + location + '\'' + '}';
    }
}

class ActiveRental {
    private String bikeID;
    private String userEmail;
    private LocalDateTime tripStartTime;

    public ActiveRental(String bikeID, String userEmail, LocalDateTime tripStartTime) {
        this.bikeID = bikeID;
        this.userEmail = userEmail;
        this.tripStartTime = tripStartTime;
    }

    public String getBikeID() { return bikeID; }
    public String getUserEmail() { return userEmail; }
    public LocalDateTime getTripStartTime() { return tripStartTime; }

    @Override
    public String toString() {
        return "ActiveRental{" + "bikeID='" + bikeID + '\'' + ", userEmail='" + userEmail + '\'' +
                ", tripStartTime=" + tripStartTime + '}';
    }
}

class RegisteredUsers {
    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private long cardNumber;
    private String cardExpiryDate;
    private String cardProvider;
    private int cvv;
    private String userType;
    private String[] lastThreeTrips;

    public RegisteredUsers(String fullName, String emailAddress, String dateOfBirth,
                           long cardNumber, String cardExpiryDate, String cardProvider,
                           int cvv, String userType, String[] lastThreeTrips) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cardProvider = cardProvider;
        this.cvv = cvv;
        this.userType = userType;
        this.lastThreeTrips = lastThreeTrips;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public long getCardNumber() { return cardNumber; }
    public void setCardNumber(long cardNumber) { this.cardNumber = cardNumber; }
    public String getCardExpiryDate() { return cardExpiryDate; }
    public void setCardExpiryDate(String cardExpiryDate) { this.cardExpiryDate = cardExpiryDate; }
    public String getCardProvider() { return cardProvider; }
    public void setCardProvider(String cardProvider) { this.cardProvider = cardProvider; }
    public int getCvv() { return cvv; }
    public void setCvv(int cvv) { this.cvv = cvv; }
    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }
    public String[] getLastThreeTrips() { return lastThreeTrips; }
    public void setLastThreeTrips(String[] lastThreeTrips) { this.lastThreeTrips = lastThreeTrips; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n===== Registered User Info =====");
        sb.append("\nFull Name: ").append(fullName);
        sb.append("\nEmail: ").append(emailAddress);
        sb.append("\nDOB: ").append(dateOfBirth);
        sb.append("\nUser Type: ").append(userType);
        sb.append("\nCard Provider: ").append(cardProvider);
        sb.append("\nCard Number: ****").append(String.valueOf(cardNumber).substring(String.valueOf(cardNumber).length()-4));
        sb.append("\nCard Expiry: ").append(cardExpiryDate);
        sb.append("\nCVV: ***");
        sb.append("\n\n--- Last 3 Trips ---");

        if (lastThreeTrips != null) {
            for (int i = 0; i < lastThreeTrips.length; i++) {
                sb.append("\nTrip ").append(i+1).append(": ").append(lastThreeTrips[i]);
            }
        } else {
            sb.append("\nNo trips yet.");
        }
        sb.append("\n================================\n");
        return sb.toString();
    }
}

class ERyderLog {
    private String log;
    private String event;
    private LocalDateTime timeStamp;

    public ERyderLog(String log, String event, LocalDateTime timeStamp) {
        this.log = log;
        this.event = event;
        this.timeStamp = timeStamp;
    }

    public String getLog() { return log; }
    public String getEvent() { return event; }
    public LocalDateTime getTimeStamp() { return timeStamp; }

    @Override
    public String toString() {
        return log + " - " + event + " - " + timeStamp;
    }
}

class BikeRequest {
    private String userEmail;
    private String location;
    private LocalDateTime requestTime;

    public BikeRequest(String userEmail, String location, LocalDateTime requestTime) {
        this.userEmail = userEmail;
        this.location = location;
        this.requestTime = requestTime;
    }

    public String getUserEmail() { return userEmail; }
    public String getLocation() { return location; }
    public LocalDateTime getRequestTime() { return requestTime; }

    @Override
    public String toString() {
        return "User: " + userEmail + " | Location: " + location + " | Requested: " + requestTime;
    }
}

class BikeDatabase {
    public static ArrayList<Bike> bikes = new ArrayList<>();

    static {
        bikes.add(new Bike("BIKE001", true, 85, LocalDateTime.now().minusHours(2), "Newark"));
        bikes.add(new Bike("BIKE002", true, 90, LocalDateTime.now().minusHours(1), "Jersey City"));
        bikes.add(new Bike("BIKE003", false, 50, LocalDateTime.now(), "Newark"));
        bikes.add(new Bike("BIKE004", true, 75, LocalDateTime.now().minusHours(3), "Hoboken"));
        bikes.add(new Bike("BIKE005", true, 80, LocalDateTime.now().minusHours(4), "Newark"));
    }
}

class BikeService {
    private Stack<ERyderLog> logStack = new Stack<>();
    private int logId = 1;

    private Queue<BikeRequest> bikeRequest = new ArrayDeque<>();

    public String validateLocation(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equalsIgnoreCase(location) && bike.isAvailable()) {
                System.out.println("Bikes are available at your requested location.");
                return bike.getBikeID();
            }
        }
        System.out.println("Sorry, no bikes available at your requested location. Please try again later.");
        return null;
    }

    public LocalDateTime reserveBike(String bikeID, String userEmail, String location) {
        if (bikeID == null) return null;

        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                if (!bike.isAvailable()) {
                    bikeRequest.add(new BikeRequest(userEmail, location, LocalDateTime.now()));
                    System.out.println("Bike is currently unavailable. Request added to queue.");
                    return null;
                }

                LocalDateTime startTime = LocalDateTime.now();
                bike.setAvailable(false);
                bike.setLastUsedTime(startTime);

                logStack.push(new ERyderLog(
                        "BR" + logId++,
                        "Bike " + bikeID + " rented from " + location + " by user " + userEmail,
                        startTime
                ));

                System.out.println("Reserving bike with ID: " + bikeID + ". Please follow instructions to find your bike.");
                return startTime;
            }
        }
        return null;
    }

    public void releaseBike(String bikeID) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());

                logStack.push(new ERyderLog(
                        "TR" + logId++,
                        "Bike " + bikeID + " trip ended and released",
                        LocalDateTime.now()
                ));

                if (!bikeRequest.isEmpty()) {
                    BikeRequest next = bikeRequest.poll();
                    reserveBike(bikeID, next.getUserEmail(), next.getLocation());
                    System.out.println("Bike reassigned to next user in queue: " + next.getUserEmail());
                }
                break;
            }
        }
    }

    public void viewSystemLogs() {
        System.out.println("\n===== ERyder System Logs =====");
        if (logStack.isEmpty()) {
            System.out.println("No logs yet.");
            return;
        }
        for (ERyderLog log : logStack) {
            System.out.println(log);
        }
    }

    public void viewRequestQueue() {
        System.out.println("\n===== Pending Bike Requests =====");
        if (bikeRequest.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }
        for (BikeRequest req : bikeRequest) {
            System.out.println(req);
        }
    }

    public void removeFirstRequest() {
        if (!bikeRequest.isEmpty()) {
            bikeRequest.poll();
            System.out.println("First request removed successfully.");
        } else {
            System.out.println("Queue is empty.");
        }
    }
}

class RentalService {
    private final LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();

    public void startRental(String bikeID, String email, LocalDateTime startTime) {
        ActiveRental rental = new ActiveRental(bikeID, email, startTime);
        activeRentalsList.add(rental);
    }

    public void terminateRental(String bikeID) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getBikeID().equals(bikeID)) {
                iterator.remove();
                break;
            }
        }
    }

    public void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals currently.");
            return;
        }
        for (ActiveRental rental : activeRentalsList) {
            System.out.println(rental);
        }
    }
}

class UserService {
    private final List<RegisteredUsers> registeredUsersList = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public void addNewUsers() {
        System.out.print("\nHow many users do you want to add: ");
        int count = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= count; i++) {
            System.out.println("\n----- Adding User " + i + " -----");

            System.out.print("Enter Full Name: ");
            String fullName = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter DOB (YYYY-MM-DD): ");
            String dob = sc.nextLine();

            System.out.print("Enter Card Number: ");
            long cardNum = Long.parseLong(sc.nextLine());

            System.out.print("Enter Card Provider (VISA/MasterCard/AE): ");
            String provider = sc.nextLine();

            System.out.print("Enter Card Expiry (MM/YY): ");
            String expiry = sc.nextLine();

            System.out.print("Enter CVV: ");
            int cvv = Integer.parseInt(sc.nextLine());

            System.out.print("Enter User Type (Regular/VIP): ");
            String type = sc.nextLine();

            String[] trips = new String[3];
            System.out.println("\n----- Enter Last 3 Trips -----");
            for (int t = 0; t < 3; t++) {
                System.out.println("\nTrip " + (t+1) + ":");
                System.out.print("Date (YYYY-MM-DD): ");
                String date = sc.nextLine();
                System.out.print("Start Location: ");
                String start = sc.nextLine();
                System.out.print("End Location: ");
                String end = sc.nextLine();
                System.out.print("Fare: ");
                String fare = sc.nextLine();
                System.out.print("Feedback (can be empty): ");
                String feedback = sc.nextLine();

                StringBuilder trip = new StringBuilder();
                trip.append("Date: ").append(date)
                        .append(", From: ").append(start)
                        .append(", To: ").append(end)
                        .append(", Fare: ").append(fare)
                        .append(", Feedback: ").append(feedback.isEmpty() ? "None" : feedback);
                trips[t] = trip.toString();
            }

            RegisteredUsers user = new RegisteredUsers(fullName, email, dob, cardNum, expiry, provider, cvv, type, trips);
            registeredUsersList.add(user);
            System.out.println("User " + i + " added successfully!");
        }
    }

    public void viewRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("\nNo registered users to display.");
            return;
        }
        System.out.println("\n===== All Registered Users =====");
        for (RegisteredUsers user : registeredUsersList) System.out.println(user);
    }

    public void removeRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("\nNo users to remove.");
            return;
        }
        System.out.print("\nEnter email of user to remove: ");
        String email = sc.nextLine();
        boolean found = false;

        Iterator<RegisteredUsers> iterator = registeredUsersList.iterator();
        while (iterator.hasNext()) {
            RegisteredUsers user = iterator.next();
            if (user.getEmailAddress().equals(email)) {
                iterator.remove();
                found = true;
                System.out.println("User removed successfully!");
                break;
            }
        }
        if (!found) System.out.println("User with this email not found.");
    }

    public void updateRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("\nNo users to update.");
            return;
        }
        System.out.print("\nEnter email of user to update: ");
        String email = sc.nextLine();
        RegisteredUsers target = null;

        for (RegisteredUsers u : registeredUsersList) {
            if (u.getEmailAddress().equals(email)) {
                target = u;
                break;
            }
        }

        if (target == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("\n----- Update User Info (Press ENTER to keep old value) -----");
        System.out.print("New Full Name: ");
        String fn = sc.nextLine();
        if (!fn.isEmpty()) target.setFullName(fn);

        System.out.print("New Email: ");
        String em = sc.nextLine();
        if (!em.isEmpty()) target.setEmailAddress(em);

        System.out.print("New DOB: ");
        String dob = sc.nextLine();
        if (!dob.isEmpty()) target.setDateOfBirth(dob);

        System.out.print("New Card Provider: ");
        String p = sc.nextLine();
        if (!p.isEmpty()) target.setCardProvider(p);

        System.out.print("New Card Expiry: ");
        String exp = sc.nextLine();
        if (!exp.isEmpty()) target.setCardExpiryDate(exp);

        System.out.print("New User Type: ");
        String ut = sc.nextLine();
        if (!ut.isEmpty()) target.setUserType(ut);

        System.out.print("New Card Number (0 = no change): ");
        String cn = sc.nextLine();
        if (!cn.equals("0")) target.setCardNumber(Long.parseLong(cn));

        System.out.print("New CVV (0 = no change): ");
        String cv = sc.nextLine();
        if (!cv.equals("0")) target.setCvv(Integer.parseInt(cv));

        System.out.println("User updated successfully!");
    }
}

class AdminPanel {
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
            System.out.println("7. View System Logs");       
            System.out.println("8. Manage Bike Requests");  
            System.out.println("9. Exit");
            System.out.print("Please enter your choice: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1": userService.addNewUsers(); break;
                case "2": userService.viewRegisteredUsers(); break;
                case "3": userService.removeRegisteredUsers(); break;
                case "4": userService.updateRegisteredUsers(); break;
                case "5": simulateRental(); break;
                case "6": new BracketChecker().checkBrackets(); break;
                case "7": bikeService.viewSystemLogs(); break;
                case "8": manageRequests(); break;
                case "9":
                    System.out.println("Exiting Admin Panel...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void manageRequests() {
        while (true) {
            System.out.println("\n===== Manage Pending Requests =====");
            System.out.println("1. View Queue");
            System.out.println("2. Remove First Request");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");
            String c = sc.nextLine();

            if (c.equals("1")) bikeService.viewRequestQueue();
            else if (c.equals("2")) bikeService.removeFirstRequest();
            else if (c.equals("3")) break;
            else System.out.println("Invalid choice.");
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
        if (isRegistered) System.out.println("Welcome back, " + email + "!");
        else {
            System.out.println("You are not a registered user. Please register.");
            userRegistration.registration();
        }

        String bikeID = bikeService.validateLocation(location);
        if (bikeID == null) return;

        System.out.println("\n----- Simulating E-Bike Reservation... -----");
        LocalDateTime startTime = bikeService.reserveBike(bikeID, email, location);
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

class BracketChecker {
    public void checkBrackets() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a bracket string to check: ");
        String input = sc.nextLine();

        Deque<Character> stack = new ArrayDeque<>();
        boolean balanced = true;

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    balanced = false;
                    break;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    balanced = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) balanced = false;

        System.out.println(balanced ? "Brackets are BALANCED and paired correctly!" : "Brackets are NOT balanced!");
    }

    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}

class Feedback {
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void analyseFeedback(boolean isConcatenation, String sent1, String sent2, String sent3, String sent4, String sent5) {
        completeFeedback = isConcatenation ? (sent1+sent2+sent3+sent4+sent5) :
                new StringBuilder().append(sent1).append(sent2).append(sent3).append(sent4).append(sent5).toString();
        longFeedback = completeFeedback.length() > 500;
        createReviewID();
    }

    private void createReviewID() {
        String namePart = (firstName+lastName).substring(2,6).toUpperCase();
        String feedbackPart = completeFeedback.substring(10,15).toLowerCase().replace(" ","");
        reviewID = namePart + feedbackPart + completeFeedback.length() + "_" + System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "=== Feedback Info ===" + "\nFirst Name: " + firstName + "\nLast Name: " + lastName +
                "\nEmail: " + email + "\nComplete Feedback: " + completeFeedback +
                "\nIs Long Feedback: " + longFeedback + "\nReview ID: " + reviewID + "\n======================";
    }
}

class UserRegistration {
    private static final double VIP_BASE_FEE = 100.0;
    private String fullName, emailAddress, dateOfBirth, cardProvider, cardExpiryDate, userType;
    private long cardNumber;
    private int cvv;
    private double feeToCharge;
    private final Scanner sc = new Scanner(System.in);

    public void registration() {
        System.out.println("\n===== ERyder Registration =====");
        System.out.print("1. Regular User\n2. VIP User\nEnter choice: ");
        userType = sc.nextLine().equals("1") ? "Regular User" : "VIP User";

        System.out.print("Full Name: "); fullName = sc.nextLine();
        System.out.print("Email: "); emailAddress = sc.nextLine();
        if (!emailAddress.contains("@") || !emailAddress.contains(".")) { System.out.println("Invalid email!"); registration(); }

        System.out.print("DOB (YYYY-MM-DD): "); dateOfBirth = sc.nextLine();
        LocalDate dob = LocalDate.parse(dateOfBirth);
        int age = Period.between(dob, LocalDate.now()).getYears();
        if (age <=12 || age>120) { System.out.println("Age not allowed"); System.exit(0); }

        System.out.print("Card Number: "); cardNumber = sc.nextLong();
        System.out.print("Expiry (MM/YY): "); cardExpiryDate = sc.next();
        System.out.print("CVV: "); cvv = sc.nextInt();
        sc.nextLine();

        chargeFees(age, dob);
        System.out.printf("Charged: %.2f%n", feeToCharge);
    }

    private void chargeFees(int age, LocalDate dob) {
        boolean birthday = dob.getMonth()==LocalDate.now().getMonth() && dob.getDayOfMonth()==LocalDate.now().getDayOfMonth();
        if (userType.equals("VIP User") && age>12 && age<=18) {
            feeToCharge = birthday ? VIP_BASE_FEE*0.75 : VIP_BASE_FEE*0.8;
        } else feeToCharge = VIP_BASE_FEE;
    }
}

class ERyder {
    private String bikeId;
    private int battery;
    private boolean available;
    private double distance;

    public ERyder(String bikeId, int battery, boolean available, double distance) {
        this.bikeId = bikeId; this.battery = battery; this.available = available; this.distance = distance;
    }
}

public class Main {
    public static void main(String[] args) {
        new AdminPanel().userManagementOptions();
    }
}