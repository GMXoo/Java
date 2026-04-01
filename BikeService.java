import java.time.LocalDateTime;

public class BikeService {
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

    public LocalDateTime reserveBike(String bikeID) {
        if (bikeID == null) return null;

        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                LocalDateTime startTime = LocalDateTime.now();
                bike.setAvailable(false);
                bike.setLastUsedTime(startTime);
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
                break;
            }
        }
    }
}