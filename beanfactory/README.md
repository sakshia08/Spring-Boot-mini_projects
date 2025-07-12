# BeanFactory 🧠

Tomcat started on port(s): 8080 (even though we’re not using web features — Spring Boot always starts it by default)

This project focuses on how Spring Boot:
- Creates and manages beans using `@Component`, `@Service`, and `@Repository`
- Performs **Dependency Injection** using `@Autowired` and `@Qualifier`

---

## 🔧 Annotations Used

| Annotation            | Purpose |
|------------------------|---------|
| `@Component`           | Registers generic utility/helper classes as beans |
| `@Service`             | Marks a class that contains business logic (used in service layer) |
| `@Repository`          | Marks a class used for database access |
| `@Autowired`           | Tells Spring to automatically inject a bean where needed |
| `@Qualifier`           | Used when multiple beans of the same type exist — tells Spring **which one** to inject |
| `CommandLineRunner`    | Runs code automatically on app startup (used instead of controller for now) |

---

## 💡 Key Concepts

- **Spring Bean**: A Java object managed by Spring — created, injected, and cleaned up by the Spring container
- `@Component`, `@Service`, `@Repository` all register beans into Spring’s container
- `@Service` and `@Repository` are just **specialized versions of `@Component`**, used to give semantic meaning
- Spring uses **singleton scope by default** → only one instance of each bean exists
- **Dependency Injection (DI)** = letting Spring handle object creation and wiring instead of using `new`

---

## 🧠 Flow of Execution

1. Spring Boot starts and auto-scans all folders
2. `@Component`, `@Service`, and `@Repository` classes are turned into beans
3. Beans are injected using `@Autowired` or constructor injection
4. `DemoRunner` runs because it implements `CommandLineRunner`
5. It calls the `GreetingService`, which uses:
    - `GreetingRepository` to get message
    - `TimeUtility` to get time-based greeting
6. Final message is printed to the console

---

## ❌ Things to Remember / Mistakes

- ❌ Used `@Component` for business logic → better to use `@Service` for clarity
- ❌ Forgot to use constructor injection → `@Autowired` on fields is okay but less recommended
- ❌ Pushed from Git without pulling first → use `git pull origin main --rebase` if GitHub changed
- ❌ Cannot use Postman on console based project - need a web layer.
---

## ✅ Extras

- Use `@Service` for core business logic
- Use `@Component` for reusable utility/helper tools
- Use `@Repository` for DB interaction (even if it’s fake for now)
- Prefer **constructor injection** over field injection — it’s cleaner and testable
- If ever **multiple beans** of the same type present, use `@Qualifier("beanName")`

All three annotations:
- Tell Spring to **create and manage the class as a bean**
- Are detected by **@ComponentScan**
- Differ only in **meaning and intent**
