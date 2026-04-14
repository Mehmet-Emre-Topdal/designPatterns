package proxy;

/**
 * PROXY PATTERN - Proxy
 * ----------------------
 * RealImage'ın önüne geçer; nesneyi yalnızca gerçekten gerektiğinde oluşturur.
 * Bu tekniğe "Lazy Initialization" (Tembel Yükleme) denir.
 *
 * GÖREV: Aşağıdaki eksikleri tamamla.
 */
public class ProxyImage implements Image {

    private RealImage realImage; // başta null — henüz yüklenmedi
    private final String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    /**
     * TODO 3: display() metodunu override et.
     *
     * Mantık:
     * - Eğer realImage null ise → yeni RealImage(filename) oluştur
     * - Her durumda → realImage.display() çağır
     *
     * Böylece RealImage yalnızca ilk display() çağrısında yüklenir,
     * sonraki çağrılarda önbellekteki nesne kullanılır.
     */
    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }

        realImage.display();
    }
}
