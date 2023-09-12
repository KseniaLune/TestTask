## Info
Spring application

### Example:
**Input** - `aaabbccccc` 
</br>

**Output** - `"result": {
                             "c": 5,
                             "a": 3,
                             "b": 2
                         }` 
</br>

## Getting Started
#### 1. Start Localy: 
`./gradlew bootRun`

#### 2. Start with Docker:
```
docker build -t test-task .
docker run --name container_name test-task
```

#### 3. Start tests:
`./gradlew test`

#### 4. Swagger: 
http://localhost:8080/swagger-ui/index.html






