public class UseCase3InventoryStatus {

    static class FacilityInventory {

        private static FacilityInventory instance;

        private int singleRoomCount = 5;
        private int doubleRoomCount = 3;
        private int suiteRoomCount = 2;

        private FacilityInventory() {
        }

        public static FacilityInventory getInstance() {
            if (instance == null) {
                instance = new FacilityInventory();
            }
            return instance;
        }

        public int getSingleRoomCount() {
            return singleRoomCount;
        }

        public int getDoubleRoomCount() {
            return doubleRoomCount;
        }

        public int getSuiteRoomCount() {
            return suiteRoomCount;
        }
    }

    static abstract class Room {

        protected int numberOfBeds;
        protected int squareFeet;
        protected double pricePerNight;

        public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
            this.numberOfBeds = numberOfBeds;
            this.squareFeet = squareFeet;
            this.pricePerNight = pricePerNight;
        }

        public void displayRoomDetails() {
            System.out.println("Beds: " + numberOfBeds);
            System.out.println("Size: " + squareFeet + " sqft");
            System.out.println("Price per night: " + pricePerNight);
        }
    }

    static class SingleRoom extends Room {
        public SingleRoom() {
            super(1, 250, 1500.0);
        }
    }

    static class DoubleRoom extends Room {
        public DoubleRoom() {
            super(2, 400, 2500.0);
        }
    }

    static class SuiteRoom extends Room {
        public SuiteRoom() {
            super(3, 750, 5000.0);
        }
    }

    public static void main(String[] args) {

        FacilityInventory inventory = FacilityInventory.getInstance();

        System.out.println("Hotel Room Inventory Status");

        System.out.println("\nSingle Room:");
        Room single = new SingleRoom();
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getSingleRoomCount());

        System.out.println("\nDouble Room:");
        Room dbl = new DoubleRoom();
        dbl.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getDoubleRoomCount());

        System.out.println("\nSuite Room:");
        Room suite = new SuiteRoom();
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getSuiteRoomCount());
    }
}