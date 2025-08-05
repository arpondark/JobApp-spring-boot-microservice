# Job REST API Testing Examples

## Base URL
```
http://localhost:8080/api/jobs
```

## 1. Create a New Job (POST)
```bash
curl -X POST http://localhost:8080/api/jobs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Software Engineer",
    "description": "Develop and maintain web applications",
    "minSalary": "60000",
    "maxSalary": "80000",
    "location": "New York"
  }'
```

## 2. Get All Jobs (GET)
```bash
curl -X GET http://localhost:8080/api/jobs
```

## 3. Get Job by ID (GET)
```bash
curl -X GET http://localhost:8080/api/jobs/1
```

## 4. Update Job (PUT)
```bash
curl -X PUT http://localhost:8080/api/jobs/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Senior Software Engineer",
    "description": "Lead development of web applications",
    "minSalary": "80000",
    "maxSalary": "100000",
    "location": "San Francisco"
  }'
```

## 5. Delete Job (DELETE)
```bash
curl -X DELETE http://localhost:8080/api/jobs/1
```

## Expected Responses

### Create Job Response (201 Created)
```json
{
  "id": 1,
  "title": "Software Engineer",
  "description": "Develop and maintain web applications",
  "minSalary": "60000",
  "maxSalary": "80000",
  "location": "New York"
}
```

### Get All Jobs Response (200 OK)
```json
[
  {
    "id": 1,
    "title": "Software Engineer",
    "description": "Develop and maintain web applications",
    "minSalary": "60000",
    "maxSalary": "80000",
    "location": "New York"
  }
]
```

### Job Not Found Response (404 Not Found)
No content body, just HTTP 404 status code.
