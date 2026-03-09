public class StudentDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double subtotal, int distinctLines) {
        if (subtotal >= 180.0)
            return 10.0;
        return 0.0;
    }
}
