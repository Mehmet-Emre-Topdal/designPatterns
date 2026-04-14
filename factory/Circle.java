package factory;

/**
 * FACTORY METHOD PATTERN - Concrete Ürün
 * ----------------------------------------
 * GÖREV: Shape arayüzünü implement et.
 */
public class Circle implements Shape {

    // TODO 3: draw() metodunu override et.
    //         "Daire çiziliyor." yazdırsın.
    @Override
    public void draw(){
        System.out.println("daire çiziliyor");
    }



}
