# ConfigMaster ⚙️

This project focuses on Spring Boot configuration using:
- `application.properties` to externalize values
- `@Value` to inject values into fields or beans
- Two different ways of creating beans:
    - Manually using `@Configuration` + `@Bean`
    - Automatically using `@Component`

---

## 🔧 Annotations Used

| Annotation           | Purpose                                                                                                         |
|----------------------|-----------------------------------------------------------------------------------------------------------------|
| `@Configuration`     | Declares a class that defines beans manually. Tells spring that in the below method you will find bean methods. |
| `@Bean`              | Manually registers a method’s return object as a Spring bean                                                    |
| `@Component`         | Auto-registers the class as a Spring bean. Tells spring boot to take care of all the details.                   |
| `@Value`             | Injects values from `application.properties`                                                                    |
| `CommandLineRunner`  | Runs code at application startup                                                                                |

---

## ⚙️ application.properties

```properties
greeting.message=Hello there,
greeting.name=Sakshi
```

---

### Version 1 - Using configuration + bean annotation
- Appconfig = This is where we tell Spring to create a bean manually using the values from application.properties.
- Spring loads (message = "Hello there,"; name = "Sakshi")
- These are injected into the fields of AppConfig using @Value

### Flow
1. application.properties ➝ values loaded

2. AppConfig.java        ➝ @Bean method uses values 
3. Greeter.java          ➝ new Greeter(message, name)
4. Spring registers it as a bean
5. Injected into DemoRunner on app startup

### Version 2 - Using component annotation
- Greeter class the component annotation
- Now Spring will:
  - Auto-detect this class as a component.
  - Inject values from application.properties into message and name.
  - Manage it as a Spring bean.
- No need of appconfig

| With `@Bean`                                | With `@Component`                     |
| ------------------------------------------- | ------------------------------------- |
| You manage bean creation manually in config | Spring auto-creates the bean          |
| Great for third-party or library classes    | Great when you control the class      |
| Values injected in `AppConfig`              | Values injected directly in the class |
| Explicit wiring in `@Bean` method           | Implicit wiring using annotations     |

---

## Flow of Execution
### With Bean
application.properties ➝ @Value injected into AppConfig\
↓\
AppConfig ➝ @Bean method creates Greeter(message, name)\
↓\
Greeter object registered as Spring bean\
↓\
Injected into DemoRunner\
↓\
App prints greeting on startup

### With Component
application.properties ➝ @Value injected directly into Greeter\
↓\
Greeter auto-registered via @Component\
↓\
Injected into DemoRunner\
↓\
App prints greeting on startup

