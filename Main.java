import builder.Person;
import builder.PersonBuilder;
import factory.CircleDialog;
import factory.RectangleDialog;
import factory.ShapeDialog;
import observer.ConcreteListener;
import observer.EventManager;
import proxy.Image;
import proxy.ProxyImage;
import singleton.Singleton;
import strategy.CreditCardStrategy;
import strategy.CryptoStrategy;
import strategy.PayPalStrategy;
import strategy.PaymentContext;

/**
 * ==========================================
 * DESIGN PATTERNS - Java Öğrenim Projesi
 * ==========================================
 *
 * Klasör Yapısı:
 * singleton/ → Singleton Pattern
 * factory/ → Factory Method Pattern
 * builder/ → Builder Pattern
 * observer/ → Observer Pattern
 * proxy/ → Proxy Pattern
 *
 * Her klasörde TODO yorum satırları var.
 * Eksik metodları ve sınıfları sen tamamla!
 *
 * Derleme: javac **\/*.java
 * Çalıştır: java Main
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("=== 1. SINGLETON PATTERN ===");
        // singleton/Singleton.java dosyasını tamamladıktan sonra:
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("Aynı nesne mi? " + (s1 == s2));

        System.out.println("\n=== 2. FACTORY METHOD PATTERN ===");
        // factory/ShapeDialog.java, CircleDialog.java, RectangleDialog.java tamamlandıktan sonra:
        ShapeDialog circleDialog = new CircleDialog();
        ShapeDialog rectDialog = new RectangleDialog();
        circleDialog.renderShape();
        rectDialog.renderShape();

        System.out.println("\n=== 3. BUILDER PATTERN ===");
        // builder/PersonBuilder.java dosyasını tamamladıktan sonra:
        Person person = new PersonBuilder()
                .setName("Ali")
                .setAge(25)
                .setEmail("ali@email.com")
                .build();
        System.out.println(person);

        System.out.println("\n=== 4. OBSERVER PATTERN ===");
        // observer/ dosyasını tamamladıktan sonra:
        EventManager manager = new EventManager();
        ConcreteListener listener = new ConcreteListener("Listener1");
        ConcreteListener listener2 = new ConcreteListener("Listener1");
        manager.subscribe(listener);
        manager.subscribe(listener2);
        manager.notifyListeners("Bir olay gerçekleşti!");
        manager.unsubscribe(listener);

        System.out.println("\n=== 5. PROXY PATTERN ===");
        Image image = new ProxyImage("fotograf.jpg");
        image.display(); // İlk çağrıda yükler
        image.display(); // Önbellekten gösterir

        System.out.println("\n=== 6. STRATEGY PATTERN ===");
        // strategy/ dosyaları tamamlandıktan sonra:
        PaymentContext ctx = new PaymentContext();

        ctx.setStrategy(new CreditCardStrategy());
        ctx.pay(100);

        ctx.setStrategy(new PayPalStrategy());
        ctx.pay(100);

        ctx.setStrategy(new CryptoStrategy());
        ctx.pay(100);
    }
}
