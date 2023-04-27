# polaflixTomas

## POJOs

Se ha cambiado de un único conjunto de Series en Usuario a tres, he decidido que el usuario sea quien separe el estado de las series y que no se haga en la clase Series, que puede causar problemas, pues un Usuario puede haber visto una serie y otro no

### Correciones de la revisión

- Cambiadas visibilidades de los constructores vacios a **protected**
- Tipo de parámetros cambiados a interfaces generales (~~ArrayList~~ --> List)
- HashCode y equals optimizados (solo hace falta realizarlos con los campos ID, que son únicos para cada instancia)
- Ahora agregarSerie() comprueba que la serie que se agregue a pendientes no esté empezada o terminada
- Operaciones no relacionadas con el modelo de dominio (interfaces) eliminadas

### Pendiente

- No hay consistencia en el uso de private y protected para la visibilidad de las propiedades .
- Duda sobre la validez de getEstado en VisualizacionCapitulo (El capitulo se puede desmarcar como visto?)

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
- Para todos los demas entities, se ha decidido generar un ID automáticamente, ya que puede ser que los valores de sus propiedades sean iguales (Antes Factura e Importe utilizaban Date como id, pero se ha observado que no es adecuado)

### Herencia

No se utiliza herencia en este sistema

### Asociaciones

Para comenzar, todos los Value Objects que son referenciados por alguna clase, están marcados en la misma como @Embedded

En este sistema hay únicamente relaciones @OneToMany y no son bidireccionales.
Tanto en Series, Temporadas y Capítulo como en Facturación y Factura se ha decidido implementar el:

```
cascade = CascadeType.ALL,
```

Se busca consistencia, puesto que es esencial que cada elemento de los nombrados, ya sea un Importe o un Capítulo, se guarde y guarde a sus hijos, porque son esenciales para su conjunto, ya sean los Capítulos para las Temporadas, y a su vez a las Series, de la misma forma que Importes, Factura y Facturación

(**ANTES**) La característica:

```
fetch = FetchType.LAZY
```

(**DESPUÉS**) Por problemas y mal uso relacionados con la anterior, se ha decido eliminar. Se ha decidido no poner nada o en casos concretos utilizar:

```
fetch = FetchType.EAGER
```

No se han realizado personalizaciones de momento de ningún tipo, a la espera de consejos y cambios en los errores que haya.

### Repositories

Se ha decidido crear 3 repositorios:

- Usuario: El que gestionará las transacciones para los usuarios
- Serie: El que gestionará todo lo relacionado con las series y sus temporadas y capítulos
- Factura: El que gestionará cada factura con su lista de importes

De momento estos tres se consideran los justos y necesarios para sostener la persistencia del sistema, ya que cada elemento clave tiene su propio repositorio.

Se han añadido los primeros métodos de búsqueda, basados en personalización por nombre, se espera añadir más según vayan surgiendo distintas necesidades

### Correciones de la revisión

- Eliminada la característica de FetchType.LAZY de todo el código (Al probar el feeder daba problemas)
- Se ha cambiado las relaciones de las series en Usuario y Catalogo (~~@OneToMany~~ --> @ManyToMany), ya que las series pueden estar agregadas por más de un usuario a la vez
- Eliminadas Catalogo y Facturacion, no se ha visto su utilidad practica. Ahora Usuario tiene un List<Factura>

### Otros cambios relevantes

- Ahora VisualizacionCapitulo es un Entity que sirve para que cada Usuario pueda marcar un Capitulo visto o no de forma única.
- Añadido CategoriaSerie como una enumeración para mejor compresión

## Servicio: REST

### Modelo API REST
