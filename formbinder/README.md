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
