# Application API Contract (Spring Boot)

## Requirements
- Java 17 or later
- Eclipse IDE for Enterprise Java and Web Developers, or Spring Tool Suite
- Maven (Eclipse can use its embedded Maven)

## Import into Eclipse / STS
1. Extract this ZIP file.
2. Open Eclipse/STS.
3. Select **File -> Import -> Maven -> Existing Maven Projects**.
4. Browse to the extracted `application-api-contract` folder.
5. Select the project and click **Finish**.
6. Wait for Maven dependencies to download.

## Run
1. Open `ApplicationApiApplication.java`.
2. Right-click -> **Run As -> Java Application** (or Spring Boot App).
3. The server starts at `http://localhost:8080`.

## Test the endpoint
Use a browser, Postman, or curl:

```bash
curl -i http://localhost:8080/api/applications/101
```

Expected HTTP 200 response:

```json
{
  "id": 101,
  "applicantName": "Sanjay",
  "applicationType": "Student",
  "status": "APPROVED"
}
```

Try an unknown ID:

```bash
curl -i http://localhost:8080/api/applications/999
```

Expected HTTP 404 response:

```json
{
  "error": "APPLICATION_NOT_FOUND",
  "message": "No application found with id 999"
}
```

## Run tests
Right-click the project -> **Run As -> Maven test**.

## YAML contract
The contract is at `src/main/resources/openapi.yaml`. It defines:
- HTTP method and path: `GET /api/applications/{id}`
- Required path parameter and its type
- Successful HTTP 200 response schema
- HTTP 404 error response schema
- Required JSON properties and allowed `status` values

The controller and DTO implement the contract, and the tests verify the response fields and status codes. The YAML file documents the contract; this starter project does not automatically validate every runtime response against the YAML. For strict automated runtime contract validation, add an OpenAPI validator or provider/consumer contract-testing tool.
