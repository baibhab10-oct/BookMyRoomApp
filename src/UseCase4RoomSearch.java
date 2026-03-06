import java.util.Map;

public class UseCase4RoomSearch {

    record Room(String type, int beds, int size, double price) {}

    public static void main(String[] args) {
        Map<String, Integer> inventory = Map.of(
                "Single", 5,
                "Double", 3,
                "Suite", 2
        );

        Room[] rooms = {
                new Room("Single", 1, 350, 1500.0),
                new Room("Double", 2, 450, 2500.0),
                new Room("Suite", 3, 750, 5000.0)
        };

        System.out.println("Room Search\n");

        for (Room room : rooms) {
            Integer available = inventory.get(room.type());
            if (available != null && available > 0) {
                System.out.printf("%s Room:%n", room.type());
                System.out.printf("Beds: %d%n", room.beds());
                System.out.printf("Size: %d sqft%n", room.size());
                System.out.printf("Price per night: %.1f%n", room.price());
                System.out.printf("Available: %d%n%n", available);
            }
        }
    }
}