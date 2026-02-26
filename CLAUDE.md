# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Build
./mvnw clean install

# Run
./mvnw spring-boot:run

# Run tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=ClassName

# Package (skip tests)
./mvnw clean package -DskipTests
```

## Database Setup

Before running, create the MySQL database and configure credentials:

```bash
mysql -u root -p -e "CREATE DATABASE crud_jwt_db;"
```

Update `src/main/resources/application.yml` with the actual MySQL password and a Base64-encoded JWT secret (minimum 256 bits).

## Architecture

This is a **guided implementation project** — many classes exist as skeletons with `// TODO` comments describing what to implement. The TODO comments are intentional teaching instructions, not bugs.

### Request Flow

```
HTTP Request
  → JwtAuthenticationFilter (extracts/validates Bearer token, sets SecurityContext)
  → SecurityConfig (route authorization: public vs ADMIN vs authenticated)
  → Controller (@Valid on request body, @AuthenticationPrincipal for current user)
  → Service (@Transactional, business logic)
  → Repository (JPA queries)
  → Mapper (Entity ↔ DTO conversion, done manually — no MapStruct)
```

### Domain Model

- **User** (`1:N`) **Order** — a user owns many orders
- **Category** (`1:N`) **Product** — products belong to a category
- **Order** (`1:N`) **OrderItem** — enriched join table between Order and Product (stores quantity, unitPrice, subtotal)

### Key Design Decisions

- **Mappers are manual** (`mapper/` package) — no MapStruct, conversion done with plain Java methods
- **Two validation layers**: Bean Validation annotations on DTOs (`@UniqueEmail`, `@ValidPrice`, standard Jakarta constraints) + a Spring `Validator` (`OrderValidator`) for business rules (stock check, duplicate products)
- **`ApiResponse<T>`** is the generic wrapper for all successful responses; `ErrorResponse` is used for errors via `GlobalExceptionHandler`
- **JWT** uses JJWT 0.12.x API — method names differ from 0.11.x (e.g., `.subject()` not `.setSubject()`)
- **Role** is a `String`-backed enum (`ADMIN`, `USER`) stored in the User entity; `SecurityConfig` uses `hasRole("ADMIN")`
- **`OrderService.createOrder`** is the most complex method: it runs `OrderValidator`, fetches entities, decrements product stock, builds `OrderItem` list, calculates total, and saves with cascade

### Security Config Summary

- `/api/auth/**` — public
- `GET /api/products/**`, `GET /api/categories/**` — public
- `/api/orders/**` — requires authentication
- CRUD write operations on products/categories — requires `ROLE_ADMIN`
- Sessions are stateless (`SessionCreationPolicy.STATELESS`); CSRF is disabled
