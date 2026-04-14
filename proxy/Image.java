package proxy;

/**
 * PROXY PATTERN - Subject Arayüzü
 * ---------------------------------
 * Amaç: Gerçek nesneye erişimi kontrol eden bir vekil (proxy) sağlamak.
 * Lazy loading, önbellekleme, erişim kontrolü gibi durumlarda kullanılır.
 */
public interface Image {

    // TODO 1: display() adında bir metot imzası tanımla (void, parametre yok).
    void display();

}
