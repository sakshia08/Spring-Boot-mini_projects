# FormBinder 📝

Tomcat started on port(s): 8080  
URL tested: `http://localhost:8080/api/user`

This project focuses on:
- Accepting raw JSON input via POST
- Binding it to a Java object using `@RequestBody`
- Converting fields (like `String` to `LocalDate`) using `@InitBinder`
- Sending proper responses using `ResponseEntity`

---

## 📦 Endpoints

| Endpoint | Type | Description |
|----------|------|-------------|
| `/api/user` | POST | Accepts user info (`name`, `dob`) in JSON |
| `/api/test` | GET | Returns plain text to verify routing works |

✅ Note: Cannot test `/api/user` in browser — it **must** be tested via Postman or curl because it’s a `POST` endpoint and requires a body.

---

## 🧪 Postman Setup

- **Method**: `POST`
- **URL**: `http://localhost:8080/api/user`
- **Headers**: `Content-Type: application/json`
- **Body** (raw JSON):
```json
{
  "name": "Sakshi",
  "dob": "2000-07-03"
}
```

---

## 🔧 Annotations Used

| Annotation               | Purpose                                                                      |
|--------------------------|------------------------------------------------------------------------------|
| `@RestController`        | Handles REST APIs and returns raw JSON/text                                  |
| `@PostMapping`           | Maps HTTP POST requests to methods                                           |
| `@RequestBody`           | Converts raw JSON to a Java object                                           |
| `@InitBinder`            | Used to customize how form fields are parsed (e.g., String → LocalDate)     |
| `@RequestMapping("/api")`| Base URL mapping for all endpoints in the controller                         |
| `ResponseEntity`         | Helps return status codes, headers, and messages cleanly                     |

---

## Recap
- @InitBinder runs before request binding to configure how certain fields (like dates) are parsed.
- PropertyEditorSupport is used to manually convert a date string (like "2000-07-03") to LocalDate.
- You must test POST endpoints like /api/user using Postman or frontend code — not the browser URL bar.
- If Content-Type header or JSON body is wrong → you'll get 400 or 415 error.
- Had GETMapping but was calling with POST → mismatch = 405 error

- Important
- Use @InitBinder when field data from JSON (e.g., dates, enums) need to be manually converted.
- Always use @RequestBody with POST methods expecting full JSON objects.
- Use ResponseEntity.ok("message") for clean, HTTP 200-style responses.

---

@GetMapping	-> Handle HTTP GET requests	-> when you want to - Read or fetch data (no changes) - ex: view profile
@PostMapping	-> Handle HTTP POST requests	-> when you want to - Send or create data (causes a change) - ex: register a user

Use @GetMapping when:
- You want to retrieve information
- The request doesn’t change anything
- You’re just reading from the server

Use @PostMapping when:
- You’re sending data to the server
- You want to create, update, or submit something
- The request modifies data or state

Why we used postmapping in formbinder? We were sending JSON data (name, dob) from Postman to the server.
The server was supposed to read that data and process it - exactly what post is for.

If we used getmapping instead -
- Can't pass a body in a GET request — so no JSON
- Forced to pass everything in the URL: /user?name=Sakshi&dob=2000-07-03 -> messy, insecure and not RESTful.
