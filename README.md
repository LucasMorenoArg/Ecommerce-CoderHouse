# Ecommerce-CoderHouse
-Descripcion: Proyecto ApiRest de CoderHouse
  Aplicacion Rest de Ecommerce utilizando Java y SpringBoot. El proyecto esta separado por capas y cada cuenta con su responsabilidad.
  
-Capa de Controlador (Controller): 
Para la capa controlador se usaron las CLASES:
ClienteController
ComprobanteController
ProductoController

-Capa de Servicio (Service):
Para la capa servicio se usaron las CLASES:
ClienteServiceImpl
ComprobanteServiceImpl
ProductoServiceImpl
Para la capa servicio se usaron las iNTERFACES:
ClienteService
ComprobanteService
ProductoService

-Capa de Acceso a Datos (Data Access):
Para la capa Acceso a Datos se usaron las iNTERFACES:
ClienteRepository
ComprobanteRepository
ProductoRepository

-Capa de Modelo (Entities):
Para la capa de modelos de usaron las siguiente CLASES:
Cliente
Comprobante
Producto

 -Endpoints para acceder desde Postman:
   Tipo                  Ruta
 GetMapping   http://localhost:8080/cliente/getAll 
 GetMapping   http://localhost:8080/cliente/byId/{id}
 PostMapping  http://localhost:8080/cliente//save
 PutMapping   http://localhost:8080/cliente/updateId/{id}
 DeleteMapping  http://localhost:8080/cliente/deleteId/{id}
 
 GetMapping   http://localhost:8080/comprobante/prodTotales/Vendidos
 GetMapping   http://localhost:8080/comprobante/getAll
 GetMapping   http://localhost:8080/comprobante/byId/{id}
 PostMapping  http://localhost:8080/comprobante/comprar
 PutMapping   http://localhost:8080/comprobante/updateId/{id}
 DeleteMapping  http://localhost:8080/comprobante/deleteId/{id}

 GetMapping   http://localhost:8080/producto/getAll
 GetMapping   http://localhost:8080/producto/byId/{id}
 PostMapping  http://localhost:8080/producto/save
 PutMapping   http://localhost:8080/producto/updateId
 DeleteMapping  http://localhost:8080/producto/deleteId/{id}

Info adicional:
Para la informacion de hora y fecha se usó api externa: http://worldclockapi.com/api/json/utc/now con restTemplate.
Ruta para acceder desde Swagger: http://localhost:8080/swagger-ui/index.html#/
Para cargar tablas y datos usar los scrips de los archivos de data.sql y schema.sql de forma manual ya que no se hacen de manera automatica.
 
 
 
 

  
 
