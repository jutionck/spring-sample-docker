## Spring Sample Docker

### Clone Project
```bash
git clone https://github.com/jutionck/spring-sample-docker.git
```

### Checkout Branch
```bash
git checkout 2-with-db
```

### Note
1. Karena sudah menggunakan database dan ingin dijalankan dengan docker maka databasenya kita buat juga dengan image docker.
2. Silahkan pull image postgres dengan perintah `docker pull postgres:alpine3.17` (untuk versi image bebas).
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
## Spring Boot Configuration
### Open `application.properties`
```
spring.banner.location=banner.txt
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.show-sql=true
```

Di atas kita menggunakan sebuah `environment` maka ketika melakukan build project harus kita skip untuk TEST nya.

### Build Project
```bash
mvn clean package -DskipTests
```

### Build Project and Set Env
```bash
DB_HOST=localhost DB_PORT=5433 DB_NAME=postgres DB_USER=postgres DB_PASSWORD=P@ssw0rd mvn clean package
```

### Run After Build
```bash
DB_HOST=localhost DB_PORT=5433 DB_NAME=postgres DB_USER=postgres DB_PASSWORD=P@ssw0rd java -jar target/spring-sample-docker-0.0.1-SNAPSHOT.jar
```
Pastikan aplikasi berjalan sesuai.

## Docker

### Docker Network
```bash
docker network ls

NETWORK ID     NAME               DRIVER    SCOPE
31119e8c43dd   bridge             bridge    local
70f7dde2381c   host               host      local
604b0b5a51f2   none               null      local
7dc1ddb29f45   todo-app-network   bridge    local
```
Gunakan `network` `todo-app-network` agar sama seperti container database.

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
todo-app-be   latest    23bdf982b7ab   0 minutes ago   344MB
```

### Docker Run
```bash
docker run --network todo-app-network -e DB_HOST=todo-app-db DB_PORT=5432 -e DB_NAME=db_spring_sample_docker -e DB_USER=postgres -e DB_PASSWORD=P@ssw0rd --rm todo-app-be
```
Catatan:
1. Untuk `DB_HOST` kita gunakan container database yang aktif.
2. Untuk `DB_PORT` kita gunakan port default dari container database.
3. Pertanyaan nya kan kita sudah melakukan expose port db keluar ya. Jika memang tetap ingin gunakan port yang diexpose maka gunakan IP komputer untuk di bagian `DB_HOST`.