public class DefaultDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double subtotal, int distinctLines) {
        return 0.0;
    }
}
