- [English Documentation](../README.md)
- [Documentació en Catalá](README_cat.md)


# App de Gestión de Usuarios y Actividades - Hackathon IT Academy
> Barcelona Activa en  colaboración con la Mobile World Capital Barcelona organizaron una
> Hackatón de la mano de IT Academy donde tuve el placer de estudiar.
> 
> Para participar en la Hackatón nos pidieron que realizaramos esta prueba técnica.

[**Descripción del reto:**](#descripción-del-reto)
- [Requisitos Funcionales](#requisitos-funcionales)
- [Formato de los endpoints](#formato-de-los-endpoints)
- [Formato del JSON](#formato-del-json)
- [Requisitos Técnicos y evaluación](#requisitos-técnicos-y-evaluación)

[**Descripción de la API**](#descripción-de-la-api)
  - [Funcionalidades Principales](#funcionalidades-principales)
  - [Mi visión personal del proyecto](#mi-visión-personal-del-proyecto)


[**Instalación y Configuración**](#instalación-y-configuración)
- [Requisitos previos](#requisitos-previos)
- [Instalación:](#Instalación)
  - [Paso 1: Clonar el repositorio](#paso-1-clonar-el-repositorio)
  - [Paso 2: Configuración del archivo `application.properties`](#paso-2-configuración-del-archivo-applicationproperties)
  - [Ejemplo de `application.properties`](#ejemplo-de-applicationproperties)

[**API Endpoints**](#api-endpoints)

[**Uso de la API**](#uso-de-la-api)
- [Registro de usuario](#registro-de-usuario)
- [Autenticación de usuario](#autenticación-de-usuario)
- [Actualización de datos de usuario](#actualización-de-datos-de-usuario)
- [Consulta de información de usuario](#consulta-de-información-de-usuario)
- [Eliminación de usuario](#eliminación-de-usuario)
- [Creación de una nueva actividad](#creación-de-una-nueva-actividad)
- [Eliminación de una actividad](#eliminación-de-una-actividad)
- [Consulta de todas las actividades](#consulta-de-todas-las-actividades)
- [Apuntarse a una actividad](#apuntarse-a-una-actividad)
- [Exportar actividades en formato JSON](#exportar-actividades-en-formato-json)
---

## Descripción del reto
El reto consiste en desarrollar una API para una aplicación web que administre usuarios y actividades.
Tiene que permitir el registro de usuarios, la gestión de datos de las actividades 
y la importación/exportación de estas actividades en formato JSON.

### Requisitos Funcionales
1. Gestión de Usuarios: Puedes utilizar los datos de los usuarios que consideres: nombre, apellidos,
   edad, email...
    - Registro de nuevos usuarios
    - Actualización de datos del usuario:
    - Eliminación de usuarios
    - Consulta de información de usuarios


2. Gestión de actividades:
    - Creación de una nueva actividad
    - Consulta de actividades
    - Apuntarse a una actividad
   

3. Exportación de actividades:
    - Exportar actividades en formato JSON


4. Importación de actividades:
    - Importar actividades desde un archivo JSON
   

5. Configuración de la Base de Datos:
    - Establecer una conexión con una base de datos, que puede ser MySQL o
      MongoDB, para almacenar los datos de usuarios y actividades.


### Formato de los endpoints
Endpoints del apartado de los usuarios pudiendo crear los endpoints necesarios para el resto de la aplicación:
- POST /appActivitats/user: Registre d'un nou usuari.
- PUT /appActivitats/users/:id: Actualització de les dades d'un usuari.
- GET /appActivitats/users/:id: Consulta de la informació d'un usuari.
- DELETE /appActivitats/users/:id: Eliminació d'un usuari.


### Formato del JSON
El formato de las actividades debe cumplir la siguiente estructura:

```json
[
  {
    "nombre": "Sesión de Yoga",
    "descripción": "Clase de yoga para relajarse y estirar los músculos.",
    "capacidad_máxima": 20
  },
  {
    "nombre": "Taller de cocina",
    "descripción": "Aprender a cocinar platos mediterráneos.",
    "capacidad_máxima": 15
  },
  {
    "nombre": "Curso de fotografía",
    "descripción": "Taller para mejorar tus habilidades de fotografía.",
    "capacidad_máxima": 10
  },
  {
    "nombre": "Escalada en roca",
    "descripción": "Actividad de escalada en un muro de escalada interior.",
    "capacidad_máxima": 12
  },
  {
    "nombre": "Sesión de meditación",
    "descripción": "Sesión guiada de meditación para la paz interior.",
    "capacidad_máxima": 30
  }
]
```

### Requisitos Técnicos y Evaluación
- La aplicación cumple con los requisitos funcionales especificados.
- El código sigue buenas prácticas de programación.
- El proyecto sigue un patrón estructural.
- Las funciones tienen una única responsabilidad.
- El código es escalable y reutilizable.
- El código está optimizado y su rendimiento es eficiente.
- Proporcionar una documentación precisa en el Readme del repositorio.
---

## Descripción de la API

La API está desarrollada con **Java y Spring Boot**, y utiliza **JWT** para la autenticación. El almacenamiento de 
datos se realiza con **MongoDB**.

### Funcionalidades Principales:
- **Gestión de Usuarios**: Registro, actualización, consulta y eliminación.
- **Gestión de Actividades**: Creación, consulta y participación.
- **Autenticación**: Seguridad mediante JWT.
- **Exportación/Importación**: Actividades exportadas e importadas en formato JSON.

### Mi visión personal del proyecto

He intentado darle mi visión personal al proyecto añadiendo algunas funcionalidades extra para optimizar y enriquecer
la experiencia del proyecto:
- **Usuario Administrador automático**: Al iniciar la aplicación, se registra automáticamente un usuario con permisos
  de administrador. Solo este usuario puede crear y eliminar actividades, manteniendo la seguridad y el control 
centralizado.


- **Control de participación en actividades**: Implementé un sistema que evita que los usuarios puedan apuntarse varias
  veces a la misma actividad o cuando la actividad ha alcanzado su capacidad máxima, garantizando una correcta gestión 
de participantes.

Estas mejoras demuestran cómo he integrado mi visión y experiencia personal en el desarrollo del proyecto, y cómo me
enfoqué en garantizar la seguridad, la usabilidad y la escalabilidad.

Además, encontrarás mi "firma" en el proyecto, agregando un pequeño guiño a mi humor personal. 
Porque, después de todo, para mi programar es divertido y disfruto con ello. 😉
---

## Instalación y Configuración

### Requisitos previos:
- **Java 17** o superior.
- **Maven** o **Gradle** como herramienta de construcción.
- **MongoDB**: Asegúrate de tener una instancia de MongoDB en ejecución.

### Instalación:

### Paso 1: Clonar el repositorio:

Abre la **terminal** o **símbolo del sistema** en tu computadora:
- En Windows, puedes abrir **PowerShell** o el **Símbolo del sistema**.
- En macOS o Linux, puedes abrir la **terminal**.
   ```bash
   git clone https://github.com/ChrisGalHur/Hackato-i-Marketplace
   cd ruta/donde/quieres/guardar/el/proyecto

### Paso 2: Configuración del archivo `application.properties`:

El archivo `application.properties` ya está incluido en el proyecto en la carpeta `src/main/resources`. Este archivo 
define configuraciones importantes como la conexión a la base de datos y el puerto en el que se ejecutará la aplicación.

No necesitas crear este archivo, pero si quieres modificar alguna configuración, aquí tienes las opciones que puedes 
ajustar:

- **Conexión a MongoDB**: La URI de la base de datos MongoDB.
- **Puerto del servidor**: El puerto en el que se ejecutará la aplicación.

#### Ejemplo de `application.properties`:
```properties
# Conexión a MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/appActivitats

# Configuración del servidor
server.port=9001
```
---

## API Endpoints
| Método | Endpoint                                      | Descripción                              | Autenticación |
|--------|-----------------------------------------------|------------------------------------------|---------------|
| POST   | `/appActivitats/user`                         | Registro de un nuevo usuario             | No            |
| POST   | `/appActivitats/login`                        | Autenticación de un usuario              | No            |
| PUT    | `/appActivitats/users/:id`                    | Actualización de los datos de un usuario | Si            |
| GET    | `/appActivitats/users/:id`                    | Consulta de la información de un usuario | Si            |
| DELETE | `/appActivitats/users/:id`                    | Eliminación de un usuario                | Si            |
| POST   | `/appActivitats/activity`                     | Creación de una nueva actividad          | Solo Admin    |
| DELETE | `/appActivitats/activity/:id`                 | Eliminación de una actividad             | Solo Admin    |
| GET    | `/appActivitats/activity`                     | Consulta todas las actividades de la API | Si            |
| POST   | `/appActivitats/activity/:idActivity/:idUser` | Apuntarse a una actividad                | Si            |
| GET    | `/appActivitats/activity/export`              | Exportar actividades en formato JSON     | Si            |

- Unicamente se podrá acceder a `/appActivitats/user` para el registro de nuevos usuarios sin necesidad de autenticación
con JWT.
- Solamente administradores pueden crear y eliminar actividades.
---

## Uso de la API
### Registro de usuario
Haz una solicitud POST a /appActivitats/user con un JSON como este utilizando los datos del usuario que quieres 
registrar:
```json
{
    "name": "John",
    "secondName": "Doe",
    "email": "example@example.com",
    "password": "password123",
    "age": 30
}
```
Recibirás una respuesta con el usuario registrado y un token JWT que necesitarás para acceder a otras rutas protegidas.

Solo el usuario administrador creado automáticamente al iniciar la aplicación puede crear y eliminar actividades.
Lo encontrarás en el archivo `admins.json` en la carpeta `src/main/resources` del proyecto junto a las actividades iniciales.

### Autenticación de usuario
Para autenticarte y obtener un token JWT, haz una solicitud POST a /appActivitats/login con un JSON como este con los 
datos de un usuario registrado:
```json
{
    "email": "example@example.com",
    "password": "password123"
}
```
Recibirás una respuesta con un token JWT que necesitarás para acceder a otras rutas protegidas.

### Actualización de datos de usuario
Para actualizar los datos de un usuario, haz una solicitud PUT a /appActivitats/users/:id con un JSON como este con los
nuvos datos del usuario junto al token JWT:
```json
{
    "name": "Jane",
    "secondName": "Doe",
    "email": "example@example.com",
    "password": "password123",
    "age": 30
}
```

### Consulta de información de usuario
Para consultar la información de un usuario, haz una solicitud GET a /appActivitats/users/:id con un token JWT.

### Eliminación de usuario
Para eliminar un usuario, haz una solicitud DELETE a /appActivitats/users/:id con un token JWT.

### Creación de una nueva actividad
Para crear una nueva actividad, haz una solicitud POST a /appActivitats/activity con un JSON como este con los datos de
la actividad que quieres crear junto a un token JWT de administrador:
```json
{
    "name": "Sesión de Yoga",
    "description": "Clase de yoga para relajarse y estirar los músculos.",
    "maxCapacity": 20
}
```

### Eliminación de una actividad
Para eliminar una actividad, haz una solicitud DELETE a /appActivitats/activity/:id con un token JWT de administrador.

### Consulta de todas las actividades
Para consultar todas las actividades, haz una solicitud GET a /appActivitats/activity con un token JWT.
    
### Apuntarse a una actividad
Para apuntarse a una actividad, haz una solicitud POST a /appActivitats/activity/:idActivity/:idUser con un token JWT.

### Exportar actividades en formato JSON
Para exportar todas las actividades en formato JSON, haz una solicitud GET a /appActivitats/activity/export con un token JWT.
Esto te devolverá un JSON con todas las actividades de la API.

---