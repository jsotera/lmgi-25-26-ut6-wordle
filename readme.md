# Práctica de Wordle con FreeMarker

El objetivo de esta práctica es que el alumnado aprenda a transformar una página HTML estática en una plantilla dinámica de FreeMarker. La lógica backend ya viene dada.

## Tarea

Se te proporciona un archivo `index.html` estático en la carpeta `src/main/resources/public`. Tu tarea principal es convertir este archivo en una plantilla de FreeMarker (`index.ftl`) y ubicarla en la carpeta `src/main/resources/templates/`.

Además, deberás implementar la lógica de backend en Java para gestionar el estado del juego de Wordle y pasar los datos necesarios a esta nueva plantilla `index.ftl`.

### Pasos a seguir:

1.  **Mover y Renombrar el HTML:**
    *   Copia el contenido de `src/main/resources/public/index.html`.
    *   Crea un nuevo archivo llamado `index.ftl` en `src/main/resources/templates/`.
    *   Pega el contenido del `index.html` en `index.ftl`.
    *   **Importante:** El archivo `index.html` original en `public` puede ser eliminado o ignorado una vez que hayas copiado su contenido a `index.ftl`.

2.  **Adaptar el CSS:**
    *   Asegúrate de que los archivos CSS (`style.css`, `estilo.css`) permanezcan en `src/main/resources/public/`.
    *   En tu `index.ftl`, la referencia al CSS debe ser relativa a la raíz del servidor, por ejemplo: `<link href="/style.css" rel="stylesheet">`.

3.  **Identificar y Dinamizar Secciones en `index.ftl`:**
    *   **La Cuadrícula de Wordle:** El `index.html` original tiene filas y celdas estáticas. Deberás reemplazar estas secciones con bucles de FreeMarker (`<#list>`) para que se generen dinámicamente a partir de un modelo de datos proporcionado por tu backend Java.
        *   Cada celda (`<div class="tile">`) deberá mostrar una letra y tener una clase CSS (`correct`, `present`, `absent`) basada en el estado de la letra en el juego.
    *   **Mensajes de Estado del Juego:** Si el juego ha terminado (ganado o perdido), deberás mostrar un mensaje y, opcionalmente, la palabra correcta. Utiliza condicionales de FreeMarker (`<#if>`) para esto.
    *   **Formulario de Intento vs. Botón de Reinicio:** El formulario para enviar una palabra solo debe aparecer si el juego no ha terminado. Si el juego ha terminado, debe aparecer un botón para "REINTENTAR". Usa condicionales (`<#if>`) para controlar la visibilidad de estos elementos.

4.  **Modelo de Datos Esperado por `index.ftl`:**

    Tu backend Java deberá pasar a la plantilla `index.ftl` un objeto principal (por ejemplo, llamado `game`) que contenga la siguiente información (o una estructura similar que puedas mapear):

    *   `game`: Objeto principal que representa el estado actual del juego.
        *   `game.getBoard()`: Devuelve un objeto `Board`.
            *   `board.getRows()`: Una lista de objetos `Row`.
                *   Cada `row` tendrá `row.getTiles()`: Una lista de objetos `Tile`.
                    *   Cada `tile` tendrá:
                        *   `tile.getLetter()`: La letra a mostrar (e.g., 'A', 'B').
                        *   `tile.getStatus()`: El estado de la celda (e.g., `"correct"`, `"present"`, `"absent"`, o vacío si no se ha adivinado).
        *   `game.getStatusMessage()`: Un `String` opcional con un mensaje (e.g., "¡Has ganado!", "¡Has perdido!").
        *   `game.isFinished()`: Un `boolean` que indica si el juego ha terminado.
        *   `game.getSecretWord()`: Un `String` con la palabra secreta (solo se mostrará si `game.isFinished()` es `true`).

¡Mucha suerte con la práctica!
