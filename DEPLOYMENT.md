# AhorrArte Backend - Deployment Guide

## Deployment en Render

### Pasos para deployar:

1. **Sube tu código a GitHub** (si no lo has hecho ya)

2. **Crea una cuenta en Render.com**

3. **Crea un nuevo Web Service:**
   - Ve a tu dashboard de Render
   - Haz clic en "New +" > "Web Service"
   - Conecta tu repositorio de GitHub
   - Selecciona el repositorio `AhorrArte-BackEnd`

4. **Configura el servicio:**
   - **Name**: `ahorrarte-backend` (o el nombre que prefieras)
   - **Environment**: `Docker`
   - **Build Command**: (deja vacío, Docker se encarga)
   - **Start Command**: (deja vacío, Docker se encarga)
   - **Plan**: Selecciona el plan que necesites

5. **Configura las variables de entorno:**
   En la sección "Environment Variables" agrega:
   
   ```
   SPRING_PROFILES_ACTIVE=prod
   DATABASE_URL=postgresql://usuario:password@host:5432/database
   DB_USERNAME=tu_usuario_db
   DB_PASSWORD=tu_password_db
   JWT_SECRET=tu_secreto_jwt_super_seguro_aqui
   JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseG1GC -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"
   ```

6. **Para la base de datos:**
   - Esta configuración está preparada para PostgreSQL (como Render PostgreSQL)
   - También mantiene compatibilidad con MySQL para desarrollo local

### Variables de entorno requeridas:

- `SPRING_PROFILES_ACTIVE`: Debe ser `prod`
- `DATABASE_URL`: URL de conexión a tu base de datos PostgreSQL
- `DB_USERNAME`: Usuario de la base de datos
- `DB_PASSWORD`: Contraseña de la base de datos
- `JWT_SECRET`: Secreto para firmar los tokens JWT (debe ser seguro)
- `JAVA_OPTS`: Opciones de JVM para optimización de memoria

### Archivos importantes:

- `Dockerfile`: Configuración de Docker para el deployment
- `src/main/resources/application-production.properties`: Configuración para producción
- `.dockerignore`: Archivos que Docker debe ignorar

### Testing local con Docker:

```bash
# Construir la imagen
docker build -t ahorrarte-backend .

# Ejecutar el contenedor
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=production ahorrarte-backend
```

### Notas importantes:

1. El Dockerfile está optimizado para cachear las dependencias de Maven
2. La aplicación usa el perfil `production` en Render
3. Todas las configuraciones sensibles se manejan através de variables de entorno
4. El puerto se configura dinámicamente para que Render pueda asignarlo

### Troubleshooting:

- Si tienes problemas con la base de datos, verifica que la URL y credenciales sean correctas
- Si la aplicación no inicia, revisa los logs en Render
- Asegúrate de que todas las variables de entorno estén configuradas correctamente
