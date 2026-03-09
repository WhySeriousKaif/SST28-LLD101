public class StaffDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double subtotal, int distinctLines) {
        if (distinctLines >= 3)
            return 15.0;
        return 5.0;
    }
}
