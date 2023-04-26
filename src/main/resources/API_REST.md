# MODELO DE LA API REST

## Series

1. ### Recurso: /series
     
    Verbos Aceptados: GET
    - GET /series - Devuelve todas las series.

    <hr>

    Parámetros: No hay
    
    <hr>

    Respuestas: 
    - 200 Ok 
    - 400 Bad Request
    <hr>

    Modelo de Respuesta:
    ```

    [
        {
            "id": 1,
            "titulo": "The Office",
            "categoria": GOLD,
            "genero": "comedia",
            "descripcion": "Serie de comedia sobre el día a día en la oficina",
            "creadores": ["Ricky Gervais", "Stephen Merchant"],
            "actores":["Jenna Fischer", "Steve Carrell", "John Krasinski"]
        },
        {
            "id": 2,
            "titulo": "Sons of Anarchy",
            "categoria": GOLD,
            "genero": "drama",
            "descripcion": "La serie se centra en la vida de Jackson "Jax" Teller, un joven miembro del club de motoristas SAMCRO que comienza a cuestionarse los actos del club y los suyos propios",
            "creadores": ["Kurt Sutter"],
            "actores":["Charlie Hunnam", "Katey Sagal", "Ron Perlman"]
        }
            {
            "id": 3,
            "titulo": "Breaking Bad",
            "categoria": GOLD,
            "genero": "drama",
            "descripcion": "La serie narra las historias de Walter White, un profesor de química que después de ser diagnosticado de un cáncer pulmonar inoperable termina vendiendo metanfetamina, y de Jesse Pinkman, su exalumno. Breaking Bad y su reparto estuvieron durante cinco años en boca de todos",
            "creadores": ["Vince Gilligan"],
            "actores":["Bryan Cranston", "Aaron Paul"]
        }
    ]

    ```
        DUDAS: 
        - Incluir directamente temporadas o buscar más adelante con otros recursos 
        - Devolver una única serie con el título


2. ### Recurso: /series/{titulo} 
    Verbos Aceptados: GET

    - GET /series/{titulo}  - Devuelve la serie que coincide con ese título.

    <hr>

    Parámetros:
    - Título: Nombre de la serie

    <hr>

    Respuestas: 
    - 200 Ok 
    - 400 Bad Request
    - 404 Not Found
    
    <hr>

    Modelo de Respuesta:
    ```

    [
        {
            "id": 1,
            "titulo": "The Office",
            "categoria": GOLD,
            "genero": "comedia",
            "descripcion": "Serie de comedia sobre el día a día en la oficina",
            "creadores": ["Ricky Gervais", "Stephen Merchant"],
            "actores":["Jenna Fischer", "Steve Carrell", "John Krasinski"]
        }
    ]
    
    ```
3. ### Recurso: /series/{genero} 
    Verbos Aceptados: GET

    - GET /series/{genero}  - Devuelve todas las series del genero.

    <hr>

    Parámetros:
    - Género: Tipo de serie según su género (Drama, comedia, etc)

    <hr>

    Respuestas: 
    - 200 Ok 
    - 400 Bad Request
    - 404 Not Found
    
    <hr>

    Modelo de Respuesta:
    ```
    [
        {
            "id": 2,
            "titulo": "Sons of Anarchy",
            "categoria": GOLD,
            "genero": "drama",
            "descripcion": "La serie se centra en la vida de Jackson "Jax" Teller, un joven miembro del club de motoristas SAMCRO que comienza a cuestionarse los actos del club y los suyos propios",
            "creadores": ["Kurt Sutter"],
            "actores":["Charlie Hunnam", "Katey Sagal", "Ron Perlman"]
        }
            {
            "id": 3,
            "titulo": "Breaking Bad",
            "categoria": GOLD,
            "genero": "drama",
            "descripcion": "La serie narra las historias de Walter White, un profesor de química que después de ser diagnosticado de un cáncer pulmonar inoperable termina vendiendo metanfetamina, y de Jesse Pinkman, su exalumno. Breaking Bad y su reparto estuvieron durante cinco años en boca de todos",
            "creadores": ["Vince Gilligan"],
            "actores":["Bryan Cranston", "Aaron Paul"]
        }
    ]
    
    ```
