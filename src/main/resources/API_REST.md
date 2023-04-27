# MODELO DE LA API REST

## Recurso: /inicio

Verbos Aceptados: GET

- GET /inicio - Devuelve todas las series del usuario: empezadas, terminadas y pendientes.
<hr>

Parámetros: No hay

<hr>

Respuestas:

- 200 Ok
<hr>

Modelo de Respuesta:

```json
{
  "empezadas": [
    {
      "id": 1,
      "titulo": "The Office",
      "categoria": 2,
      "genero": "comedia",
      "descripcion": "Serie de comedia sobre el día a día en la oficina",
      "creadores": ["Ricky Gervais", "Stephen Merchant"],
      "actores": ["Jenna Fischer", "Steve Carrell", "John Krasinski"]
    }
  ],
  "terminadas": [
    {
      "id": 2,
      "titulo": "Sons of Anarchy",
      "categoria": 2,
      "genero": "drama",
      "descripcion": "La serie se centra en la vida de Jackson 'Jax' Teller, un joven miembro del club de motoristas SAMCRO que comienza a cuestionarse los actos del club y los suyos propios",
      "creadores": ["Kurt Sutter"],
      "actores": ["Charlie Hunnam", "Katey Sagal", "Ron Perlman"]
    },
    {
      "id": 3,
      "titulo": "Breaking Bad",
      "categoria": 2,
      "genero": "drama",
      "descripcion": "La serie narra las historias de Walter White, un profesor de química que después de ser diagnosticado de un cáncer pulmonar inoperable termina vendiendo metanfetamina, y de Jesse Pinkman, su exalumno. Breaking Bad y su reparto estuvieron durante cinco años en boca de todos",
      "creadores": ["Vince Gilligan"],
      "actores": ["Bryan Cranston", "Aaron Paul"]
    }
  ],
  "pendientes": []
}
```

## Recurso: /catalogo

Verbos Aceptados: GET

- GET /catalogo - Devuelve todas las series.

<hr>

Parámetros: No hay

<hr>

Respuestas:

- 200 Ok
<hr>

Modelo de Respuesta:

```json
[
  {
    "id": 1,
    "titulo": "The Office",
    "categoria": 2,
    "genero": "comedia",
    "descripcion": "Serie de comedia sobre el día a día en la oficina",
    "creadores": ["Ricky Gervais", "Stephen Merchant"],
    "actores": ["Jenna Fischer", "Steve Carrell", "John Krasinski"]
  },
  {
    "id": 2,
    "titulo": "Sons of Anarchy",
    "categoria": 2,
    "genero": "drama",
    "descripcion": "La serie se centra en la vida de Jackson 'Jax' Teller, un joven miembro del club de motoristas SAMCRO que comienza a cuestionarse los actos del club y los suyos propios",
    "creadores": ["Kurt Sutter"],
    "actores": ["Charlie Hunnam", "Katey Sagal", "Ron Perlman"]
  },
  {
    "id": 3,
    "titulo": "Breaking Bad",
    "categoria": 2,
    "genero": "drama",
    "descripcion": "La serie narra las historias de Walter White, un profesor de química que después de ser diagnosticado de un cáncer pulmonar inoperable termina vendiendo metanfetamina, y de Jesse Pinkman, su exalumno. Breaking Bad y su reparto estuvieron durante cinco años en boca de todos",
    "creadores": ["Vince Gilligan"],
    "actores": ["Bryan Cranston", "Aaron Paul"]
  }
]
```

## Recurso: /catalogo/{titulo}

Verbos Aceptados: GET

- GET /catalogo/{titulo} - Devuelve la serie que coincide con ese título.

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

```json
   {
        "id": 1,
        "titulo": "The Office",
        "categoria": 2,
        "genero": "comedia",
        "descripcion": "Serie de comedia sobre el día a día en la oficina",
        "creadores": ["Ricky Gervais", "Stephen Merchant"],
        "actores":["Jenna Fischer", "Steve Carrell", "John Krasinski"],
        "temporadas": [
            "1": [
                {
                    "id": 1,
                    "titulo": "Pilot",
                    "numero": 1,
                    "descripcion": "zzz",
                    "enlace": "link",
                },
                {
                    "id": 2,
                    "titulo": "Diversity Day",
                    "numero": 2,
                    "descripcion": "zzz",
                    "enlace": "link",
                }
            ],
            "2": [
                {
                    "id": 3,
                    "titulo": "The Dundies",
                    "numero": 1,
                    "descripcion": "zzz",
                    "enlace": "link",
                }
            ]
        ]
    }

```

## Recurso: /catalogo/{inicial}

Verbos Aceptados: GET

- GET /series/{inicial} - Devuelve las series que comienzan por la inicial

Parámetros:

- inicial: Primera letra del título de la serie

<hr>

Respuestas:

- 200 Ok
- 400 Bad Request
- 404 Not Found

<hr>

Modelo de Respuesta:

```json
[
  {
    "id": 1,
    "titulo": "The Office",
    "categoria": 2,
    "genero": "comedia",
    "descripcion": "Serie de comedia sobre el día a día en la oficina",
    "creadores": ["Ricky Gervais", "Stephen Merchant"],
    "actores": ["Jenna Fischer", "Steve Carrell", "John Krasinski"]
  },
  {
    "id": 12,
    "titulo": "The Good Doctor",
    "categoria": 1,
    "genero": "drama",
    "descripcion": "Serie sobre la vida de un médico genio con autismo",
    "creadores": ["David Shore"],
    "actores": ["Freddie Highmore"]
  }
]
```

## Recurso: /catalogo/{id}

Verbos Aceptados: PUT, GET

- GET /series/{id} - Devuelve serie por id
- PUT /series/{id} - Agregar serie a pendientes

Parámetros:

- ID: Identificador de la serie

<hr>

Respuestas:

- 200 Ok
- 204 No Content
- 400 Bad Request
- 404 Not Found

<hr>

Modelo de Respuesta:

```json
    {
        "id": 1,
        "titulo": "The Office",
        "categoria": 2,
        "genero": "comedia",
        "descripcion": "Serie de comedia sobre el día a día en la oficina",
        "creadores": ["Ricky Gervais", "Stephen Merchant"],
        "actores":["Jenna Fischer", "Steve Carrell", "John Krasinski"],
        "temporadas": [
            "1": [
                {
                    "id": 1,
                    "titulo": "Pilot",
                    "numero": 1,
                    "descripcion": "zzz",
                    "enlace": "link",
                },
                {
                    "id": 2,
                    "titulo": "Diversity Day",
                    "numero": 2,
                    "descripcion": "zzz",
                    "enlace": "link",
                }
            ],
            "2": [
                {
                    "id": 3,
                    "titulo": "The Dundies",
                    "numero": 1,
                    "descripcion": "zzz",
                    "enlace": "link",
                }
            ]
        ]
    }
```

## Recurso: /facturas/{date}

Verbos Aceptados: GET

- GET /facturas/{date} - Devuelve la factura del mes indicado

<hr>

Parámetros: Fecha de la factura

<hr>

Respuestas:

- 200 Ok
- 400 Bad Request
- 404 Not Found
<hr>

Modelo de Respuesta:

```json
    {
        "id": 1,
        "fecha": 2023-04-1T15:30:43.511Z,
        "importe_mensual": 20.0,
        "importes": [
            {
                "id": 1,
                "cargo": 1.5,
                "fecha_visualizacion": 2023-04-2T15:30:43.511Z,
                "n_capitulo": 22,
                "n_temporada": 1,
                "nombre_serie": "The Office"
            },
            {
                "id": 2,
                "cargo": 1.5,
                "fecha_visualizacion": 2023-04-3T15:30:43.511Z,
                "n_capitulo": 1,
                "n_temporada": 2,
                "nombre_serie": "The Office"
            }
        ]
    }
```
