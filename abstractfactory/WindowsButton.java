package abstractfactory;

/**
 * ABSTRACT FACTORY PATTERN - Concrete Product A1
 * ------------------------------------------------
 * Windows ailesine ait Button implementasyonu.
 */
public class WindowsButton implements Button {

    /**
     * TODO 1: render() metodunu override et.
     * "Windows button rendered" yazdırsın.
     */
    // BURAYA YAZ:
    @Override
    public void render() {
        System.out.println("Windows button rendered");
    }

}
