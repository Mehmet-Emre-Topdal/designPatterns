package abstractfactory;

/**
 * ABSTRACT FACTORY PATTERN - Abstract Product B
 * -----------------------------------------------
 * Ürün ailesinin ikinci parçası (Checkbox).
 *
 * Abstract Factory'nin gücü: aynı aileden birden fazla ürünü
 * birlikte üretmesi. Button + Checkbox hep aynı platformdan gelir.
 */
public interface Checkbox {
    void render();
}
