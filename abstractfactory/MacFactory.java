package abstractfactory;

/**
 * ABSTRACT FACTORY PATTERN - Concrete Factory 2
 * -----------------------------------------------
 * Mac ailesinin tüm ürünlerini üretir.
 */
public class MacFactory implements GUIFactory {

    /**
     * TODO 9: createButton() override et, MacButton döndür.
     */
    // BURAYA YAZ:
    public MacButton createButton() {
        return new MacButton();
    }

    /**
     * TODO 10: createCheckbox() override et, MacCheckbox döndür.
     */
    // BURAYA YAZ:
    public MacCheckbox createCheckbox() {
        return new MacCheckbox();
    }
}
