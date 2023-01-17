## Spring Sample Docker

### Clone Project
```bash
git clone https://github.com/jutionck/spring-sample-docker.git
```

### Note
1. Karena sudah menggunakan database dan ingin dijalankan dengan docker maka databasenya kita buat juga dengan image docker.
2. Silahkan pull image postgres dahulu `docker pull postgres:alpine3.17`
3. Perlu diingat image database dan image spring yang nanti kita buat harus mempunyai interaksi, interaksi disini adalah penggunaan `network`.
4. Buat `network` terlebih dahulu dengan perintah `docker network create todo-app-network`.
5. Cek `network`yang sudah dibuat dengan perintah `docker network ls`
6. Setelah itu kita jalankan image postgre yang sudah di pull sebelumnya dengan perintah berikut
    ```bash
    docker run --network todo-app-network -d --name todo-app-db -e POSTGRES_PASSWORD=P@ssw0rd -p 5433:5432 postgres:alpine3.17
    ```
7. Selanjutnya masuk ke container db yang sudah dibuat dengan perintah
    ```bash
   docker exec -it <container_id> bash
   
   psql -U postgres
   
   postgres=# create database db_spring_sample_docker;
    ```

### Add Database, Open `application.properties`
```
spring.banner.location=banner.txt
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:postgresql://${DB_HOST}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.show-sql=true
```

### Build Project
```bash
mvn clean package -DskipTests
```

### Test Run After Build
```bash
DB_HOST=localhost:5433 DB_NAME=db_spring_sample_docker DB_USER=postgres DB_PASSWORD=P@ssw0rd java -jar target/spring-sample-docker-0.0.1-SNAPSHOT.jar
```
Pastikan aplikasi berjalan sesuai.

## Docker

### Dockerfile
```dockerfile
FROM openjdk:17-jdk-alpine
ADD target/spring-sample-docker-0.0.1-SNAPSHOT.jar spring-sample-docker-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/spring-sample-docker-0.0.1-SNAPSHOT.jar"]
```

### Docker Build
```bash
docker build -t todo-app-be .
```

### Docker Image
```bash
docker images

REPOSITORY             TAG       IMAGE ID       CREATED         SIZE
spring-sample-docker   latest    23bdf982b7ab   0 minutes ago   344MB
```

### Docker Run
```bash
docker run --network todo-app-network -e DB_HOST=todoappdb:5433 -e DB_NAME=db_spring_sample_docker -e DB_USER=postgres -e DB_PASSWORD=P@ssw0rd todo-app-be
```