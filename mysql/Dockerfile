# Usa la imagen oficial de MySQL como base
FROM mysql:8.0

# Copia el script de inicialización al contenedor
COPY init.sql /docker-entrypoint-initdb.d/

# Configura las variables de entorno (se pueden sobrescribir si se pasan al iniciar el contenedor)
ENV MYSQL_ROOT_PASSWORD=123456DAW.
ENV MYSQL_DATABASE=listaProductos


# Comando por defecto para iniciar MySQL
CMD ["mysqld"]