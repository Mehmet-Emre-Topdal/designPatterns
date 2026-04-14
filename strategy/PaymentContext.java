package strategy;

/**
 * STRATEGY PATTERN - Context
 * ----------------------------
 * Context, bir strategy'yi TUTAR ve onu kullanır.
 * KENDİSİ algoritma yazmaz — sadece tutarlıa strategy'ye delege eder.
 *
 * Gücü: strategy runtime'da değiştirilebilir (setStrategy).
 */
public class PaymentContext {

    /**
     * TODO 5: PaymentStrategy tipinde private bir alan tanımla.
     * İsim: strategy
     */
    // BURAYA YAZ:
    PaymentStrategy strategy;

    /**
     * TODO 6: setStrategy(PaymentStrategy strategy) metodunu yaz.
     * - Bu metot sayesinde context'in davranışı runtime'da değişebilir.
     */
    // BURAYA YAZ:
    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * TODO 7: pay(double amount) metodunu yaz.
     * - strategy.calculateFee(amount) çağır, sonucu bir değişkene ata.
     * - "Ödeme: <amount>, Komisyon: <fee>" şeklinde yazdır.
     */
    // BURAYA YAZ:
    public void pay(double amount) {
        var result = strategy.calculateFee(amount);
        System.out.println(amount + " " + result);
    }

}
