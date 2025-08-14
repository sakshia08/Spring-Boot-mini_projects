## AspectLogger
A Spring Boot project demonstrating Spring AOP (Aspect-Oriented Programming) to log method calls, parameters, and execution flow.

---

### 📌 Key Annotations

Annotation	Purpose

- @Aspect	- Marks a class as an Aspect - tells spring boot that this contains certain methods that might require interception which might need to be executed before or after certain methods.
- @Pointcut - expression that defines where the advice should be applied. (e.g., all methods in a package). - Advice = annotation(@before or after) together with the method.
- @Before	- Runs before the matched method executes.
- @After	- Runs after the matched method executes (always runs, even if exception occurs).
- @AfterReturning	- Runs after method returns successfully. Can capture return values.
- @AfterThrowing	- Runs if the method throws an exception.
- JoinPoint	- Gives access to method name, parameters, and target object inside an advice.
- @EnableAspectJAutoProxy	(Optional) - Enables AOP in Spring; Spring Boot auto-configures this when spring-boot-starter-aop is present.

---

### Endpoints
| Endpoint          | Type   | Description       |
| ----------------- | ------ | ----------------- |
| `/api/users`      | GET    | Get all users     |
| `/api/users/{id}` | GET    | Get user by ID    |
| `/api/users`      | POST   | Create a new user |
| `/api/users/{id}` | PUT    | Update a user     |
| `/api/users/{id}` | DELETE | Delete a user     |

---

### Flow of Request with AOP

1. Browser/Postman sends a request → GET /api/users.

2. Tomcat receives it and triggers DispatcherServlet.

3. DispatcherServlet looks for a matching controller method.

4. AOP Interceptor (Aspect) checks if the method matches any defined pointcuts.

5. If matched:

    - @Before advice runs before controller method.

    - Controller method executes.

    - @AfterReturning advice logs result if successful.

    - Or @AfterThrowing advice logs the exception if thrown.

6. Response is sent back to the client.

---

### Check:
- 404 error if endpoint URL in browser/Postman doesn’t match @RequestMapping or @GetMapping paths.

- Must have spring-boot-starter-aop dependency, otherwise AspectJ annotations won’t be recognized.

- Package scanning must include the Aspect class (same or sub-package of @SpringBootApplication class).

---

### ⚙️ Dependencies

spring-boot-starter-web → REST APIs

spring-boot-starter-aop → AOP/AspectJ support
