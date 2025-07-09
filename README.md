# AhorrArte Backend - Deploy en Render

Este proyecto está configurado para desplegarse en Render usando Docker.

## Configuración para Deploy

### 1. Variables de Entorno Requeridas

En Render, configura las siguientes variables de entorno:

- `DATABASE_URL`: URL de conexión a PostgreSQL (automática con Render Database)
- `JWT_SECRET`: Secreto para firmar tokens JWT (se genera automáticamente)
- `JWT_EXPIRATION_DAYS`: Días de expiración del token (default: 7)
- `SPRING_PROFILES_ACTIVE`: `production`
- `CORS_ALLOWED_ORIGINS`: Dominios permitidos para CORS (ej: `https://tu-frontend.com`)

### 2. Instrucciones de Deploy

1. **Conecta tu repositorio** a Render
2. **Selecciona "Web Service"**
3. **Configura el servicio:**
   - Language: Docker
   - Dockerfile Path: `./Dockerfile`
   - Build Command: (dejar vacío)
   - Start Command: (dejar vacío)

4. **Crea una base de datos PostgreSQL:**
   - Ve a "Databases" en Render
   - Crea una nueva PostgreSQL Database
   - Copia el nombre de la base de datos

5. **Configura las variables de entorno** en el Web Service

6. **Deploya el servicio**

### 3. Endpoints Disponibles

Una vez desplegado, la API estará disponible en:

- **Base URL**: `https://tu-servicio.onrender.com`
- **Documentación**: `https://tu-servicio.onrender.com/swagger-ui/index.html`
- **Health Check**: `https://tu-servicio.onrender.com/actuator/health`

### 4. APIs Principales

#### Autenticación
- `POST /api/v1/authentication/sign-up` - Registro de usuario
- `POST /api/v1/authentication/sign-in` - Inicio de sesión

#### Roles
- `GET /api/v1/roles` - Obtener todos los roles

#### Datos Financieros
- `GET /api/v1/financial-data` - Obtener datos financieros
- `POST /api/v1/financial-data` - Crear datos financieros

#### Transacciones
- `GET /api/v1/transactions` - Obtener transacciones
- `POST /api/v1/transactions` - Crear transacciones

#### Contexto de Usuario
- `GET /api/v1/user-context` - Obtener contexto de usuario
- `POST /api/v1/user-context` - Crear/actualizar contexto

#### Educación Financiera
- `GET /api/v1/financial-education` - Obtener recursos educativos

#### Reportes de Inflación
- `GET /api/v1/inflation-reports` - Obtener reportes de inflación

### 5. Desarrollo Local

Para desarrollo local, usa:

```bash
./mvnw spring-boot:run
```

La aplicación estará disponible en `http://localhost:8082`

### 6. Construcción Manual

Para construir el JAR:

```bash
./mvnw clean package -DskipTests
```

Para construir con Docker:

```bash
docker build -t ahorrarte-backend .
docker run -p 8080:8080 ahorrarte-backend
```
