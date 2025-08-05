# Review REST API Testing Examples

## Base URLs
```
Company Reviews: 
  GET    /api/companies/{companyId}/reviews           - Get all reviews for a company
  GET    /api/companies/{companyId}/reviews/{reviewId} - Get specific review for a company
  POST   /api/companies/{companyId}/reviews           - Add review to a company
  PUT    /api/companies/{companyId}/reviews/{reviewId} - Update specific review for a company
  DELETE /api/companies/{companyId}/reviews/{reviewId} - Delete specific review for a company

Global Reviews: 
  GET    /api/reviews     - Get all reviews
  GET    /api/reviews/{id} - Get review by ID
  PUT    /api/reviews/{id} - Update review by ID
  DELETE /api/reviews/{id} - Delete review by ID
```

## 1. Company-Specific Review Operations (Primary)

### Add Review to Specific Company (POST)
```bash
curl -X POST http://localhost:8080/api/companies/1/reviews \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Great Company to Work For",
    "description": "Excellent work culture and growth opportunities",
    "rating": 4.5
  }'
```

### Get All Reviews for a Company (GET)
```bash
curl -X GET http://localhost:8080/api/companies/1/reviews
```

### Get Specific Review for a Company (GET)
```bash
curl -X GET http://localhost:8080/api/companies/1/reviews/1
```

### Update Review for a Company (PUT)
```bash
curl -X PUT http://localhost:8080/api/companies/1/reviews/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Outstanding Company Culture",
    "description": "Amazing work environment with excellent benefits",
    "rating": 5.0
  }'
```

### Delete Review for a Company (DELETE)
```bash
curl -X DELETE http://localhost:8080/api/companies/1/reviews/1
```

## 2. Global Review Operations

### Get All Reviews (GET)
```bash
curl -X GET http://localhost:8080/api/reviews
```

### Get Review by ID (GET)
```bash
curl -X GET http://localhost:8080/api/reviews/1
```

### Update Review (PUT)
```bash
curl -X PUT http://localhost:8080/api/reviews/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Outstanding Company Culture",
    "description": "Amazing work environment with excellent benefits",
    "rating": 5.0
  }'
```

### Delete Review (DELETE)
```bash
curl -X DELETE http://localhost:8080/api/reviews/1
```

## Expected Responses

### Create Review Response (201 Created)
```json
{
  "id": 1,
  "title": "Great Company to Work For",
  "description": "Excellent work culture and growth opportunities",
  "rating": 4.5
}
```

### Get All Reviews for Company Response (200 OK)
```json
[
  {
    "id": 1,
    "title": "Great Company to Work For",
    "description": "Excellent work culture and growth opportunities",
    "rating": 4.5
  },
  {
    "id": 2,
    "title": "Good Learning Experience",
    "description": "Great place for junior developers to learn",
    "rating": 4.2
  }
]
```

### Get All Reviews (Global) Response (200 OK)
```json
[
  {
    "id": 1,
    "title": "Great Company to Work For",
    "description": "Excellent work culture and growth opportunities",
    "rating": 4.5
  },
  {
    "id": 2,
    "title": "Good Learning Experience",
    "description": "Great place for junior developers to learn",
    "rating": 4.2
  }
]
```

### Review Not Found Response (404 Not Found)
No content body, just HTTP 404 status code.

## Rating Guidelines
- Rating should be between 1.0 and 5.0
- Use decimal values for precise ratings (e.g., 4.5, 3.8)

## Key Changes
- **NEW**: Use `/api/companies/{companyId}/reviews` for company-specific review operations
- **NEW**: Added PUT and DELETE endpoints for company-specific reviews: `/api/companies/{companyId}/reviews/{reviewId}`
- **Simplified JSON**: No need to include company object in request body - companyId is in the URL
- **Consistent with other endpoints**: Follows same pattern as `/api/companies/{id}/jobs`
- **Fixed circular references**: Reviews no longer include nested company data to prevent infinite loops
- **Clean responses**: API responses are now cleaner and more efficient without circular data
- **Simplified endpoints**: Removed average rating and rating filter endpoints for cleaner API
