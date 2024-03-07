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

 Endpoints de la API
A continuación se muestran los endpoints disponibles para acceder a través de Postman:

Cliente
Obtener todos los clientes: GET /cliente/getAll
Obtener cliente por ID: GET /cliente/byId/{id}
Guardar cliente: POST /cliente/save
Actualizar cliente por ID: PUT /cliente/updateId/{id}
Eliminar cliente por ID: DELETE /cliente/deleteId/{id}

Comprobante
Obtener todos los comprobantes: GET /comprobante/getAll
Obtener comprobante por ID: GET /comprobante/byId/{id}
Realizar una compra: POST /comprobante/comprar
Actualizar comprobante por ID: PUT /comprobante/updateId/{id}
Eliminar comprobante por ID: DELETE /comprobante/deleteId/{id}
Obtener productos totales vendidos: GET /comprobante/prodTotales/Vendidos

Producto
Obtener todos los productos: GET /producto/getAll
Obtener producto por ID: GET /producto/byId/{id}
Guardar producto: POST /producto/save
Actualizar producto por ID: PUT /producto/updateId/{id}
Eliminar producto por ID: DELETE /producto/deleteId/{id}
Información Adicional
Se utiliza una API externa para obtener la hora y la fecha actual. La URL es: http://worldclockapi.com/api/json/utc/now y se accede mediante RestTemplate.
Para acceder a la documentación de la API utilizando Swagger, visita: http://localhost:8080/swagger-ui/index.html#
Se proporcionan scripts SQL (data.sql y schema.sql) para cargar tablas y datos en la base de datos de manera manual, ya que no se realizan automáticamente.

 
 
 
 

  
 
