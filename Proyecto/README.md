# YOUPLAY

Este proyecto es un reproductor de música.

## Descripción de Contenidos

- **src**
  - **bd:** Contiene el código con el que se crea y se accede a la base de datos.
  - **modelos:** Carpeta que almacena los modelos de datos.
  - **ventanas:** Carpeta donde están creadas todas las ventanas utilizadas en el proyecto.
  - **funcionalidades:** Archivos con todas las funcionalidades utilizadas en el proyecto.

- **test:** Archivos en los que se verifican todos los modelos y varias funcionalidades.

- **recursos**
  - **ficheros:** Carpeta donde se guardan ficheros .txt que se vayan a importar o exportar.
  - **imagenes:** Carpeta que contiene todas las imágenes utilizadas en el proyecto.
  - **musica:** Carpeta que contiene todas las canciones posibles para escuchar.

## Instrucciones para Utilizar el Proyecto en Otro Dispositivo

### Requisitos Previos

1. Tener un IDE instalado.
2. Tener Java instalado.
3. Tener instalado SQLite.

### Configuración del Proyecto

1. Clonar el repositorio.

   ```bash
   git clone https://github.com/endikfer/Programacion_Proyecto.git

2. Configurar el classpath

* Añadir sqlite-jdbc-3.36.0.3.jar
* Añadir miglayout15-swing.jar
* Añadir JUnit4

## Como ejecutar el proyecto

Para ejecutar el proyecto hay que iniciar el archivo YOUPLAY.jar.

## Funcionamiento del proyecto

### Inicio de Sesión y Registro

Al ejecutar el programa, se presentará una ventana de inicio de sesión. Si aún no posee un registro, deberá crear uno nuevo proporcionando los datos requeridos. Para registrarse, es fundamental observar las siguientes restricciones:

1. Todas las casillas deben estar debidamente completadas.
2. El nombre solo puede contener letras, ya sean mayúsculas o minúsculas.
3. La contraseña debe tener un mínimo de 8 caracteres, que incluyan al menos una mayúscula, una minúscula y un número.
4. El correo electrónico debe seguir el formato estándar: letra+@+letra+punto+letra.

Si opta por no registrarse, puede utilizar el usuario por defecto con las siguientes credenciales:

- Nombre de usuario: admin
- Contraseña: Admin2024

Una vez completado exitosamente el registro, la ventana se cerrará automáticamente y se abrirá el reproductor de música YouPlay.

### Interfaz del Reproductor

La interfaz se presenta en una pestaña dividida en dos secciones. La parte permanente incluye cuatro botones a la izquierda de la pestaña y varios componentes en la parte inferior, tales como tres botones para reproducir, adelantar y reiniciar la canción, un deslizador con sus tiempos y el nombre de la canción en reproducción.

#### Funcionalidades de los botones reproductor

- **Botón Reproducir:** Dispone de dos funciones. Si la canción está en reproducción, pausará la reproducción; de lo contrario, reproducirá la canción previamente seleccionada.

- **Botón Reiniciar:** Inicia la reproducción de la canción desde el segundo 0.

- **Botón Adelantar:** Avanza a la próxima canción si es posible; de lo contrario, finaliza la canción actual.

