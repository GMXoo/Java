import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserService {
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