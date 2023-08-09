# Gestion-de-cursos-online

Proyecto multimodulo de microservicios con Spring Boot, Spring Cloud y Docker que esta compuesto por tres microservicios principales que se encargan de la logica del mismo los cuales son:

- requesService: microservicio encargado de gestionar la solicitudes de creacion de cursos online, se usa Postgresql como base de datos

- userService: microservicio encargado de la gestion de usuarios con un ejemplo sencillo de manejo de excepciones, se usa redis para almacenamiento en cache, tiene test simples y se usa Postgresql como base de datos

- courseService: microservicio encargado de la gestion de cursos, se implementa un swagger, es el que se enlaza con el microservicio de notificacion a travez de kafka y se usa una conexion a una base de datos MongoDB


Otros complementos del proyecto son:

- eurekaServer: descubridor de microservicios

- apiGateway: puerta de salida y entrada de las solicitudes

- configServer: acceder las configuraciones centralizadas presentes en el repo serviceConfiguration

- notificatioServer: muestra un mensaje de notificacion cada vez que se cree un curso

#  Requerimientos para ejecutar el proyecto

- tener Docker instalado pues la mayoria de los servicios se desplegan con esa herramienta.

- en el proyecto padre, en un terminal, escribir el siguiente comando para ejecutar los componentes dockerizados
  > docker-compose up


