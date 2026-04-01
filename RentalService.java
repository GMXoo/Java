import java.util.Iterator;
import java.util.LinkedList;

public class RentalService {
    private final LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();

    public void startRental(String bikeID, String email, java.time.LocalDateTime startTime) {
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