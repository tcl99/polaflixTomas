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