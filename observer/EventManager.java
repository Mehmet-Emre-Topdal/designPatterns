package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * OBSERVER PATTERN - Subject (Yayıncı)
 * --------------------------------------
 * Dinleyicileri yönetir ve olayları onlara iletir.
 *
 * GÖREV: Aşağıdaki metodları tamamla.
 */
public class EventManager {

    // Kayıtlı dinleyicilerin listesi — tamamlanmış, dokunma.
    private final List<EventListener> listeners = new ArrayList<>();
    /**
     * TODO 4: subscribe() metodunu tamamla.
     *         Gelen dinleyiciyi listeye ekle.
     */
    public void subscribe(EventListener listener) {
        listeners.add(listener);
    }

    /**
     * TODO 5: unsubscribe() metodunu tamamla.
     *         Gelen dinleyiciyi listeden çıkar.
     */
    public void unsubscribe(EventListener listener) {
        listeners.remove(listener);
        notifyListeners(listener.getName()+" removed");
    }

    /**
     * TODO 6: notifyAll() metodunu tamamla.
     *         Listedeki her dinleyicinin update() metodunu çağır.
     *
     * NOT: Java'da notifyAll() reserved olduğundan metot adı
     *      notifyListeners() olarak kullanılıyor.
     */
    public void notifyListeners(String message) {
        listeners.forEach(listener -> listener.update(message));
    }

}
