## Spring Sample Docker

### Clone Project
```bash
git clone https://github.com/jutionck/spring-sample-docker.git
```

### Build Project
```bash
mvn clean package
```

### Test Run After Build
```bash
java -jar target/<*.jar>
```

### Dockerfile
```dockerfile
FROM openjdk:17-jdk-alpine
ADD target/spring-sample-docker-0.0.1-SNAPSHOT.jar spring-sample-docker-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/spring-sample-docker-0.0.1-SNAPSHOT.jar"]
```

### Docker Build
```bash
docker build -t spring-sample-docker .
```

### Docker Image
```bash
docker images

REPOSITORY             TAG       IMAGE ID       CREATED         SIZE
spring-sample-docker   latest    23bdf982b7ab   0 minutes ago   344MB
```

### Docker Run
```bash
docker run spring-sample-docker


  _____       _                          ____
 | ____|_ __ (_) __ _ _ __ ___   __ _   / ___|__ _ _ __ ___  _ __
 |  _| | '_ \| |/ _` | '_ ` _ \ / _` | | |   / _` | '_ ` _ \| '_ \
 | |___| | | | | (_| | | | | | | (_| | | |__| (_| | | | | | | |_) |
 |_____|_| |_|_|\__, |_| |_| |_|\__,_|  \____\__,_|_| |_| |_| .__/
                |___/                                       |_|

2023-01-12T08:42:21.661Z  INFO 1 --- [           main] c.e.s.SpringSampleDockerApplication      : Starting SpringSampleDockerApplication v0.0.1-SNAPSHOT using Java 17-ea with PID 1 (/spring-sample-docker-0.0.1-SNAPSHOT.jar started by root in /)
2023-01-12T08:42:21.676Z  INFO 1 --- [           main] c.e.s.SpringSampleDockerApplication      : No active profile set, falling back to 1 default profile: "default"
2023-01-12T08:42:24.353Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-01-12T08:42:24.387Z  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-01-12T08:42:24.387Z  INFO 1 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.4]
2023-01-12T08:42:24.623Z  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-01-12T08:42:24.628Z  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2656 ms
2023-01-12T08:42:25.663Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-01-12T08:42:25.704Z  INFO 1 --- [           main] c.e.s.SpringSampleDockerApplication      : Started SpringSampleDockerApplication in 5.559 seconds (process running for 6.555)
Todo App
Todo{todoId='86b7dd56-6301-4d30-9066-4781c98a153e', name='Makan', isCompleted=false}

```