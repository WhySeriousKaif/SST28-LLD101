import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

/**
 * Demonstrates the power of immutability and builders.
 */
public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        // 1. Create a ticket
        IncidentTicket t1 = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Initial Ticket (t1): " + t1);

        // 2. "Update" through service (returns new object)
        IncidentTicket t2 = service.assign(t1, "agent@example.com");
        IncidentTicket t3 = service.escalateToCritical(t2);

        System.out.println("\nAfter 'mutations':");
        System.out.println("t1 (unchanged): " + t1);
        System.out.println("t2 (assigned):  " + t2);
        System.out.println("t3 (escalated): " + t3);

        System.out.println("\nSame objects check:");
        System.out.println("t1 == t2 ? " + (t1 == t2));
        System.out.println("t2 == t3 ? " + (t2 == t3));

        // 3. Demonstrate safety from external list mutation
        try {
            List<String> tags = t3.getTags();
            System.out.println("\nAttempting to modify tags list directly...");
            tags.add("HACKED_FROM_OUTSIDE");
        } catch (UnsupportedOperationException e) {
            System.out.println("Caught expected exception: Modification of unmodifiable collection blocked!");
        }

        // 4. Demonstrate Validation
        System.out.println("\nTesting Validation:");
        try {
            IncidentTicket.builder()
                    .id("INVALID ID") // contains space
                    .reporterEmail("not-an-email")
                    .title("")
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected validation error: " + e.getMessage());
        }

        System.out.println("\nSUCCESS: IncidentTicket is now robustly immutable!");
    }
}
