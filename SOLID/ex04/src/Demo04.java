import java.util.*;

public class Demo04 {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");

        FakeBookingRepo repo = new FakeBookingRepo();
        RoomPriceCalculator roomCalc = new StandardRoomPricing();
        AddOnPriceCalculator addOnCalc = new StandardAddOnPricing();

        HostelFeeCalculator calc = new HostelFeeCalculator(repo, roomCalc, addOnCalc);

        BookingRequest req = new BookingRequest(
                LegacyRoomTypes.DOUBLE,
                Arrays.asList(AddOn.LAUNDRY, AddOn.MESS));

        calc.process(req);
    }
}
