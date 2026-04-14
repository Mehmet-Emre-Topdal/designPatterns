package observer;

/**
 * OBSERVER PATTERN - Concrete Observer
 * --------------------------------------
 * GÖREV: EventListener arayüzünü implement et.
 */
public class ConcreteListener implements EventListener {

    private final String name;

    public ConcreteListener(String name) {
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }

    // TODO 3: update(String message) metodunu override et.
    //         "[name] olayı aldı: [message]" formatında yazdırsın.
    @Override
    public void update(String message){
        System.out.println(name + " olayı aldı: " + message);
    }
}
