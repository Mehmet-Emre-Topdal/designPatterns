package abstractfactory;

/**
 * ABSTRACT FACTORY PATTERN - Abstract Product A
 * -----------------------------------------------
 * Bir ürün ailesinin bir parçası (Button).
 * Farklı aileler (Windows/Mac) bu arayüzü farklı şekilde implement eder.
 */
public interface Button {
    void render();
}
