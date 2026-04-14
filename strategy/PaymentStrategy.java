package strategy;

/**
 * STRATEGY PATTERN - Strategy (Arayüz)
 * -------------------------------------
 * Farklı algoritmaların ORTAK kontratı.
 * Her concrete strategy bu metodu kendi mantığıyla implement eder.
 *
 * Amaç: Bir algoritmayı nesneye çevirip runtime'da değiştirilebilir kılmak.
 */
public interface PaymentStrategy {

    /**
     * TODO 1: calculateFee(double amount) imzasını tanımla.
     * - Dönüş tipi: double
     * - Verilen tutar için ödeme komisyonunu hesaplayacak.
     *
     * (İpucu: double calculateFee(double amount);)
     */
    // BURAYA YAZ:

    double calculateFee(double amount);

}
