#Proyecto spring boot para una biblioteca
***
###Ide de desarrollo
* Spring Tool Suite
###Base de datos
*MySQL Workbench

***
## Solucion de la aplicacion
* Al principio se había pensado realizar una relacion con roles y perfiles para controlar el registro de libros y autores, el modelo se diseñó de esa manera,
  se registrarían los permiso y desde el front-end se controlaba quien tenia los permisos para registrar o editar. Sin embargo en la solucion que presento si se controla el registro de autores y libros segun los requerimientos que me han proporcionado.

* Cada metodo para guardar solo guarda los datos que le pertenecen a esa tabla, no hay metodos de guardado anidado.
* Todas las dependencias que se han implementado para esta aplicacion estan definidas en el pom.xml
* Las credenciales utilizadas para el envio de correo son personales, quise agregarlas al .gitignore pero opte por no hacerlo para que no exista ningun inconveniente al momento de ejecutar el programa.
*adjunte el diagrama y la base de datos con los registros que utilice en la contruccion de esta aplicacion en una carpeta dentro de la aplicacion de spring(scripts, database) 

## Diagrama Modelo Entidad Relacion Hoteles
* La solucion se encuentra en diagrams/hoteles_db tanto el diagrama que se implemento en workbench como un pdf del mismo.

## Consultas SQL Sistema de Informacion
* Los archivos se encuntran dentro de la aplicacion Diagrams/informacion_db Dentro de esta carpeta se encuentra la base de datos con los registros que se utilizaron para las consultas, de igual manera se encuantra el scripts con las consultas que se genero de los requerimientos que me pedian.
