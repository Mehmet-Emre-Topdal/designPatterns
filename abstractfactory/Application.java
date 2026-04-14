package abstractfactory;

/**
 * ABSTRACT FACTORY PATTERN - Client
 * -----------------------------------
 * Client (Application) SADECE abstract tiplerle çalışır:
 *   - GUIFactory (arayüz)
 *   - Button, Checkbox (arayüzler)
 *
 * Windows veya Mac olduğunu BİLMEZ. Dışarıdan hangi factory
 * verilirse o ailenin ürünlerini üretir ve kullanır.
 *
 * Kazanç: Yeni bir platform eklemek (LinuxFactory) için bu sınıfa
 *         DOKUNULMAZ. Sadece yeni bir GUIFactory implementasyonu yazılır.
 */
public class Application {

    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void render() {
        button.render();
        checkbox.render();
    }
}
