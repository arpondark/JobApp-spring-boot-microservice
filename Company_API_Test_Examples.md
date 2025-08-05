# Company REST API Testing Examples

## Base URL
```
http://localhost:8080/api/companies
```

## 1. Company CRUD Operations

### Create a New Company (POST)
```bash
curl -X POST http://localhost:8080/api/companies \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Tech Solutions Inc",
    "description": "A leading technology consulting company"
  }'
```

### Get All Companies (GET)
```bash
curl -X GET http://localhost:8080/api/companies
```

### Get Company by ID (GET)
```bash
curl -X GET http://localhost:8080/api/companies/1
```

### Update Company (PUT)
```bash
curl -X PUT http://localhost:8080/api/companies/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Tech Solutions Corp",
    "description": "A premier technology consulting corporation"
  }'
```

### Delete Company (DELETE)
```bash
curl -X DELETE http://localhost:8080/api/companies/1
```

## 2. Company-Job Relationship Operations

### Get All Jobs for a Company (GET)
```bash
curl -X GET http://localhost:8080/api/companies/1/jobs
```

### Add Job to Company (POST)
```bash
curl -X POST http://localhost:8080/api/companies/1/jobs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Senior Java Developer",
    "description": "Develop enterprise Java applications",
    "minSalary": "80000",
    "maxSalary": "120000",
    "location": "New York"
  }'
```

### Remove Job from Company (DELETE)
```bash
curl -X DELETE http://localhost:8080/api/companies/1/jobs/5
```

## Expected Responses

### Create Company Response (201 Created)
```json
{
  "id": 1,
  "name": "Tech Solutions Inc",
  "description": "A leading technology consulting company",
  "jobs": []
}
```

### Get All Companies Response (200 OK)
```json
[
  {
    "id": 1,
    "name": "Tech Solutions Inc",
    "description": "A leading technology consulting company",
    "jobs": [
      {
        "id": 5,
        "title": "Senior Java Developer",
        "description": "Develop enterprise Java applications",
        "minSalary": "80000",
        "maxSalary": "120000",
        "location": "New York"
      }
    ]
  }
]
```

### Get Company Jobs Response (200 OK)
```json
[
  {
    "id": 5,
    "title": "Senior Java Developer",
    "description": "Develop enterprise Java applications",
    "minSalary": "80000",
    "maxSalary": "120000",
    "location": "New York",
    "company": {
      "id": 1,
      "name": "Tech Solutions Inc",
      "description": "A leading technology consulting company"
    }
  }
]
```
