package abstractfactory;

/**
 * ABSTRACT FACTORY PATTERN - Concrete Product B1
 * ------------------------------------------------
 * Windows ailesine ait Checkbox implementasyonu.
 */
public class WindowsCheckbox implements Checkbox {

    /**
     * TODO 2: render() metodunu override et.
     * "Windows checkbox rendered" yazdırsın.
     */
    // BURAYA YAZ:
    @Override
    public void render() {
        System.out.println("Windows checkbox rendered");
    }

}
