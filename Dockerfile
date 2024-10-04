# Use uma imagem base do Java
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR da aplicação para o diretório de trabalho
COPY target/controle_saida_caminhao-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta que sua aplicação Spring Boot usará
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
