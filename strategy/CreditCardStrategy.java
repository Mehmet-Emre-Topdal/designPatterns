package strategy;

/**
 * STRATEGY PATTERN - Concrete Strategy
 * --------------------------------------
 * Kredi kartı komisyon hesaplaması.
 */
public class CreditCardStrategy implements PaymentStrategy {

    /**
     * TODO 2: calculateFee() metodunu override et.
     * - Komisyon: tutarın %3'ü
     * - Örn: amount * 0.03 döndür.
     */
    // BURAYA YAZ:
    @Override
    public double calculateFee(double amount) {
        return amount * 0.03;
    }

}
