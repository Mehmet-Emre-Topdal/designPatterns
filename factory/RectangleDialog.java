package factory;

/**
 * FACTORY METHOD PATTERN - Concrete Creator
 * -------------------------------------------
 * Bu sınıf da ShapeDialog'u extend eder, ama FARKLI bir ürün üretir.
 * Patern'in gücü burada: aynı iş akışı (renderShape),
 * farklı ürün (Rectangle) — switch/if yok.
 */
public class RectangleDialog extends ShapeDialog {

    /**
     * TODO 4: createShape() metodunu override et.
     * - Yeni bir Rectangle döndürsün.
     */
    // BURAYA YAZ:
    @Override
    protected Shape createShape() {
        return new Rectangle();
    }

}
