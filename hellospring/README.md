HelloSpring 🍃



* Tomcat started on port(s): 8080 
* http://localhost:8080
* Next we need to configure this meaning **the route http://localhost:8080 won’t return anything until we write a controller that handles it.**



* import org.springframework.web.bind.annotation.\* - This line tells Java to: “Import all the annotations from the web.bind.annotation package of Spring Framework into this file.” meaning we will be using all the restcontroller and other annotations so better import them



---



\## Annotations

&nbsp;	

| Annotations | Purpose |

|-------------|---------|

| @RestController | Tells Spring this class handles REST requests (returns JSON/text) |

| @Controller | Tells Spring this class returns a web page (HTML via templates) |

| @GetMapping | Maps HTTP GET requests (e.g., /hello) |

| @PostMapping | Maps HTTP POST requests |

| @RequestParam | Reads query parameters (?name=Sakshi) |

| @PathVariable | Reads values from the URL path (/greet/Sakshi) |

| @RequestBody | Reads JSON body and maps to Java object |

| @ResponseBody | Sends return value as response body (JSON/text) |



---



\## 📦 Endpoints



| Endpoint | Type | Description |

|----------|------|-------------|

| `/api/hello` | GET | Returns `"Hello from Spring Boot!"` |

| `/api/greet?name=Sakshi` | GET | Greets by name using query param |

| `/api/greet/Sakshi` | GET | Greets using path variable |

| `/page?name=Sakshi` | GET | Renders an HTML page with Thymeleaf |

---

\## Extra Notes
- A Controller is like the middleman — it receives the request, talks to the code, and sends back a response.
- In spring boot controller class contains methods that can handle web requests. Can control what happens when someone visits certain endpoints.

- Controller - show HTML pages. Use it with Thymeleaf or JSP templates.
- RestController - return data and not HTML pages -> perfect for APIs.
- Responsebody in the restcontroller tells spring to not try and render a page just return it as-is to browser or postman.

- Servlet - Java class that handles web requests/responses - listens for a request, processes it and returns a response.
- Every request is first transferred to servlet.
- DispatcherServlet - Spring's main servlet — routes all requests.
- Tomcat - Java based web server - container of servlets - triggers them -> Listens to HTTP requests, runs servlets, sends responses - embedded automatically in springboot.
- Default port = 8080 but can be changed in application.properties.

- Flow of Request
1. Browser/Postman sends a request (e.g., /api/user)

2. Tomcat Server (inside Spring Boot) receives it

3. DispatcherServlet is triggered (default servlet)

4. It checks:
   - Is there a matching controller? 
   - Is it a GET or POST? 
   - Any path variables?

5. It finds the right controller and method
   - e.g., @PostMapping("/api/user")

6. Spring calls that method and gets a result
   - Maybe a string or a User object

7. DispatcherServlet wraps the result
   - Adds headers, content-type, status code

8. Sends the response back to the browser/Postman

- The DispatcherServlet is automatically registered when you run any Spring Boot app.
