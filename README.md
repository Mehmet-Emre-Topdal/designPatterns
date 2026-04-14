# Design Patterns in Java — with Spring Framework Context

Bu repo, klasik **Gang of Four (GoF)** tasarım desenlerinin Java ile sade ve öğrenme odaklı implementasyonlarını içerir. Her desen için ek olarak, o desenin **Spring Framework** ekosisteminde nerede karşımıza çıktığı açıklanmıştır.

## Amaç

- Tasarım desenlerini **teoriyle değil, elle yazarak** içselleştirmek.
- Her desenin **ne problemi çözdüğünü**, **ne zaman kullanılacağını** ve **ne zaman kullanılmaması gerektiğini** netleştirmek.
- Desenlerin **Spring gibi gerçek dünyada yaygın kullanılan bir framework'te** nasıl görüldüğünü göstererek teoriyi pratiğe bağlamak.
- Benzer desenler (örn. *Factory Method* vs *Simple Factory* vs *Strategy*) arasındaki farkları somut örneklerle ayırt etmek.

Her klasör bir patern içerir. Kodlar, ben doldurarak öğrenmek için `TODO` yorumlarıyla bırakılmış olup şu an tamamlanmış hâldedir.

## Proje Yapısı

```
designPatterns/
├── singleton/    → Singleton Pattern
├── factory/      → Factory Method Pattern
├── builder/      → Builder Pattern
├── observer/     → Observer Pattern
├── proxy/        → Proxy Pattern
├── strategy/     → Strategy Pattern (+ Simple Factory kullanımı)
└── main.java     → Tüm desenlerin çalıştırıldığı örnek
```

**Çalıştırma:**
```bash
javac **/*.java
java Main
```

---

## 1. Singleton

**Amaç:** Bir sınıftan yalnızca tek bir örnek oluşturulmasını garanti eder ve o örneğe global erişim sağlar.

**Ne zaman kullanılır?** Log yöneticisi, config nesnesi, DB bağlantı havuzu gibi uygulama genelinde tek olması gereken nesneler için.

### Spring'de Karşılığı

- **Default bean scope `singleton`** — `@Component`, `@Service`, `@Repository`, `@Controller` ile işaretli tüm bean'ler varsayılan olarak singleton'dır. Spring container uygulama ömrü boyunca o sınıfın **tek bir örneğini** tutar ve onu dependency injection ile dağıtır.
- `ApplicationContext` başlı başına bir singleton'dır.
- Saf Java singleton'dan farkı: thread-safety, lifecycle, lazy init gibi konuları **sen değil, container** yönetir.

---

## 2. Factory Method

**Amaç:** Nesne oluşturmanın sorumluluğunu üst sınıftan alıp alt sınıflara devreder. Üst sınıf ortak iş akışını tanımlar; **hangi somut nesnenin üretileceğine alt sınıflar karar verir.**

**Simple Factory'den farkı:** Simple Factory runtime girdisine göre (string/enum) switch ile nesne üretir. Factory Method ise switch kullanmaz — her alt sınıfın kendi üretim cevabı vardır (polymorphism).

### Spring'de Karşılığı

- **`FactoryBean<T>` arayüzü** — Spring'in kendi factory method pattern uygulaması. Karmaşık nesne üretiminde (örn. proxy, remote service, mock vs.) bean nasıl oluşturulacağını bu arayüz belirler.
- **`BeanFactory` / `ApplicationContext`** — Dolaylı olarak factory pattern uygular; bean tanımından (definition) somut bean üretir.
- `@Bean` ile işaretlenmiş method'lar bir tür **configuration-level factory method**'dur.
- Spring Data'daki repository arayüzlerinin concrete implementasyonu runtime'da üretilir (proxy + factory).

---

## 3. Builder

**Amaç:** Çok parametreli veya opsiyonel alanları olan nesnelerin oluşturulmasını akıcı ve okunabilir hâle getirir. Constructor telescoping sorununu çözer.

**Ne zaman kullanılır?** Immutable nesneler, opsiyonel alanları çok olan DTO/config nesneleri.

### Spring'de Karşılığı

- **`UriComponentsBuilder`** — URI'leri akıcı (fluent) biçimde inşa eder.
- **`MockMvcBuilders`** — Test ortamında `MockMvc` nesnesi inşa etmek için.
- **`RestClient.builder()` / `WebClient.builder()`** — HTTP client konfigürasyonu.
- **`BeanDefinitionBuilder`** — Programatik bean tanımı oluşturma.
- Lombok `@Builder` anotasyonu — Spring ekosisteminde yaygın kullanılan kısayol.

---

## 4. Observer

**Amaç:** Bir nesnenin durumu değiştiğinde ona bağlı tüm dinleyicilerin **otomatik bilgilendirilmesi**. Yayıncı-abone (publisher-subscriber) modeli.

**Ne zaman kullanılır?** Event-driven mimariler, UI event sistemleri, state değişimlerine bağlı yan etkiler.

### Spring'de Karşılığı

- **`ApplicationEventPublisher` + `@EventListener`** — Spring'in yerleşik event mekanizması. Bir bean event yayınlar, kim dinlerse `@EventListener` ile kaydolur. Klasik Observer'ın doğrudan uygulaması.
- **`ApplicationListener<E>` arayüzü** — Daha eski ama hâlâ kullanılan event listener API'si.
- Spring'in kendi `ContextRefreshedEvent`, `ContextClosedEvent` gibi yaşam döngüsü event'leri bu patern üzerinden çalışır.
- Spring Integration ve Reactive Streams (Project Reactor) büyük ölçekte Observer mantığını genelleştirir.

---

## 5. Proxy

**Amaç:** Bir nesnenin önüne "vekil" (proxy) koyarak ona erişimi kontrol etmek, ek davranış (cache, log, güvenlik, lazy loading) eklemek veya uzaktan erişimi soyutlamak.

**Bu repoda:** Lazy loading proxy — `RealImage` ağır bir nesne, sadece gerektiğinde yüklenir.

### Spring'de Karşılığı

- **AOP (Aspect Oriented Programming)** tamamen proxy üzerine kuruludur. `@Transactional`, `@Async`, `@Cacheable`, `@PreAuthorize` gibi anotasyonlar Spring'in runtime'da ürettiği proxy'ler üzerinden çalışır.
- **JDK dynamic proxy** ve **CGLIB proxy** — Spring, bean'lerin etrafına şeffaf biçimde proxy sarar.
- **`@Transactional`** — Metot çağrısı aslında proxy üzerinden gider, proxy transaction'ı başlatır, metot çalışır, commit/rollback yapılır.
- **Lazy initialization** (`@Lazy`) — Bean gerçekten kullanılana kadar proxy döner.
- **Spring Data repository'leri** — Arayüzü tanımlarsın, Spring implementasyonu bir proxy olarak üretir.

---

## 6. Strategy

**Amaç:** Bir algoritma ailesini tanımlar, her birini ayrı sınıfa koyar ve bunları **runtime'da değiştirilebilir** yapar. Davranışı nesneye çevirir.

**Factory Method'dan farkı:** Factory Method *hangi nesnenin üretileceğini* seçer; Strategy *hangi davranışın kullanılacağını* seçer. İki desen birlikte de kullanılabilir — bu repoda `PaymentStrategyFactory` string girdiyi uygun Strategy'ye çevirir.

### Spring'de Karşılığı

- **Birden fazla bean'in aynı arayüzü implement etmesi + `@Qualifier` veya `Map<String, Strategy>` injection** — Spring'in strategy seçiminin idiomatik yolu. `List<PaymentStrategy>` veya `Map<String, PaymentStrategy>` inject edilir, runtime'da uygun olan seçilir.
- **`PlatformTransactionManager`** — `JpaTransactionManager`, `DataSourceTransactionManager`, `JtaTransactionManager` gibi farklı implementasyonlar aynı arayüzü uygular. Ortam seçimi konfigürasyonla belirlenir.
- **`PasswordEncoder`** — Bcrypt, Argon2, PBKDF2 vs. birer strategy'dir.
- **`AuthenticationProvider`** — Spring Security farklı auth yöntemlerini strategy olarak yönetir.
- **`HandlerMethodArgumentResolver`**, **`ViewResolver`**, **`MessageConverter`** — MVC katmanında davranış genişletme hep strategy kullanır.

---

## Öğrendiklerimden Notlar

- **Her problem patern gerektirmez.** Küçük, basit işler için `new` ile nesne yaratmak en doğru çözüm olabilir.
- **Simple Factory** GoF'un resmi deseni değildir ama pratik kullanımda çok yaygındır.
- **Factory Method** ile **Strategy** birbirini tamamlar: biri nesneyi seçer, diğeri davranışı soyutlar.
- Spring, bu desenlerin çoğunu **konvansiyon + anotasyonlarla gizler**; framework kullanırken farkında olmasan da bu desenler zaten çalışır.
- Desenleri elle yazmak, framework sihrinin altında ne olduğunu anlamayı kolaylaştırır.

---

## Kaynaklar

- *Design Patterns: Elements of Reusable Object-Oriented Software* — Gang of Four (1994)
- *Head First Design Patterns* — Freeman & Robson
- [Refactoring.Guru — Design Patterns](https://refactoring.guru/design-patterns)
- [Spring Framework Reference](https://docs.spring.io/spring-framework/reference/)
