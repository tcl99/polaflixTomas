# polaflixTomas

## JPA

### La lista queda así:

#### ENTITIES

- Usuario
- Serie
- Temporada
- Capitulo
- Factura
- Importe
- VisualizacionCapitulo

#### VALUE OBJECTS

- InformacionSerie

### IDs

- Usuario: Se ha decidido el nombre de usuario, pues será único para cada uno en el sistema
- Para todos los demas entities, se ha decidido generar un ID automáticamente, ya que puede ser que los valores de sus propiedades sean iguales (Antes Factura e Importe utilizaban Date como id, pero se ha observado que no es adecuado)

### Herencia

No se utiliza herencia en este sistema

### Asociaciones

Para comenzar, todos los Value Objects que son referenciados por alguna clase, están marcados en la misma como @Embedded

En este sistema casi todas las relaciones son unidireccionales.
Tanto en Series, Temporadas y Capítulo como en Facturación y Factura se ha decidido implementar el:

```
cascade = CascadeType.ALL,

```

Se busca consistencia, puesto que es esencial que cada elemento de los nombrados, ya sea un Importe o un Capítulo, se guarde y guarde a sus hijos, porque son esenciales para su conjunto, ya sean los Capítulos para las Temporadas, y a su vez a las Series, de la misma forma que Importes, Factura y Facturación.

La única relación bidireccional es la de Usuario y VisualizacionCapitulo, donde usuario es la entidad propietaria y mapea los capítulos visualizados por "usuario" de VisualizacionCapitulo.

### Repositories

Se ha decidido crear 2 repositorios, uno por cada aggregate root:

- Usuario: El que gestionará las transacciones para los usuarios
- Serie: El que gestionará todo lo relacionado con las series y sus temporadas y capítulos

## Servicio: REST

### Modelo API REST

### ACTUALIZACIONES IMPORTANTES

- Se ha eliminado el repositorio de Facturas, no se considera necesario pues las facturas se cargan con el usuario

# PEMDIENTE CORREGIR TODOS LOS ERRORES
