import java.util.*;

public class Demo02 {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");

        InvoiceStore store = new FileStore();
        PriceCalculator priceCalculator = new PriceCalculator();
        InvoicePrinter printer = new InvoicePrinter();

        CafeteriaSystem sys = new CafeteriaSystem(store, priceCalculator, printer);
        sys.addToMenu(new MenuItem("M1", "Veg Thali", 80.0));
        sys.addToMenu(new MenuItem("M2", "Coffee", 30.0));

        List<OrderLine> order = Arrays.asList(
                new OrderLine("M1", 2),
                new OrderLine("M2", 1));

        sys.checkout(new StudentDiscount(), new StudentTax(), order);
    }
}
