# polaflixTomas

## POJOs
  Se ha cambiado de un único conjunto de Series en Usuario a tres, he decidido que el usuario sea quien separe el estado de las series y que no se haga en la clase Series, que puede causar problemas, pues un Usuario puede haber visto una serie y otro no
## Actualización JPA
  Se ha decidido cambiar el tipo de clasificación de DDD en algunas clases:

#### Las siguientes pasan a ser ENTITIES:
 - Temporada

#### Las siguientes pasan a ser VALUE OBJECTS:
 - Catalogo
 - Facturacion

### La lista queda así:
 #### ENTITIES
  - Usuario
  - Serie
  - Temporada
  - Capitulo
  - Factura
  - Importe  
 #### VALUE OBJECTS
  - InformacionSerie
  - VisualizacionCapitulo
  - Catalogo
  - Facturacion 

### IDs
  - Usuario: Se ha decidido el nombre de usuario, pues será único para cada uno en el sistema
  - Para Serie, Temporada y Capitulo se ha decidio autogenerar un Id, pues sus títulos y numeración pueden ser repetidos
  - Factura: Será la fecha que merca el mes y el año, será imposible que coincida
  - Importe: Como la variable Date se mide en ms, es imposible que coincida la visualización, aunque se vea el mismo capítulo de forma seguida. (Sujeto a cambios si no es adecuado)

### Herencia
  No se utiliza herencia en este sistema

### Asociaciones
  Para comenzar, todos los Value Objects que son referenciados por alguna clase, están marcados en la misma como @Embedded

  En este sistema hay únicamente relaciones @OneToMany y no son bidireccionales.
  Tanto en Series, Temporadas y Capítulo como en Facturación y Factura se ha decidido implementar el:
  ```
    cascade = CascadeType.ALL, 
  ```
  Se busca consistencia, puesto que es esencial que cada elemento de los nombrados, ya sea un Importe o un Capítulo, se guarde y guarde a sus hijos, porque son esenciales para su onjunto, ya sean los Capítulos para las Temporadas, y a su vez a las Series, de la misma forma que Importes, Factura y Facturación

  La característica:
  ```
  fetch = FetchType.LAZY
  ```
  Se ha decidido implementar en aquellos casos en los que se carguen a memoria exclusivamente cuando sean demandados, en este caso los Capítulos en Temporada y las Facturas de Facturación, así como las series pendientes o terminadas, que se cree que serán menos demandas que las empezadas.

  No se han realizado personalizaciones de momento de ningún tipo, a la espera de consejos y cambios en los errores que haya.
 