# polaflixTomas

@Component extends CommandLineRunner

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
