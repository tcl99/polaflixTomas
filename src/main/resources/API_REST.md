# MODELO DE LA API REST

## Recurso: /usuarios/{usuario}

Verbos Aceptados: GET

- GET /usuarios/{usuario} - Devuelve todas las series del usuario: empezadas, terminadas y pendientes.
<hr>

Parámetros: no hay

<hr>

Respuestas:

- 200 Ok
- 404 Not Found
- 400 Bad Request
<hr>

Modelo de Respuesta:

```json
[
  [],
  [
    {
      "idSerie": 1,
      "info": {
        "categoria": "GOLD",
        "titulo": "The Office",
        "genero": "Comedia",
        "descripcion": "Serie de comedia sobre el día a día en la oficina",
        "creadores": null,
        "actores": ["Jenna Fischer", "Steve Carrell", "John Krasinski"]
      },
      "temporadas": [
        {
          "numero": 1,
          "capitulos": [
            {
              "numero": 22,
              "titulo": "Casino Night",
              "descripcion": "zzz",
              "enlace": null
            }
          ]
        },
        {
          "numero": 2,
          "capitulos": [
            {
              "numero": 22,
              "titulo": "Casino Night",
              "descripcion": "zzz",
              "enlace": null
            }
          ]
        },
        {
          "numero": 3,
          "capitulos": [
            {
              "numero": 22,
              "titulo": "Casino Night",
              "descripcion": "zzz",
              "enlace": null
            }
          ]
        },
        {
          "numero": 4,
          "capitulos": [
            {
              "numero": 22,
              "titulo": "Casino Night",
              "descripcion": "zzz",
              "enlace": null
            }
          ]
        },
        {
          "numero": 5,
          "capitulos": [
            {
              "numero": 22,
              "titulo": "Casino Night",
              "descripcion": "zzz",
              "enlace": null
            }
          ]
        },
        {
          "numero": 6,
          "capitulos": [
            {
              "numero": 22,
              "titulo": "Casino Night",
              "descripcion": "zzz",
              "enlace": null
            }
          ]
        },
        {
          "numero": 7,
          "capitulos": [
            {
              "numero": 22,
              "titulo": "Casino Night",
              "descripcion": "zzz",
              "enlace": null
            }
          ]
        }
      ]
    },
    {
      "idSerie": 3,
      "info": {
        "categoria": "SILVER",
        "titulo": "Oasis",
        "genero": "Musica",
        "descripcion": "Documental sobre la banda británica",
        "creadores": ["Jenna Fischer", "Steve Carrell", "John Krasinski"],
        "actores": ["Bonehead", "Guigsy", "Alan White", "Liam", "Noel"]
      },
      "temporadas": [
        {
          "numero": 1,
          "capitulos": [
            {
              "numero": 1,
              "titulo": "Maybeee",
              "descripcion": "Descrpcion",
              "enlace": null
            },
            {
              "numero": 2,
              "titulo": "Slide Away",
              "descripcion": "Descrpcion",
              "enlace": null
            },
            {
              "numero": 3,
              "titulo": "Cloudburst",
              "descripcion": "Descrpcion",
              "enlace": null
            },
            {
              "numero": 4,
              "titulo": "Songbird",
              "descripcion": "Descrpcion",
              "enlace": null
            }
          ]
        },
        {
          "numero": 2,
          "capitulos": [
            {
              "numero": 1,
              "titulo": "Maybeee",
              "descripcion": "Descrpcion",
              "enlace": null
            },
            {
              "numero": 2,
              "titulo": "Slide Away",
              "descripcion": "Descrpcion",
              "enlace": null
            },
            {
              "numero": 3,
              "titulo": "Cloudburst",
              "descripcion": "Descrpcion",
              "enlace": null
            },
            {
              "numero": 4,
              "titulo": "Songbird",
              "descripcion": "Descrpcion",
              "enlace": null
            }
          ]
        },
        {
          "numero": 3,
          "capitulos": [
            {
              "numero": 1,
              "titulo": "Maybeee",
              "descripcion": "Descrpcion",
              "enlace": null
            },
            {
              "numero": 2,
              "titulo": "Slide Away",
              "descripcion": "Descrpcion",
              "enlace": null
            },
            {
              "numero": 3,
              "titulo": "Cloudburst",
              "descripcion": "Descrpcion",
              "enlace": null
            },
            {
              "numero": 4,
              "titulo": "Songbird",
              "descripcion": "Descrpcion",
              "enlace": null
            }
          ]
        }
      ]
    }
  ],
  []
]
```

## Recurso: /usuarios/{usuario}/facturas

Verbos Aceptados: GET

- GET /usuarios/{usuario}/facturas - Devuelve la factura del mes indicado

<hr>

Parámetros:

- fecha: fecha del mes de la factura

<hr>

Respuestas:

- 200 Ok
- 400 Bad Request
- 404 Not Found
<hr>

Modelo de Respuesta:

```json
{
  "fecha": "2023-07",
  "importeMensual": 3.0,
  "importes": [
    {
      "fechaVisualizacion": "2023-07-01",
      "nombreSerie": "The Office",
      "nTemporada": 1,
      "nCapitulo": 22,
      "cargo": 1.5
    },
    {
      "fechaVisualizacion": "1789-07-13",
      "nombreSerie": "The Office",
      "nTemporada": 2,
      "nCapitulo": 22,
      "cargo": 1.5
    }
  ]
}
```

## Recurso: /usuarios/{usuario}/series/capitulos

Verbos Aceptados: GET

- GET /usuarios/{usuario}/series/capitulos - Devuelve los capitulos vistos de un usuario

<hr>

Parámetros:

- fecha: fecha del mes de la factura

<hr>

Respuestas:

- 200 Ok
- 400 Bad Request
- 404 Not Found
<hr>

Modelo de Respuesta:

```json
[16, 24]
```

## Recurso: /usuarios/{usuario}/series

Verbos Aceptados: PUT

- PUT /usuarios/{usuario}/series - Agrega una serie a la lista de pendientes del usuario

<hr>

Parámetros:

- serie: la serie a agregar

<hr>

Respuestas:

- 200 Ok
- 400 Bad Request
- 404 Not Found
<hr>

## Recurso: /usuarios/{usuario}/series/{idCapitulo}

Verbos Aceptados: PUT

- PUT /usuarios/{usuario}/series/{idCapitulo} - Agrega una serie a la lista de pendientes del usuario

<hr>

Parámetros:

- No hay

<hr>

Respuestas:

- 200 Ok
- 400 Bad Request
- 404 Not Found
<hr>

## Recurso: /series

Verbos Aceptados: GET

- GET /series - Devuelve todas las series si no hay parámetro, si lo hay, devuelve una serie si el parámetro es un título, o una lista de series si

<hr>

Parámetros:

- titulo: Si es una letra o dígito, devuelve la lista de series que empiece por dicho caracter, si es un nombre, devuelve la serie que coincida con ese nombre y si está vacio, devuelve todas las series.

<hr>

Respuestas:

- 200 Ok
- 204 No Content
- 400 Bad Request
- 404 Not Found
<hr>

Modelo de Respuesta:

```json
[
  {
    "idSerie": 3,
    "info": {
      "categoria": "SILVER",
      "titulo": "Oasis",
      "genero": "Musica",
      "descripcion": "Documental sobre la banda británica",
      "creadores": ["Jenna Fischer", "Steve Carrell", "John Krasinski"],
      "actores": ["Bonehead", "Guigsy", "Alan White", "Liam", "Noel"]
    },
    "temporadas": [
      {
        "numero": 1,
        "capitulos": [
          {
            "numero": 1,
            "titulo": "Maybeee",
            "descripcion": "Descrpcion",
            "enlace": null
          },
          {
            "numero": 2,
            "titulo": "Slide Away",
            "descripcion": "Descrpcion",
            "enlace": null
          },
          {
            "numero": 3,
            "titulo": "Cloudburst",
            "descripcion": "Descrpcion",
            "enlace": null
          },
          {
            "numero": 4,
            "titulo": "Songbird",
            "descripcion": "Descrpcion",
            "enlace": null
          }
        ]
      },
      {
        "numero": 2,
        "capitulos": [
          {
            "numero": 1,
            "titulo": "Maybeee",
            "descripcion": "Descrpcion",
            "enlace": null
          },
          {
            "numero": 2,
            "titulo": "Slide Away",
            "descripcion": "Descrpcion",
            "enlace": null
          },
          {
            "numero": 3,
            "titulo": "Cloudburst",
            "descripcion": "Descrpcion",
            "enlace": null
          },
          {
            "numero": 4,
            "titulo": "Songbird",
            "descripcion": "Descrpcion",
            "enlace": null
          }
        ]
      },
      {
        "numero": 3,
        "capitulos": [
          {
            "numero": 1,
            "titulo": "Maybeee",
            "descripcion": "Descrpcion",
            "enlace": null
          },
          {
            "numero": 2,
            "titulo": "Slide Away",
            "descripcion": "Descrpcion",
            "enlace": null
          },
          {
            "numero": 3,
            "titulo": "Cloudburst",
            "descripcion": "Descrpcion",
            "enlace": null
          },
          {
            "numero": 4,
            "titulo": "Songbird",
            "descripcion": "Descrpcion",
            "enlace": null
          }
        ]
      }
    ]
  }
]
```
