package strategy;

/**
 * SIMPLE FACTORY — Strategy üretimi için.
 * ----------------------------------------
 * Amaç: String girdiyi (kullanıcı seçimi) uygun PaymentStrategy
 *       nesnesine çevirmek. if/else / switch sadece BURADA yaşar.
 *       Sistemin geri kalanı string görmez, sadece PaymentStrategy ile çalışır.
 *
 * Not: Bu bir "Simple Factory"dir — GoF'ta değil, yaygın bir idiom.
 *      Bizim factory/ klasöründeki Factory Method'dan farklı:
 *      orada alt sınıflar karar verir, burada switch karar verir.
 */
public class PaymentStrategyFactory {

    /**
     * TODO 8: create(String type) metodunu tamamla.
     *         - "credit" → new CreditCardStrategy()
     *         - "paypal" → new PayPalStrategy()
     *         - "crypto" → new CryptoStrategy()
     *         - Bilinmeyen tip → IllegalArgumentException fırlat.
     *
     * (İpucu: switch expression kullanabilirsin.)
     */
    public static PaymentStrategy create(String type) {
        // BURAYA YAZ:
        return null;
    }
}
