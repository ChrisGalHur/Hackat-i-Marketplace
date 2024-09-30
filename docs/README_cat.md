- [English Documentation](../README.md)
- [Documentación en Español](README_es.md)


# App de Gestió d'Usuaris i Activitats - Hackathon IT Academy
> Barcelona Activa en col·laboració amb la Mobile World Capital Barcelona van organitzar una
> Hackató de la mà de IT Academy on vaig tenir el plaer d'estudiar.
> 
> Per participar en la Hackató ens van demanar que realitzéssim aquesta prova tècnica.

[![NPM Version][npm-image]][npm-url]
[![Downloads Stats][npm-downloads]][npm-url]

[**Descripció del repte:**](#descripció-del-repte)
- [Requisits Funcionals](#requisits-funcionals)
- [Format dels endpoints](#format-dels-endpoints)
- [Format del JSON](#format-del-json)
- [Requisits Tècnics i avaluació](#requisits-tècnics-i-avaluació)

[**Descripció de l'API**](#descripció-de-lapi)
  - [Funcionalitats Principals](#funcionalitats-principals)
  - [La meva visió personal del projecte](#la-meva-visió-personal-del-projecte)


[**Instal·lació i Configuració**](#instal·lació-i-configuració)
- [Requisits previs](#requisits-previs)
- [Instal·lació:](#instal·lació)
  - [Pas 1: Clonar el repositori](#pas-1-clonar-el-repositori)
  - [Pas 2: Configuració de l'arxiu `application.properties`](#pas-2-configuració-de-larxiu-applicationproperties)
  - [Exemple de `application.properties`](#exemple-de-applicationproperties)

[**API Endpoints**](#api-endpoints)

[**Ús de l'API**](#ús-de-lapi)
- [Registre d'usuari](#registre-dusuari)
- [Autenticació d'usuari](#autenticació-dusuari)
- [Actualització de dades d'usuari](#actualització-de-dades-dusuari)
- [Consulta d'informació d'usuari](#consulta-dinformació-dusuari)
- [Eliminació d'usuari](#eliminació-dusuari)
- [Creació d'una nova activitat](#creació-duna-nova-activitat)
- [Eliminació d'una activitat](#eliminació-duna-activitat)
- [Consulta de totes les activitats](#consulta-de-totes-les-activitats)
- [Apuntar-se a una activitat](#apuntar-se-a-una-activitat)
- [Exportar activitats en format JSON](#exportar-activitats-en-format-json)
---

## Descripció del repte
El repte consisteix a desenvolupar una API per a una aplicació web que administre usuaris i activitats.
Ha de permetre el registre d'usuaris, la gestió de dades de les activitats 
i la importació/exportació d'aquestes activitats en format JSON.

### Requisits Funcionals
1. Gestió d'Usuaris: Pots utilitzar les dades dels usuaris que consideris: nom, cognoms,
   edat, email...
    - Registre de nous usuaris
    - Actualització de dades de l'usuari:
    - Eliminació d'usuaris
    - Consulta d'informació d'usuaris


2. Gestió d'activitats:
    - Creació d'una nova activitat
    - Consulta d'activitats
    - Apuntar-se a una activitat
   

3. Exportació d'activitats:
    - Exportar activitats en format JSON


4. Importació d'activitats:
    - Importar activitats des d'un arxiu JSON
   

5. Configuració de la Base de Dades:
    - Establir una connexió amb una base de dades, que pot ser MySQL o
      MongoDB, per emmagatzemar les dades d'usuaris i activitats.


### Format dels endpoints
Endpoints de l'apartat dels usuaris podent crear els endpoints necessaris per a la resta de l'aplicació:
- POST /appActivitats/user: Registre d'un nou usuari.
- PUT /appActivitats/users/:id: Actualització de les dades d'un usuari.
- GET /appActivitats/users/:id: Consulta de la informació d'un usuari.
- DELETE /appActivitats/users/:id: Eliminació d'un usuari.


### Format del JSON
El format de les activitats ha de complir la següent estructura:

```json
[
  {
    "nom": "Sessió de Ioga",
    "descripció": "Classe de ioga per relaxar-se i estirar els músculs.",
    "capacitat_màxima": 20
  },
  {
    "nom": "Taller de cuina",
    "descripció": "Aprendre a cuinar plats mediterranis.",
    "capacitat_màxima": 15
  },
  {
    "nom": "Curs de fotografia",
    "descripció": "Taller per millorar les teves habilitats de fotografia.",
    "capacitat_màxima": 10
  },
  {
    "nom": "Escalada en roca",
    "descripció": "Activitat d'escalada en un mur d'escalada interior.",
    "capacitat_màxima": 12
  },
  {
    "nom": "Sessió de meditació",
    "descripció": "Sessió guiada de meditació per a la pau interior.",
    "capacitat_màxima": 30
  }
]
```

### Requisits Tècnics i avaluació
- L'aplicació compleix amb els requisits funcionals especificats.
- El codi segueix bones pràctiques de programació.
- El projecte segueix un patró estructural.
- Les funcions tenen una única responsabilitat.
- El codi és escalable i reutilitzable.
- El codi està optimitzat i el seu rendiment és eficient.
- Proporcionar una documentació precisa en el Readme del repositori.
---

## Descripció de l'API

L'API està desenvolupada amb **Java i Spring Boot**, i utilitza **JWT** per a l'autenticació. L'emmagatzematge de 
dades es realitza amb **MongoDB**.

### Funcionalitats Principals:
- **Gestió d'Usuaris**: Registre, actualització, consulta i eliminació.
- **Gestió d'Activitats**: Creació, consulta i participació.
- **Autenticació**: Seguretat mitjançant JWT.
- **Exportació/Importació**: Activitats exportades i importades en format JSON.

### La meva visió personal del projecte

He intentat donar la meva visió personal al projecte afegint algunes funcionalitats extra per optimitzar i enriquir
l'experiència del projecte:
- **Usuari Administrador automàtic**: En iniciar l'aplicació, es registra automàticament un usuari amb permisos
  d'administrador. Només aquest usuari pot crear i eliminar activitats, mantenint la seguretat i el control 
centralitzat.


- **Control de participació en activitats**: He implementat un sistema que evita que els usuaris puguin apuntar-se diverses
  vegades a la mateixa activitat o quan l'activitat ha assolit la seva capacitat màxima, garantint una correcta gestió 
de participants.

Aquestes millores demostren com he integrat la meva visió i experiència personal en el desenvolupament del projecte, i com m'he
enfocat en garantir la seguretat, la usabilitat i l'escalabilitat.

A més, trobaràs la meva "signatura" en el projecte, afegint un petit toc d'humor personal. 
Perquè, al cap i a la fi, per a mi programar és divertit i gaudeixo amb això. 😉
---

## Instal·lació i Configuració

### Requisits previs:
- **Java 17** o superior.
- **Maven** o **Gradle** com a eina de construcció.
- **MongoDB**: Assegura't de tenir una instància de MongoDB en execució.

### Instal·lació:

### Pas 1: Clonar el repositori:

Obre la **terminal** o **símbol del sistema** al teu ordinador:
- A Windows, pots obrir **PowerShell** o el **Símbol del sistema**.
- A macOS o Linux, pots obrir la **terminal**.
   ```bash
   git clone https://github.com/ChrisGalHur/Hackato-i-Marketplace
   cd ruta/on/vols/guardar/el/projecte

### Pas 2: Configuració de l'arxiu `application.properties`:

L'arxiu `application.properties` ja està inclòs en el projecte a la carpeta `src/main/resources`. Aquest arxiu 
defineix configuracions importants com la connexió a la base de dades i el port en el qual s'executarà l'aplicació.

No necessites crear aquest arxiu, però si vols modificar alguna configuració, aquí tens les opcions que pots 
ajustar:

- **Connexió a MongoDB**: La URI de la base de dades MongoDB.
- **Port del servidor**: El port en el qual s'executarà l'aplicació.

#### Exemple de `application.properties`:
```properties
# Connexió a MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/appActivitats

# Configuració del servidor
server.port=9001
```
## API Endpoints
| Mètode | Endpoint                                      | Descripció                                | Autenticació   |
|--------|-----------------------------------------------|-------------------------------------------|----------------|
| POST   | `/appActivitats/user`                         | Registre d'un nou usuari                  | No             |
| POST   | `/appActivitats/login`                        | Autenticació d'un usuari                  | No             |
| PUT    | `/appActivitats/users/:id`                    | Actualització de les dades d'un usuari    | Si             |
| GET    | `/appActivitats/users/:id`                    | Consulta de la informació d'un usuari     | Si             |
| DELETE | `/appActivitats/users/:id`                    | Eliminació d'un usuari                    | Si             |
| POST   | `/appActivitats/activity`                     | Creació d'una nova activitat              | Només Admin    |
| DELETE | `/appActivitats/activity/:id`                 | Eliminació d'una activitat                | Només Admin    |
| GET    | `/appActivitats/activity`                     | Consulta totes les activitats de l'API    | Si             |
| POST   | `/appActivitats/activity/:idActivity/:idUser` | Apuntar-se a una activitat                | Si             |
| GET    | `/appActivitats/activity/export`              | Exportar activitats en format JSON        | Si             |

- Únicament es podrà accedir a `/appActivitats/user` per al registre de nous usuaris sense necessitat d'autenticació amb 
JWT.
- Només administradors poden crear i eliminar activitats.
---

## Ús de l'API
### Registre d'usuari
Fes una sol·licitud POST a `/appActivitats/user` amb un JSON com aquest utilitzant les dades de l'usuari que vols registrar:
```json
{
    "name": "John",
    "secondName": "Doe",
    "email": "example@example.com",
    "password": "password123",
    "age": 30
}
```

Rebràs una resposta amb l'usuari registrat i un token JWT que necessitaràs per accedir a altres rutes protegides.

Només l'usuari administrador creat automàticament en iniciar l'aplicació pot crear i eliminar activitats. El trobaràs a
l'arxiu `admins.json` a la carpeta `src/main/resources` del projecte juntament amb les activitats inicials.

### Autenticació d'usuari
Per autenticar-te i obtenir un token JWT, fes una sol·licitud POST a `/appActivitats/login` amb un JSON com aquest amb les dades d'un usuari registrat:
```json
{
    "email": "example@example.com",
    "password": "password123"
}
```
Rebràs una resposta amb un token JWT que necessitaràs per accedir a altres rutes protegides.

### Actualització de dades d'usuari
Per actualitzar les dades d'un usuari, fes una sol·licitud PUT a /appActivitats/users/:id amb un JSON com aquest amb les
noves dades de l'usuari juntament amb el token JWT:
```json
{
    "name": "Jane",
    "secondName": "Doe",
    "email": "example@example.com",
    "password": "password123",
    "age": 30
}
```

### Consulta d'informació d'usuari
Per consultar la informació d'un usuari, fes una sol·licitud GET a `/appActivitats/users/:id` amb el token JWT.

### Eliminació d'usuari
Per eliminar un usuari, fes una sol·licitud DELETE a `/appActivitats/users/:id` amb el token JWT.

### Creació d'una nova activitat
Per crear una nova activitat, fes una sol·licitud POST a `/appActivitats/activity` amb un JSON com aquest amb les dades
de la nova activitat juntament amb el token JWT d'administrador:
```json
{
    "name": "Sessió de Ioga",
    "description": "Classe de ioga per relaxar-se i estirar els músculs.",
    "maxCapacity": 20
}
```

### Eliminació d'una activitat
Per eliminar una activitat, fes una sol·licitud DELETE a `/appActivitats/activity/:id` amb el token JWT d'administrador.

### Consulta de totes les activitats
Per consultar totes les activitats, fes una sol·licitud GET a `/appActivitats/activity` amb el token JWT.

### Apuntar-se a una activitat
Per apuntar-se a una activitat, fes una sol·licitud POST a `/appActivitats/activity/:idActivity/:idUser amb el token JWT.

### Exportar activitats en format JSON
Per exportar totes les activitats en format JSON, fes una sol·licitud GET a `/appActivitats/activity/export` amb el token JWT.
Això descarregarà un arxiu JSON amb totes les activitats de l'API.

---