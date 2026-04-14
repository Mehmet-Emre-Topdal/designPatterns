package factory;

/**
 * FACTORY METHOD PATTERN - Concrete Ürün
 * ----------------------------------------
 * GÖREV: Shape arayüzünü implement et.
 */
public class Rectangle implements Shape {

    // TODO 3: draw() metodunu override et.
    //         "Dikdörtgen çiziliyor." yazdırsın.
    @Override
    public void draw(){
        System.out.println("Dikdörtgen çizdiriliyor");
    }

}
