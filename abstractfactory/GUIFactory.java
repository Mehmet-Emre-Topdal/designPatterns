package abstractfactory;

/**
 * ABSTRACT FACTORY PATTERN - Abstract Factory
 * ---------------------------------------------
 * Bir ürün AİLESİ üretmek için arayüz.
 * Her concrete factory, ailenin tüm parçalarını birlikte üretir.
 *
 * Factory Method'dan farkı:
 * - Factory Method: 1 ürün türü, alt sınıflar hangi somut tipi üretir?
 * - Abstract Factory: N ilişkili ürün türü, hepsi aynı aileden gelir.
 *
 * Burada aile = platform (Windows/Mac).
 * Ürünler = Button + Checkbox.
 */
public interface GUIFactory {

    /**
     * TODO 5: createButton() metot imzasını tanımla.
     * - Dönüş tipi: Button
     */
    // BURAYA YAZ:
    Button createButton();

    /**
     * TODO 6: createCheckbox() metot imzasını tanımla.
     * - Dönüş tipi: Checkbox
     */
    // BURAYA YAZ:
    Checkbox createCheckbox();

}
