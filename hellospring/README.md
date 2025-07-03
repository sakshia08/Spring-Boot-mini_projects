\#hellospring



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



