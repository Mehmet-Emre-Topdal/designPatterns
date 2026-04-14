package strategy;

/**
 * STRATEGY PATTERN - Concrete Strategy
 * --------------------------------------
 * PayPal komisyon hesaplaması.
 */
public class PayPalStrategy implements PaymentStrategy {

    /**
     * TODO 3: calculateFee() metodunu override et.
     * - Komisyon: tutarın %5'i
     */
    // BURAYA YAZ:
    @Override
    public double calculateFee(double amount) {
        return amount * 0.05;
    }

}
