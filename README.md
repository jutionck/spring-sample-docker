## Spring Sample Docker

### Clone Project
```bash
git clone https://github.com/jutionck/spring-sample-docker.git
```

### Checkout Branch
```bash
git checkout 3-with-compose
```

## Docker
Catatan:
1. Pastikan spring boot kita sudah di jadikan image
2. Pastikan database postgre sudah di pull
3. Jika belum ada image spring dan database silahkan ikuti perintah berikut (ikuti langkah 1 per 1).
```bash
mvn clean package -DskipTests

docker build -t todo-app-be .

docker pull postgres:alpine3.17
```
4. Setelah itu cek images yang sudah terbuat
```bash
doker images

REPOSITORY         TAG          IMAGE ID       CREATED       SIZE
todo-app-be        latest       06a57b6e9bfd   3 hours ago   366MB
postgres           alpine3.17   f8428074961e   7 days ago    243MB
```

### Docker Compose
Buka file `docker-compose.yml`
```yaml
version: '3.8'
services:
  backend:
    image: todo-app-be
    container_name: todo-be
    depends_on:
      - db
    environment:
      - DB_HOST=${DB_HOST}
      - DB_PORT=${DB_PORT}
      - DB_USER=${DB_USER}
      - DB_NAME=${DB_NAME}
      - DB_PASSWORD=${DB_PASSWORD}
    networks:
      - todo-network
  db:
    image: postgres:alpine3.17
    container_name: todo-db
    environment:
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=P@ssw0rd
    restart: always
    volumes:
      - db-data:/var/lib/postgresql/data
    networks:
      - todo-network
volumes:
  db-data:
networks:
  todo-network:
```

### Docker Compose Up
Untuk menjalankan ikuti perintah berikut
```bash
DB_HOST=todo-db DB_PORT=5432 DB_NAME=postgres DB_USER=postgres DB_PASSWORD=P@ssw0rd docker compose up
```
Pastikan aplikasi berjalan sesuai.

### Docker Compose Down
Untuk menjalankan ikuti perintah berikut
```bash
docker compose down
```