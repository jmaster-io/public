1. Chay lenh maven lan luot
   + mvn spring-boot:run -Dspring-boot.run.profiles=http1
   + mvn spring-boot:run -Dspring-boot.run.profiles=http2
   + mvn spring-boot:run -Dspring-boot.run.profiles=default

4. Truy cap de so sanh load 200 anh
   + https://localhost:8080/http1
   + https://localhost:8080/http2

2. Su dung postman de test thử REST API, do thời gian
   + HTTP/1:   https://localhost:8081/json
   + HTTP/2:   https://localhost:8082/json
