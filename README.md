# Peliculas
Proyecto Spring Boot con Películas - Exp2_S4_Ignacio_Andana

## Descripción
Este proyecto es un API Rest de películas, diseñado para aprender los conceptos básicos de Spring Boot. Permite realizar operaciones de consulta sobre una lista de películas almacenada en una base de datos autonoma de SQL Oracle, especificamente en la tabla PELICULA.

## Funcionalidades
- GET /peliculas: Obtiene todas los registros de películas.
- GET /peliculas/{id}: Obtiene una película especifica.
- POST /peliculas: Inserta un registro de pelicula.
- PUT /peliculas/{id}: Actualiza un registro de pelicula especifica.
- DELETE /peliculas/{id}: Elimina un registro de pelicula especifica.

## Tecnologías
- Java 21
- Spring Boot
- Postman

## Instrucciones para levantar el servicio

### Prerrequisitos
1. **Java 21**: Instalar Java 21 y agregar al PATH.
2. **Maven 3.9.9**: Instalar Maven 3.9.9 y agregado al PATH.
3. **Visual Studio Code**: Instalar el IDLE vscode.
4. **Extensiones de Visual Studio Code**:
   - Extensión Pack for Java
   - Spring Boot Extension Pack
   - Material Icon Theme

### Pasos para levantar el servicio

1. **Clonar el repositorio**:
   Abrir una terminal 
   git clone https://github.com/IgnacioAndana/proyecto-peliculas.git
   cd proyecto-peliculas

2. **Compilar proyecto**:
    mvn clean install

3. **Levantar servicio**:
    - Abrir la paleta de comandos con Ctrl + Shift + P -> Seleccionar "Spring Boot Dashboard"
    - Seleccionar el proyecto llamado "proyecto-peliculas"
    - Seleccionar algun archivo dentro del proyecto con extension .java para que aparezca el boton de play para ejecutar la aplicación en la esquina superior derecha.
    - Presionar el boton play o F5.

4. **Verificar que el servicio este ejecutandose**:
    Navega a http://localhost:9000/peliculas y deberia cargar la lista de peliculas creadas en el ArrayList en JSON.
