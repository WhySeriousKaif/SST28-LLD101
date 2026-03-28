interface PricingStrategy {
    double calculate(double hours);
}

class HourlyPricing implements PricingStrategy {
    @Override
    public double calculate(double hours) {
        return hours * 10.0;
    }
}

class FlatPricing implements PricingStrategy {
    @Override
    public double calculate(double hours) {
        return 25.0; // Flat rate regardless of duration
    }
}

class WeekendPricing implements PricingStrategy {
    @Override
    public double calculate(double hours) {
        return hours * 15.0; // Higher rate for weekends
    }
}

class FeeCalculator {
    private PricingStrategy strategy;

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateFee(double hours) {
        return strategy.calculate(hours);
    }
}

public class Demo {
    public static void main(String[] args) {
        FeeCalculator calculator = new FeeCalculator();

        System.out.println("Using Hourly Pricing (4 hours):");
        calculator.setStrategy(new HourlyPricing());
        System.out.println("Fee: $" + calculator.calculateFee(4));

        System.out.println("\nUsing Flat Pricing (4 hours):");
        calculator.setStrategy(new FlatPricing());
        System.out.println("Fee: $" + calculator.calculateFee(4));

        System.out.println("\nUsing Weekend Pricing (4 hours):");
        calculator.setStrategy(new WeekendPricing());
        System.out.println("Fee: $" + calculator.calculateFee(4));
    }
}
