public interface DiscountStrategy {
    double getDiscount(double subtotal, int distinctLines);
}
