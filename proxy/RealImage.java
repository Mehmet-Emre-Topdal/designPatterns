package proxy;

/**
 * PROXY PATTERN - RealSubject
 * ----------------------------
 * Gerçek iş mantığını içerir. Yüklenmesi "pahalı" bir nesneyi temsil eder.
 * Bu sınıf tamamlanmış — sadece incele.
 */
public class RealImage implements Image {

    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk(); // nesne oluşturulunca hemen yüklenir
    }

    private void loadFromDisk() {
        System.out.println("Diskten yükleniyor: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Gösteriliyor: " + filename);
    }
}
