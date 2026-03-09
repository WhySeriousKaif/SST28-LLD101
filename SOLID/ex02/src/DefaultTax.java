public class DefaultTax implements TaxStrategy {
    @Override
    public double getTaxRate() {
        return 8.0;
    }
}
