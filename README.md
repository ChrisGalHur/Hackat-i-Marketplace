- [Documentación en Español](docs/README_es.md)
- [Documentació en Catalá](docs/README_cat.md)

# Users and Activities Management App - Hackathon IT Academy
> Barcelona Activa in collaboration with the Mobile World Capital Barcelona organized a
> Hackathon by the hand of IT Academy where I had the pleasure to study.
>
> To participate in the Hackathon we were asked to perform this technical test.

<details>
<summary><a href="#challenge-description"><strong>1. Challenge Description</strong></a></summary>
<ul>
    <li><a href="#functional-requirements">Functional Requirements</a></li>
    <li><a href="#format-of-the-endpoints">Format of the endpoints</a></li>
    <li><a href="#json-format">JSON Format</a></li>
    <li><a href="#technical-requirements-and-evaluation">Technical requirements and evaluation</a></li>
</ul>
</details>
<br>
<details>
<summary><a href="#api-description"><strong>2. API Description</strong></a></summary>
<ul>
    <li><a href="#core-functionalities">Core Functionalities</a></li>
    <li><a href="#my-personal-vision-of-the-project">My personal vision of the project</a></li>
</ul>
</details>
<br>
<details>
<summary><a href="#installation-and-configuration"><strong>3. Installation and Configuration</strong></a></summary>
<ul>
    <li><a href="#prerequisites">Prerequisites</a></li>
    <li><a href="#installation">Installation</a>
        <ul>
            <li><a href="#step-1-clone-the-repository">Step 1: Clone the repository</a></li>
            <li><a href="#step-2-configure-the-applicationproperties-file">Step 2: Configuration of the `application.properties` file</a></li>
            <li><a href="#exemple-of-applicationproperties">Example of `application.properties`</a></li>
        </ul>
    </li>
</ul>
</details>

[**- 4. API Endpoints**](#api-endpoints)

<details>
<summary><a href="#api-usage"><strong>5. API Usage</strong></a></summary>
<ul>
    <li><a href="#user-registration">User-registration</a></li>
    <li><a href="#user-authentication">User-authentication</a></li>
    <li><a href="#user-data-update">User data update</a></li>
    <li><a href="#user-information-query">User information query</a></li>
    <li><a href="#user-deletion">User deletion</a></li>
    <li><a href="#creating-a-new-activity">Creating a new activity</a></li>
    <li><a href="#deleting-an-activity">Deleting an activity</a></li>
    <li><a href="#viewing-all-activities">Viewing all activities</a></li>
    <li><a href="#join-an-activity">Join-an-activity</a></li>
    <li><a href="#export-activities-in-json-format">Export activities in JSON-format</a></li>
</ul>
</details>

[**👉 Autor**](#autor)

---

## Challenge description
The challenge is to develop an API for a web application to manage users and activities.
It has to allow the registration of users, the management of activity data and the import/export of these data.
and the import/export of these activities in JSON format.

### Functional Requirements
1. User Management: You can use the data of the users you consider: name, surname,
   age, email...
    - Registration of new users
    - User data update:
    - User deletion
    - Consultation of user information


2. Activity management:
   - Creating a new activity
   - Consultation of activities
   - Signing up for an activity


3. Exporting activities:
    - Exporting activities in JSON format


4. Importing activities:
    - Import activities from a JSON file


5. Database Configuration:
    - Establish a connection to a database, which can be MySQL or MongoDB, to store user and activity data.
      MongoDB, to store user and activity data.


### Format of the endpoints
Endpoints of the users' section being able to create the necessary endpoints for the rest of the application:
- POST /appActivitats/user: Register a new user.
- PUT /appActivitats/users/:id: Update of user data.
- GET /appActivitats/users/:id: Query user information.
- DELETE /appActivitats/users/:id: Delete a user.

### JSON Format
The format of the activities must comply with the following structure:

```json
[
  {
    "name": "Yoga Session",
    "description": "Yoga class to relax and stretch the muscles",
    "maximum_capacity": 20
  },
  {
    "name": "Cooking Workshop",
    "description": "Learn to cook Mediterranean dishes",
    "maximum_capacity": 15
  },
  {
    "name": "Photography Course",
    "description": "Workshop to improve your photography skills",
    "maximum_capacity": 10
  },
  {
    "name": "Rock Climbing",
    "description": "Climbing activity in an indoor climbing wall",
    "maximum_capacity": 12
  },
  {
    "name": "Meditation Session",
    "description": "Guided meditation session for inner peace",
    "maximum_capacity": 30
  }
]
```

### Technical Requirements and Evaluation
- The application complies with the specified functional requirements.
- The code follows good programming practices.
- The project follows a structural pattern.
- The functions have a single responsibility.
- The code is scalable and reusable.
- The code is optimized and its performance is efficient.
- Provide accurate documentation in the repository readme.
---

## API Description

The API is developed with **Java and Spring Boot**, and uses **JWT** for authentication. The data is emmagematized
is performed with **MongoDB**.

### Core functionalities:
- **User Management**: Registration, update, query and deletion.
- **Activity management**: Creation, consultation and participation.
- **Authentication**: Security through JWT.
- **Export/Import**: Activities exported and imported in JSON format.

### My personal vision of the project

I have tried to give my personal vision to the project by adding some extra functionalities to optimize and enhance
the experience of the project:
- **Automatic administrator user**: When starting the application, a user with administrator permissions is automatically registered.
  administrator permissions. Only this user can create and delete activities, maintaining centralized security and control.
  centralized control.


- **Control of participation in activities**: I have implemented a system that prevents users from signing up several 
times for the same activity.
  the same activity several times or when the activity has reached its maximum capacity, guaranteeing a correct 
management of participants.
  of participants.

These improvements show how I have integrated my personal vision and experience in the development of the project, 
and how I have focused on guaranteeing the safety of the participants.
focused on ensuring security, usability and scalability.

In addition, you will find my “signature” in the project, adding a little touch of personal humor.
Because, in the end, for me programming is fun and I enjoy it 😉.

---

## Installation and Configuration

### Prerequisites:
- **Java 17** or higher.
- **Maven** or **Gradle** as a building tool.
- **MongoDB**: Make sure you have a running MongoDB instance.

### Installation:

### Step 1: Clone the repository:

Open the **terminal** or **system symbol** on your computer:
- On Windows, you can open **PowerShell** or **SysSymbol**.
- On macOS or Linux, you can open the **terminal**.
   ````bash
   git clone https://github.com/ChrisGalHur/Hackato-i-Marketplace
   cd path/on/vols/save/the/project

### Step 2: Configure the `application.properties` file:

The `application.properties` file is already included in the project in the `src/main/resources` folder. This file
defines important configurations such as the database connection and the port on which the application will run.

You don't need to create this archive, but if you want to modify any configuration, here are the options you can
adjust:

- **Connection to MongoDB**: The URI of the MongoDB database.
- **Server port**: The port on which the application will run.

#### Exemple of `application.properties`:
````properties
# Connection to MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/appActivitats

# Server configuration
server.port=9001
````

## API Endpoints
| Method | Endpoint                                      | Description                      | Authentication     |
|--------|-----------------------------------------------|----------------------------------|--------------------|
| POST   | `/appActivitats/user`                         | Registering a new user           | No                 |
| POST   | `/appActivities/login`                        | Authentication of a user         | No                 |
| PUT    | `/appActivities/users/:id`                    | Update of a user's data          | Yes                |
| GET    | `/appActivitats/users/:id`                    | Query a user's information       | Yes                |
| DELETE | `/appActivitats/users/:id`                    | Delete a user                    | Yes                |
| POST   | `/appActivitats/activity`                     | Create a new activity            | Admin Only         |
| DELETE | `/appActivitats/activity/:id`                 | Deleting an activity             | Admin Only         |
| GET    | `/appActivitats/activity`                     | Query all API activities         | Yes                |
| POST   | `/appActivitats/activity/:idActivity/:idUser` | Sign up for an activity          | Yes                |
|  GET   | `/appActivitats/activity/activity/export`     | Export activities in JSON format | Yes                | 

- You will only be able to access `/appActivities/user` for new user registration without the need of authentication with
  JWT.
- Only administrators can create and delete activities.
---

## API usage
To use the API, you can use a tool like **Postman** or any other tool that allows you to make HTTP requests.

### User Registration
Make a POST request to `/appActivities/user` with a JSON like this using the data of the user you want to register:
````json
{
    "name": "John",
    "secondName": "Doe",
    "email": "example@example.com",
    "password": "password123",
    "age": 30
}
````

You will receive a response with the registered user and a JWT token that you will need to access other protected routes.

Only the administrator user created automatically at the start of the application can create and delete activities. You will find it in
the `admins.json` file in the `src/main/resources` folder of the project along with the initial activities.

### User authentication
To authenticate yourself and get a JWT token, send a POST request to `/appActivities/login` with a JSON like this with the data of a registered user:
```json
{
    "email": "example@example.com",
    "password": "password123"
}
```
You will receive a response with a JWT token that you will need to access other protected routes.

### User data update
To update a user's data, send a PUT request to /appActivities/users/:id with a JSON like this with the new user data.
new user data along with the JWT token:
```json
{
  "name": "Jane",
  "secondName": "Doe",
  "email": "example@example.com",
  "password": "password123",
  "age": 30
}
```

### User information query
To query user information, make a GET request to `/appActivities/users/:id` with the JWT token.

### User deletion
To delete a user, make a DELETE request to `/appActivities/users/:id` with the JWT token.

### Creating a new activity
To create a new activity, make a POST request to `/appActivities/activity` with a JSON like this one with the data
of the new activity along with the administrator JWT token:
```json
{
  "name": "Yoga Session",
  "description": "Yoga class to relax and stretch the muscles",
  "maxCapacity": 20
}
```

### Deleting an activity
To delete an activity, make a DELETE request to `/appActivitats/activity/:id` with the administrator JWT token.

### Viewing all activities
To view all activities, make a GET request to `/appActivities/activity` with the JWT token.

### Join an activity
To join an activity, make a POST request to `/appActivities/activity/:idActivity/:idUser with the JWT token.

### Export activities in JSON format
To export all activities in JSON format, make a GET request to `/appActivities/activity/activity/export` with the JWT token.
This will download a JSON file with all the API activities.

---

## Author
This project was developed by Christian Gálvez Hurtado ([ChrisGalHur](https://github.com/ChrisGalHur)).
If you have any questions or suggestions, feel free to reach out.

---
[🔝 **Back to top**](#users-and-activities-management-app---hackathon-it-academy)