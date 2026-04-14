package singleton;

public class Singleton {
    private int value;

    public int getValue() {
        return value;
    }

    private static Singleton instance;

    private Singleton() {}

    public void setValue(int val) {
        this.value = val;
    }

    public synchronized static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println(value);
    }
}
