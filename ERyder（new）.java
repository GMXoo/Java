public class ERyder {
    public static final String COMPANY_NAME = "eRyder";
    public static final double BASE_FARE = 1.0;
    public static final double PER_MINUTE_FARE = 0.5;

    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;

    private final String LINKED_ACCOUNT;
    private final String LINKED_PHONE_NUMBER;

    private int totalUsageInMinutes;
    private double totalFare;

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = "";
        this.LINKED_PHONE_NUMBER = "";
    }

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven,
                  String linkedAccount, String linkedPhoneNumber) {
        this.bikeID = bikeID;
        setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = linkedAccount;
        this.LINKED_PHONE_NUMBER = linkedPhoneNumber;
    }

    public void ride() {
        if (isAvailable && batteryLevel > 0) {
            System.out.println("The bike is available for riding.");
        } else {
            System.out.println("The bike is not available.");
        }
    }

    public void printBikeDetails() {
        System.out.println("=== Bike Details ===");
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Is Available: " + isAvailable);
        System.out.println("Total KM Driven: " + kmDriven + "km");
        System.out.println("Linked Account: " + LINKED_ACCOUNT);
        System.out.println("Linked Phone Number: " + LINKED_PHONE_NUMBER);
        System.out.println("====================");
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("Error: Battery level must be between 0 and 100. Setting to 0.");
            this.batteryLevel = 0;
        }
    }

    public String getBikeID() { return bikeID; }
    public int getBatteryLevel() { return batteryLevel; }
    public boolean isAvailable() { return isAvailable; }
    public double getKmDriven() { return kmDriven; }
    public String getLINKED_ACCOUNT() { return LINKED_ACCOUNT; }
    public String getLINKED_PHONE_NUMBER() { return LINKED_PHONE_NUMBER; }

    private double calculateFare(int usageInMinutes) {
        this.totalUsageInMinutes = usageInMinutes;
        this.totalFare = BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
        return this.totalFare;
    }

    public void printRideDetails(int usageInMinutes) {
        double fare = calculateFare(usageInMinutes);

        System.out.println("=== Ride Details ===");
        System.out.println("Company Name: " + COMPANY_NAME);
        System.out.println("Linked Account: " + LINKED_ACCOUNT);
        System.out.println("Linked Phone Number: " + LINKED_PHONE_NUMBER);
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Usage Time: " + usageInMinutes + " minutes");
        System.out.println("Total Fare: $" + String.format("%.2f", fare));
        System.out.println("====================");
    }
}

