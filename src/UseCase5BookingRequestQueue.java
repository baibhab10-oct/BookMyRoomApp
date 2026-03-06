import java.util.ArrayDeque;
import java.util.Queue;

public class UseCase5BookingRequestQueue {

    record Reservation(String guestName, String roomType) {}

    static class BookingQueue {
        private final Queue<Reservation> requests = new ArrayDeque<>();

        public void addRequest(Reservation res) {
            requests.offer(res);
        }

        public Reservation getNextRequest() {
            return requests.poll();
        }

        public boolean hasPending() {
            return !requests.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("Booking Request Queue");

        BookingQueue bookingQueue = new BookingQueue();

        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Subha", "Double"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Suite"));

        while (bookingQueue.hasPending()) {
            Reservation res = bookingQueue.getNextRequest();
            System.out.printf("Processing booking for Guest: %s, Room Type: %s%n",
                    res.guestName(), res.roomType());
        }
    }
}