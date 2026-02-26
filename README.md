# CrudJwtMovile - API REST con Spring Boot

API REST para gestión de órdenes con autenticación JWT, validaciones personalizadas y JPA.

## Stack Tecnológico

- Java 17
- Spring Boot 3.2.3
- Spring Security + JWT (JJWT 0.12.5)
- Spring Data JPA + MySQL
- Bean Validation + Validaciones personalizadas
- Lombok

## Modelo de Datos (Relaciones)

```
┌──────────┐       1:N       ┌──────────┐
│   User   │────────────────▶│  Order   │
└──────────┘                 └────┬─────┘
                                  │ 1:N
                                  ▼
┌──────────┐       1:N       ┌──────────┐
│ Category │────────────────▶│ Product  │
└──────────┘                 └────┬─────┘
                                  │ 1:N
                                  ▼
                             ┌──────────┐
                             │OrderItem │ ◀── Tabla intermedia enriquecida
                             └──────────┘     (ManyToMany Order-Product con campos extra)
```

- **User** `1:N` **Order** — Un usuario tiene muchas órdenes
- **Category** `1:N` **Product** — Una categoría tiene muchos productos
- **Order** `1:N` **OrderItem** — Una orden tiene muchos items
- **Product** `1:N` **OrderItem** — Un producto puede estar en muchos items

## Estructura del Proyecto

```
src/main/java/com/crud/api/
│
├── CrudJwtMovileApplication.java        # Punto de entrada
│
├── config/
│   └── SecurityConfig.java              # SecurityFilterChain, PasswordEncoder, rutas públicas/protegidas
│
├── security/jwt/
│   ├── JwtTokenProvider.java            # Generar, validar y parsear tokens JWT
│   ├── JwtAuthenticationFilter.java     # Filtro: extrae JWT del header Authorization
│   └── JwtEntryPoint.java              # Respuesta JSON para errores 401
│
├── entity/
│   ├── Role.java                        # Enum: ADMIN, USER
│   ├── User.java                        # implements UserDetails | @OneToMany → Order
│   ├── Category.java                    # @OneToMany → Product
│   ├── Product.java                     # @ManyToOne → Category | @OneToMany → OrderItem
│   ├── Order.java                       # @ManyToOne → User | @OneToMany → OrderItem
│   └── OrderItem.java                   # @ManyToOne → Order + Product
│
├── repository/
│   ├── UserRepository.java             # findByEmail, existsByEmail
│   ├── CategoryRepository.java         # findByName, existsByName
│   ├── ProductRepository.java          # findByCategoryId, findByActiveTrue, @Query personalizado
│   ├── OrderRepository.java            # findByUserId, findByStatus, JOIN FETCH
│   └── OrderItemRepository.java        # findByOrderId, findByProductId
│
├── dto/
│   ├── request/
│   │   ├── LoginRequest.java           # @NotBlank, @Email
│   │   ├── RegisterRequest.java        # @NotBlank, @Email, @Size, @UniqueEmail
│   │   ├── CategoryRequest.java        # @NotBlank, @Size
│   │   ├── ProductRequest.java         # @NotBlank, @NotNull, @Min, @ValidPrice
│   │   ├── OrderRequest.java           # @NotNull, @Size, @Valid (lista anidada)
│   │   └── OrderItemRequest.java       # @NotNull, @Min
│   └── response/
│       ├── ApiResponse.java            # Wrapper genérico: status, message, data
│       ├── AuthResponse.java           # token, type, email, name, role
│       ├── CategoryResponse.java       # id, name, description, productCount
│       ├── ProductResponse.java        # id, name, price, stock, categoryName
│       ├── OrderResponse.java          # id, orderDate, status, total, items
│       └── OrderItemResponse.java      # id, productName, quantity, unitPrice, subtotal
│
├── mapper/
│   ├── UserMapper.java                 # RegisterRequest → User, User → AuthResponse
│   ├── CategoryMapper.java             # CategoryRequest ↔ Category ↔ CategoryResponse
│   ├── ProductMapper.java              # ProductRequest + Category → Product → ProductResponse
│   └── OrderMapper.java                # Order → OrderResponse, OrderItem → OrderItemResponse
│
├── service/
│   ├── UserDetailsServiceImpl.java     # implements UserDetailsService (puente Security ↔ BD)
│   ├── AuthService.java                # login, register (AuthenticationManager + JWT)
│   ├── CategoryService.java            # CRUD con @Transactional
│   ├── ProductService.java             # CRUD con relación a Category
│   └── OrderService.java               # Crear orden, validar stock, calcular totales
│
├── controller/
│   ├── AuthController.java             # POST /api/auth/login, /api/auth/register (público)
│   ├── CategoryController.java         # CRUD /api/categories (GET público, CUD solo ADMIN)
│   ├── ProductController.java          # CRUD /api/products (GET público, CUD solo ADMIN)
│   └── OrderController.java            # /api/orders (autenticado, @AuthenticationPrincipal)
│
├── exception/
│   ├── ResourceNotFoundException.java  # → 404
│   ├── BadRequestException.java        # → 400
│   ├── DuplicateResourceException.java # → 409
│   ├── ErrorResponse.java              # DTO de error: status, message, timestamp, errors
│   └── GlobalExceptionHandler.java     # @RestControllerAdvice (manejo centralizado)
│
└── validation/
    ├── annotation/
    │   ├── UniqueEmail.java            # @Constraint → UniqueEmailValidator
    │   └── ValidPrice.java             # @Constraint → ValidPriceValidator
    └── validator/
        ├── UniqueEmailValidator.java   # ConstraintValidator con acceso a BD
        ├── ValidPriceValidator.java    # ConstraintValidator de formato (> 0, máx 2 decimales)
        └── OrderValidator.java         # Spring Validator: productos duplicados, stock, existencia
```

```
src/main/resources/
└── application.yml                      # Config: MySQL, JPA (ddl-auto), JWT (secret, expiration)
```

## Endpoints

| Método | Ruta                            | Acceso       | Descripción                    |
|--------|---------------------------------|--------------|--------------------------------|
| POST   | `/api/auth/register`            | Público      | Registrar usuario              |
| POST   | `/api/auth/login`               | Público      | Login, devuelve JWT            |
| GET    | `/api/categories`               | Público      | Listar categorías              |
| GET    | `/api/categories/{id}`          | Público      | Obtener categoría              |
| POST   | `/api/categories`               | ADMIN        | Crear categoría                |
| PUT    | `/api/categories/{id}`          | ADMIN        | Actualizar categoría           |
| DELETE | `/api/categories/{id}`          | ADMIN        | Eliminar categoría             |
| GET    | `/api/products`                 | Público      | Listar productos               |
| GET    | `/api/products/{id}`            | Público      | Obtener producto               |
| GET    | `/api/products/category/{id}`   | Público      | Productos por categoría        |
| POST   | `/api/products`                 | ADMIN        | Crear producto                 |
| PUT    | `/api/products/{id}`            | ADMIN        | Actualizar producto            |
| DELETE | `/api/products/{id}`            | ADMIN        | Eliminar producto              |
| POST   | `/api/orders`                   | Autenticado  | Crear orden                    |
| GET    | `/api/orders`                   | Autenticado  | Mis órdenes                    |
| GET    | `/api/orders/{id}`              | Autenticado  | Detalle de orden               |
| PUT    | `/api/orders/{id}/cancel`       | Autenticado  | Cancelar orden                 |

## Orden Sugerido de Implementación

1. **Entities** — Definir las entidades JPA con sus relaciones
2. **Repositories** — Interfaces JpaRepository con query methods
3. **DTOs** — Request (con validaciones) y Response
4. **Mappers** — Conversión manual Entity ↔ DTO
5. **Exceptions** — Excepciones custom + GlobalExceptionHandler
6. **Validaciones** — @UniqueEmail, @ValidPrice (ConstraintValidator) y OrderValidator (Spring Validator)
7. **Security/JWT** — JwtTokenProvider, JwtAuthenticationFilter, JwtEntryPoint
8. **Config** — SecurityConfig (SecurityFilterChain, rutas, filtros)
9. **Services** — Lógica de negocio con @Transactional
10. **Controllers** — Endpoints REST con @Valid y @PreAuthorize

## Setup

```bash
# 1. Crear base de datos
mysql -u root -p -e "CREATE DATABASE crud_jwt_db;"

# 2. Configurar credenciales en application.yml

# 3. Ejecutar
./mvnw spring-boot:run
```
