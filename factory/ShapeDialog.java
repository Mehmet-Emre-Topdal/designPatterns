package factory;

/**
 * FACTORY METHOD PATTERN - Creator (Abstract)
 * --------------------------------------------
 * Bu sınıf bir "işi" (renderShape) tanımlar ama işin içinde
 * kullanılacak nesneyi (Shape) KENDİSİ üretmez.
 * Üretimi alt sınıflara bırakır: işte o metot "factory method".
 *
 * NOT: Factory Method pattern'ının kalbi şurada:
 * - renderShape() somut iş akışını tanımlar.
 * - createShape() abstract'tır -> hangi Shape üretileceğine
 * alt sınıflar (CircleDialog, RectangleDialog) karar verir.
 */
public abstract class ShapeDialog {

    /**
     * TODO 1: Bu metot hazır; sadece akışı anla.
     * - createShape() ile bir Shape üret.
     * - draw() çağır.
     *
     * Bu bir "template method"tur; alt sınıflar bu akışı değiştirmez,
     * sadece createShape()'i değiştirir.
     */
    public void renderShape() {
        System.out.println("Dialog açılıyor...");
        Shape shape = createShape();
        shape.draw();
        System.out.println("Dialog kapandı.");
    }

    /**
     * TODO 2: Factory method'u tanımla.
     * - İsim: createShape
     * - Dönüş tipi: Shape
     * - protected abstract olmalı (alt sınıflar zorunlu implement etsin)
     *
     * (İpucu: protected abstract Shape createShape();)
     */
    // BURAYA YAZ:
    protected abstract Shape createShape();

}
