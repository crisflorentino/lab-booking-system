<div align="center">

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
</div>

---
## Spring Boot
This project utilizes the Spring framework. I am personally still learning it, but try to familiarize yourelf with it. It follows a layered architecture. Make sure code is placed in the correct packages.

* **`model`**: Database entities and Enums.
* **`repository`**: JPA interfaces for database access.
* **`service`**: Business logic and validation.
* **`controller`**: REST API endpoints (Mappings).

---

## PostgreSQL

**PostgreSQL** is required on your device to run this project properly.

1. Ensure PostgreSQL is installed and running, you can probably find a tutorial online.
2. Create a local database named `lab_booking_db`.
3. Set the following **Environment Variable** in your IDE (do not hardcode this in `application.properties`):
   * **Key:** `DB_PASSWORD`
   * **Value:** *The Postgres password you set*

---

## Branching & Workflow

Try not to make changes on the `main` branch to keep things stable, please work on feature branches. Use the following naming techniques when creating new branches:

### Branch Categories
* **`feature/`**: New functional requirements (e.g., `feature/user-login`).
* **`bugfix/`**: Fixing a bug or broken logic (e.g., `bugfix/connection-timeout`).
* **`chore/`**: Maintenance tasks, documentation, or dependency updates (e.g., `chore/update-readme`).
* **`refactor/`**: Code changes that neither fix a bug nor add a feature (e.g., `refactor/booking-logic`).

