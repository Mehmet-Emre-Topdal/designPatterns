package strategy;

/**
 * STRATEGY PATTERN - Concrete Strategy
 * --------------------------------------
 * Kripto ödeme komisyon hesaplaması.
 */
public class CryptoStrategy implements PaymentStrategy {

    /**
     * TODO 4: calculateFee() metodunu override et.
     * - Komisyon: tutarın %1'i
     */
    // BURAYA YAZ:
    @Override
    public double calculateFee(double amount) {
        return amount * 0.01;
    }

}
