package builder;

/**
 * BUILDER PATTERN - Ürün Sınıfı
 * --------------------------------
 * Amaç: Çok sayıda parametresi olan karmaşık nesneleri
 *       adım adım, okunabilir şekilde oluşturmak.
 *
 * Bu sınıf tamamlanmış — sadece incele, değiştirme.
 */
public class Person {
    private final String name;
    private final int    age;
    private final String email;
    private final String phone;   // isteğe bağlı
    private final String address; // isteğe bağlı

    // Builder tarafından çağrılır; dışarıdan new Person() yapılamaz.
    //bu bir package private metodtur
    Person(PersonBuilder builder) {
        this.name    = builder.name;
        this.age     = builder.age;
        this.email   = builder.email;
        this.phone   = builder.phone;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age +
               ", email='" + email + "', phone='" + phone +
               "', address='" + address + "'}";
    }
}
