# APP PARA ADMINSITRAR PRODUCTOS CON ANGULAR-SPRING BOOT-MYSQL

Este proyecto es una **aplicación web** en la que el **Frontend** está hecho con **Angular**, el **Backend** con **Spring Boot**, y la **Base de Datos** con **MySQL**. La aplicación permite gestionar productos en una tabla, donde se pueden **añadir, actualizar, borrar y eliminar** productos. El frontend hace peticiones a una **API REST** de Spring Boot para interactuar con la base de datos.

Puedes usar el archivo `docker-compose.yml` para configura la infraestructura para la ejecución de los contenedores de los tres servicios:
**Frontend**, **Backend** (Spring Boot) y **MySQL**.

Las imagenes estan alojadas en DockerHub por lo que debe de poder hacer pull y ejecutar la app.

## Servicios Configurados

### 1. **Frontend**
El servicio de frontend está basado en una aplicación **Angular**. Esta aplicación hace peticiones a la API de Spring Boot para obtener los productos y permitir su gestión. La configuración del servicio es la siguiente:

- **Imagen**: Se utiliza la imagen `jonadevv/jrm-practicas-docker:frontend-1.0`, que contiene la aplicación Angular.
- **Puertos**: El contenedor expone el puerto `80` (interno) en el puerto `8000` de la máquina host, lo que permite acceder a la interfaz de usuario a través de `http://localhost:8000`.


### 2. **MySQL**
El servicio de base de datos está configurado con **MySQL**, que almacena la información de los productos. La configuración incluye:

- **Imagen**: Se utiliza la imagen `jonadevv/jrm-practicas-docker:mysql-1.0`, que contiene MySQL.
- **Variables de entorno**:
  - `MYSQL_ROOT_PASSWORD`: La contraseña del usuario `root` de MySQL, configurada como `123456DAW.`.
  - `MYSQL_DATABASE`: Se crea la base de datos `listaProductos` para almacenar la información de los productos.
- **Volúmenes**: El volumen persistente `mysql-data` asegura que los datos de la base de datos no se pierdan cuando el contenedor se detiene o reinicia.
- **Puertos**: El contenedor de MySQL expone el puerto `3306` en el puerto `3307` de la máquina host.
- **Healthcheck**: Configura una comprobación de salud para MySQL, verificando cada 10 segundos su estado.

### 3. **Backend**
El servicio de backend está basado en una aplicación **Spring Boot**, que proporciona una API REST para gestionar los productos. La configuración del servicio incluye:

- **Imagen**: Se utiliza la imagen `jonadevv/jrm-practicas-docker:backend-1.0`, que contiene la aplicación backend de Spring Boot.
- **Variables de entorno**:
  - `SPRING_DATASOURCE_URL`: La URL de conexión a la base de datos MySQL, apuntando a `mysql:3306` para acceder a la base de datos `listaProductos`.
  - `SPRING_DATASOURCE_USERNAME` y `SPRING_DATASOURCE_PASSWORD`: Credenciales para acceder a la base de datos MySQL.
- **Puertos**: El contenedor del backend expone el puerto `8080` (interno) en el puerto `8081` de la máquina host, lo que permite acceder a la API backend en `http://localhost:8081`.

## Trabajar con las imagenes en docker

Una vez que hayas creado y probado tus contenedores localmente, puedes subir las imágenes a Docker Hub para poder compartirlas o utilizarlas en otras máquinas. Aquí están los comandos para subir cada servicio:
### Crear la imagen del Backend
```bash
cd contenedorBack
docker build -t jonadevv/jrm-practicas-docker:backend-1.0 .
```
### Subir las imagen:
```bash
docker push jonadevv/jrm-practicas-docker:backend-1.0

docker push jonadevv/jrm-practicas-docker:frontend-1.0

docker push jonadevv/jrm-practicas-docker:mysql-1.0
```
### Lanzar los contenedores*:
```bash
docker compose up --build

```
### Redes

Se define una red personalizada llamada `app-network`, a la que se conectan todos los contenedores. Esto permite que los servicios frontend, backend y MySQL puedan comunicarse entre sí de manera segura y eficiente.

## Atención

**¡Importante!** Antes de ejecutar el proyecto, asegúrate de tener Docker y Docker Compose instalados en tu máquina. Además, si vas a trabajar con la base de datos, asegúrate de que las credenciales de acceso estén correctamente configuradas.

**¡Además!** Si no arranca el contenedor de backend, eliminar volumenes de docker.


Si encuentras algún problema al iniciar los contenedores, verifica que no haya procesos previos bloqueando los puertos necesarios o que la imagen de Docker esté actualizada.


