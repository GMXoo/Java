import java.time.LocalDateTime;
import java.util.ArrayList;

public class BikeDatabase {
    public static ArrayList<Bike> bikes = new ArrayList<>();

    static {
        bikes.add(new Bike("BIKE001", true, 85, LocalDateTime.now().minusHours(2), "Newark"));
        bikes.add(new Bike("BIKE002", true, 90, LocalDateTime.now().minusHours(1), "Jersey City"));
        bikes.add(new Bike("BIKE003", false, 50, LocalDateTime.now(), "Newark"));
        bikes.add(new Bike("BIKE004", true, 75, LocalDateTime.now().minusHours(3), "Hoboken"));
        bikes.add(new Bike("BIKE005", true, 80, LocalDateTime.now().minusHours(4), "Newark"));
    }
}