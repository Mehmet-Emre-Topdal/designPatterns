package builder;

/**
 * BUILDER PATTERN - Builder Sınıfı
 * ----------------------------------
 * GÖREV: Aşağıdaki setter metodlarını ve build() metodunu tamamla.
 * 
 *
 * Her setter metodu:
 *   1. İlgili alanı set etmeli
 *   2. Method chaining için "return this" döndürmeli
 *
 * Kullanım örneği (main.java'da):
 *   Person p = new PersonBuilder()
 *                  .setName("Ali")
 *                  .setAge(25)
 *                  .setEmail("ali@mail.com")
 *                  .build();
 */
public class PersonBuilder {

    // Paket-erişimli alanlar (Person sınıfı okuyacak)
    String name;
    int    age;
    String email;
    String phone;
    String address;

    // TODO 1: setName(String name) metodunu yaz → return this
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    // TODO 2: setAge(int age) metodunu yaz → return this
    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    // TODO 3: setEmail(String email) metodunu yaz → return this
    public PersonBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public PersonBuilder setPhone(String phone){
        this.phone = phone;
        return this;
    }

    public PersonBuilder setAddress(String address)
    {
        this.address = address;
        return this;
    }

    /**
     * TODO 6: build() metodunu tamamla.
     *         - name ve email zorunlu; biri null/boşsa IllegalStateException fırlat.
     *         - Geçerliyse yeni bir Person(this) döndür.
     */
    public Person build() {
        if(name == null ||email == null){
            return null;
        }
        return new Person(this);
    }


}
