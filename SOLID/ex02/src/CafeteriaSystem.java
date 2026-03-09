import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceStore store;
    private final PriceCalculator priceCalculator;
    private final InvoicePrinter printer;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(InvoiceStore store, PriceCalculator priceCalculator, InvoicePrinter printer) {
        this.store = store;
        this.priceCalculator = priceCalculator;
        this.printer = printer;
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(DiscountStrategy discountStrategy, TaxStrategy taxStrategy, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        double subtotal = priceCalculator.calculateSubtotal(lines, menu);
        double taxPct = taxStrategy.getTaxRate();
        double tax = priceCalculator.calculateTax(subtotal, taxPct);
        double discount = discountStrategy.getDiscount(subtotal, lines.size());
        double total = subtotal + tax - discount;

        String printable = printer.format(invId, lines, menu, subtotal, taxPct, tax, discount, total);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
