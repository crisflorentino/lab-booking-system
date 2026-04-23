<div align="center">

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
</div>

## PostgreSQL

1. Ensure PostgreSQL is installed and running, you can probably find a tutorial online.
2. Create a local database named `lab_booking_db`.
3. Set the following **Environment Variable** in your IDE (do not hardcode this in `application.properties`):
   * **Key:** `DB_PASSWORD`
   * **Value:** *The Postgres password you set*

---

## Branching & Workflow

### Branch Categories
* **`feature/`**: New functional requirements (e.g., `feature/user-login`).
* **`bugfix/`**: Fixing a bug or broken logic (e.g., `bugfix/connection-timeout`).
* **`chore/`**: Maintenance tasks, documentation, or dependency updates (e.g., `chore/update-readme`).
* **`refactor/`**: Code changes that neither fix a bug nor add a feature (e.g., `refactor/booking-logic`).
---

##  Project Roadmap

### Phase 1: API Controllers (The Gateways)
- [x] **UserController**: Build enpoints to handle user data.
- [ ] **EquipmentController**: Build endpoints to fetch all equipment and filter by availability.
- [ ] **BookingController**: Build endpoints to handle new reservations and view schedules.

### Phase 2: Service Layer (The Business Logic)
- [ ] **UserService**: Abstract data fetching logic away from the controller.
- [ ] **EquipmentService**: Add logic for status updates (e.g., switching from AVAILABLE to IN_USE).
- [ ] **BookingService**: Implement the core logic to prevent double-booking and time-slot conflicts.

### Phase 3: Frontend Development & Integration
- [ ] Implement some sort of frontend.

