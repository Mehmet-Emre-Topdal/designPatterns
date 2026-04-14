package abstractfactory;

/**
 * ABSTRACT FACTORY PATTERN - Concrete Factory 1
 * -----------------------------------------------
 * Windows ailesinin tüm ürünlerini üretir.
 * Garanti: buradan çıkan Button ve Checkbox HER ZAMAN uyumlu
 * (hepsi Windows). Karışık aile (Win button + Mac checkbox) olmaz.
 */
public class WindowsFactory implements GUIFactory {

    /**
     * TODO 7: createButton() override et, WindowsButton döndür.
     */
    // BURAYA YAZ:
    @Override
    public WindowsButton createButton() {
        return new WindowsButton();
    }

    /**
     * TODO 8: createCheckbox() override et, WindowsCheckbox döndür.
     */
    // BURAYA YAZ:
    @Override
    public WindowsCheckbox createCheckbox() {
        return new WindowsCheckbox();
    }

}
