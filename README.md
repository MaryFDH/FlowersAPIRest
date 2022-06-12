# FlowersAPIRest
API Rest

## Descripción
El proyecto está creado con el framework Springboot y sigue un patrón arquitectónico Modelo-Vista-Controlador. Se expone un API Rest con un conjunto de end-points y se añaden pruebas unitarias usando JUnit

## Endpoints
- POST: http://localhost:8080/flowers: Recibe un array de objetos Flower y se almacena en memoria:
  Body: [
    {
        "id":"swrd1",
        "name": "Margarita",
        "price": 40
    },
    {
        "id":"swef1",
        "name": "Clavel",
        "price": 20.5
    }
  ]
- GET: http://localhost:8080/flowers: Devuelve la lista de objetos Flower almacenada en memoria, ordenadas descendentemente por el atributo "name" y concatenada la cadena "-kometsales"
- GET: http://localhost:8080/flowers/price-filter: Devuelve una lista de objetos Flower cuyo precio sea mayor a 20
- DELETE: http://localhost:8080/flowers/{id}: Borra un objeto Flower de la lista, cuyo id sea el parámetro {id}
- GET: http://localhost:8080/flowers/{name}: Devuelve una lista de objetos Flower cuyo nombre coincida con el parámetro {name}

