# Bank App: Sistema de Gestión Bancaria

## Descripción del Proyecto

Bank App es una aplicación web diseñada para simular un sistema de gestión bancaria básico. Permite la administración de clientes y la realización de transacciones monetarias entre cuentas. El proyecto está dividido en dos componentes principales: un Backend desarrollado con SpringBoot que maneja la lógica de negocio y la persistencia de datos, y un Frontend construido con React que proporciona la interfaz de usuario.

### Funcionalidades Importantes:

* Gestión de Clientes: Crear nuevos clientes con su información básica (nombre, apellido, número de cuenta y saldo inicial).
* Consulta de Clientes: Visualizar una lista de todos los clientes registrados y sus detalles.
* Transferencias Monetarias: Realizar transferencias de dinero entre dos cuentas existentes, con validación de saldo suficiente.
* Historial de Transacciones: Consultar el historial de transacciones de una cuenta específica o buscar una transacción por su ID.

## Tecnologías Empleadas

### Backend:

* Lenguaje: Java 21
* Framework: Spring Boot 3.5
* Persistencia: Spring Data JPA, Hibernate
* Base de Datos: MySQL
* Gestión de Dependencias: Maven
* API: Restfull

### Frontend:

* Librería: React
* Lenguaje: TypeScript
* Bundler: Vite
* Estilos: Tailwind CSS
* Componentes UI: Shadcn/UI
* Enrutamiento: Wouter
* Gestión de Dependencias: pnpm

## Cómo Ejecutar el Proyecto

Para poner en marcha la aplicación, necesitarás configurar y ejecutar tanto el backend como el frontend.

### Requisitos Previos:

* Java Development Kit (JDK): Versión 21
* Apache Maven
* Node.js: Versión 18
* pnpm: Gestor de paquetes para Node.js (instalar con `npm install -g pnpm`).
* MySQL Server: Una instancia de MySQL en ejecución.

### 1. Configuración de la Base de Datos (MySQL)

1. Asegúrate de que tu servidor MySQL esté en funcionamiento.
2. Crea una base de datos llamada `bank_lab01`.
   ```sql
   CREATE DATABASE bank_lab01;
   ```

### 2. Ejecución del Backend

1. Navega al directorio `bank` del proyecto:
   ```bash
   cd bank
   ```
2. Abre el archivo `src/main/resources/application.properties` y verifica que la configuración de la base de datos sea correcta para tu entorno.
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/bank_lab01?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
   ```
3. Compila y ejecuta la aplicación Spring Boot usando Maven:
   ```bash
   mvn spring-boot:run
   ```

   El backend se iniciará en `http://localhost:8080`.

### 3. Ejecución del Frontend

1. Abre una nueva terminal y navega al directorio `bank_frontend/client` del proyecto:
   ```bash
   cd bank_frontend/client
   ```
2. Instala las dependencias del proyecto usando pnpm:
   ```bash
   pnpm install
   ```
3. Inicia el servidor de desarrollo de React:
   ```bash
   pnpm dev
   ```
4. El frontend se abrirá en tu navegador predeterminado.
