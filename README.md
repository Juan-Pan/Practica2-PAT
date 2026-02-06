# API REST de gestion de Carritos de compras
## Descripción
Esta práctica es un abrebocas para las tecnologías de desarrollo de aplicaciones que se verán a lo largo del curso, en este caso
se implementa una API REST para la gestión de carritos de compras.

## Campos del carrito de compras
- idCarrito(Long): Identificador único del carrito de compras(PK).
- idArticulo(String): Identificador del artículo que se agrega al carrito.
- descripción(String): Descripción del artículo.
- numeroUnidades(Integer): Cantidad del artículo que se agrega al carrito.
- precioFinal(Double): Precio del artículo final.

## Tecnologías usadas
- java 17
- spring boot 3.0.5
- maven
- postman
## Endpoints
| Método | Endpoint | Descripción | Posibles respuestas                           |
|--------| --- | --- |-----------------------------------------------|
| POST   | /api/carritos | Crea un nuevo carrito de compras. | 201: Created. 400: Bad Request: Json invalido | 
| GET    | /api/carritos/{id} | Obtiene un carrito de compras por su ID. | 200: OK. 404: Not Found: Carrito no encontrado|
| PUT    | /api/carritos/{id} | Actualiza un carrito de compras existente. | 200: OK. 400: Bad Request: Json invalido. 404: Not Found: Carrito no encontrado|
|DELETE  | /api/carritos/{id} | Elimina un carrito de compras por su ID. | 204: No Content. 404: Not Found: Carrito no encontrado|
## Dudas de palabras (Esto es más que todo para mí, ignórelo si es necesario profe)
- API REST: Es el que lleva y trae los datos del servidor, es el que maneja las peticiones y respuestas, usando las palabras clave de HTTP como GET, POST, PUT Y DELETE.
- END POINT: Es la URL (dirección específica) a la que se le hacen las peticiones (ejemplo: http://localhost:8080/api/carritos/1), es el punto de acceso de la API REST.
- POST: Es el método HTTP que se usa para crear un nuevo objeto o recurso en el servidor.
- GET: Es el método HTTP que se usa para obtener o recuperar un recurso del servidor.
- PUT: Es el método HTTP que se usa para actualizar un recurso existente en el servidor.
- DELETE: Es el método HTTP que se usa para eliminar un recurso del servidor.
- RECORD: Es una clase especial en java para almacenar datos inmutables, una vez que se crea un objeto de una clase record, no se pueden modificar sus campos. En este caso se hacía el PUT se creaba un nuevo objeto de la clase record con los nuevos datos, y se reemplazaba el objeto anterior en la lista de carritos.