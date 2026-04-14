package factory;

/**
 * FACTORY METHOD PATTERN - Concrete Creator
 * -------------------------------------------
 * ShapeDialog'u extend eder ve factory method'u implement eder.
 * Bu sınıf HANGİ Shape üretileceğine karar verir: Circle.
 */
public class CircleDialog extends ShapeDialog {

    /**
     * TODO 3: createShape() metodunu override et.
     * - Yeni bir Circle döndürsün.
     * - Dönüş tipi Shape olmalı (polymorphism).
     *
     * (İpucu:
     * 
     * @Override
     *           protected Shape createShape() {
     *           return new Circle();
     *           }
     *           )
     */
    // BURAYA YAZ:
    @Override
    protected Shape createShape() {
        return new Circle();
    }

}
