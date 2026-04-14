package observer;

/**
 * OBSERVER PATTERN - Observer Arayüzü
 * -------------------------------------
 * Amaç: Bir nesnenin durumu değiştiğinde,
 *       ona bağlı tüm nesnelerin otomatik bilgilendirilmesi.
 *
 * GÖREV: Aşağıdaki metot imzasını tanımla.
 */
public interface EventListener {

    // TODO 1: update(String message) adında bir metot imzası tanımla.
    //         Dinleyici bu metot aracılığıyla olaydan haberdar olacak.
    void update(String message);

    String getName();

}
