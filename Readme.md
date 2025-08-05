# JobApp - Job and Company Review Management System

This is a Spring Boot application for managing jobs, companies, and company reviews.

## API Endpoints

### Companies
- `GET /api/companies` - Get all companies
- `GET /api/companies/{id}` - Get company by ID
- `POST /api/companies` - Create a new company
- `PUT /api/companies/{id}` - Update company
- `DELETE /api/companies/{id}` - Delete company
- `GET /api/companies/{id}/jobs` - Get all jobs for a specific company
- `POST /api/companies/{id}/jobs` - Add a job to a specific company
- `DELETE /api/companies/{companyId}/jobs/{jobId}` - Remove job from company

### Jobs
- `GET /api/jobs` - Get all jobs
- `GET /api/jobs/{id}` - Get job by ID
- `POST /api/jobs` - Create a new job
- `PUT /api/jobs/{id}` - Update job
- `DELETE /api/jobs/{id}` - Delete job

### Reviews
#### Company-Specific Review Endpoints
- `GET /api/companies/{companyId}/reviews` - Get all reviews for a specific company
- `POST /api/companies/{companyId}/reviews` - Add a review to a specific company
- `GET /api/companies/{companyId}/reviews/average` - Get average rating for a company

#### Global Review Endpoints
- `GET /api/reviews` - Get all reviews
- `GET /api/reviews/{id}` - Get review by ID
- `PUT /api/reviews/{id}` - Update existing review
- `DELETE /api/reviews/{id}` - Delete review by ID
- `GET /api/reviews/rating?minRating={min}&maxRating={max}` - Get reviews by rating range

## Review JSON Structure

When creating a review using `POST /api/companies/{companyId}/reviews`, use the following JSON structure:

```json
{
    "title": "Great Company to Work For",
    "description": "Excellent work culture and growth opportunities",
    "rating": 4.5
}
```

### Fields:
- `title` (required): Title of the review
- `description` (optional): Detailed description of the review (max 1000 characters)
- `rating` (required): Rating from 0.0 to 5.0

Note: The `companyId` is specified in the URL path, so it doesn't need to be included in the JSON body.

## Example API Calls

### Create a Review for a Company
```bash
POST /api/companies/1/reviews
Content-Type: application/json

{
    "title": "Amazing workplace culture",
    "description": "Great benefits, supportive management, and excellent work-life balance",
    "rating": 4.8
}
```

### Get All Reviews for a Company
```bash
GET /api/companies/1/reviews
```

### Get Average Rating for a Company
```bash
GET /api/companies/1/reviews/average
```

This will return:
```json
{
    "companyId": 1,
    "averageRating": 4.2
}
```