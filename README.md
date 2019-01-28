# exam-ms-marl

RELEASE-NOTES:
  - run in port 8181
  - HTTPS no implemented yet. (Too busy in the work past week)
  - H2 database enabled.
      inserts in resources/data.sql
      link to see table´s data:
      http://localhost:8080/h2-console    jdbc:h2:mem:testdb  
  -Swagger links:
    http://localhost:8080/v2/api-docs
    http://localhost:8080/swagger-resources
    http://localhost:8080/swagger-ui.html
  -Postman collection file provided:
    ./collection-postman-gft-exam-ms-marl.postman_collection.json
    filter work with ID (customer_id) and name, paternal and maternal names only. 
    (because other params not mapped in the domain model).
    
 (⌐■_■)
