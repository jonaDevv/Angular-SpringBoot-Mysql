# Usa la imagen base de Eclipse Temurin con Java 23
FROM eclipse-temurin:23-jdk

# Define el directorio de trabajo
WORKDIR /app

# Copia el archivo .jar generado al contenedor
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Copia el script wait-for-it.sh al contenedor (para esperar a MySQL)
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Exponer el puerto donde Spring Boot correrá
EXPOSE 8081

# Ejecutar la aplicación después de esperar a MySQL
CMD /wait-for-it.sh mysql:3306 -- java -jar app.jar
