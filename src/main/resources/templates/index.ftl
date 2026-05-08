<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wordle</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/style.css" rel="stylesheet">
</head>
<body>

<header class="py-3 border-bottom border-secondary w-100 text-center">
    <h1 class="fw-bold">WORDLE</h1>
</header>

<main class="container d-flex flex-column align-items-center flex-grow-1">

    <div class="wordle-grid">
        <#-- Itera sobre cada fila del tablero -->
        <#list game.getBoard().getRows() as row>
            <div class="wordle-row">
                <#-- Itera sobre cada celda de la fila -->
                <#list row.getTiles() as tile>
                    <div class="tile ${tile.getStatus()}">${tile.getLetter()}</div>
                </#list>
            </div>
        </#list>
    </div>

    <#-- Muestra mensajes de estado del juego (victoria, derrota) -->
    <#if game.getStatusMessage()??>
        <div class="mt-4">
            <h2>${game.getStatusMessage()}</h2>
            <#if game.isFinished()>
                <p>La palabra era: <strong>${game.getSecretWord()}</strong></p>
            </#if>
        </div>
    </#if>

    <#-- Muestra el formulario para adivinar solo si el juego no ha terminado -->
    <#if !game.isFinished()>
        <form class="mt-4" action="/guess" method="post">
            <input type="text" name="palabra" maxlength="5" required pattern="[A-Za-z]{5}" title="La palabra debe tener 5 letras." autofocus/>
            <input type="submit" value="Enviar"/>
        </form>
    <#else>
    <#-- Muestra el botón para reiniciar si el juego ha terminado -->
        <div class="mt-4">
            <a href="/restart" class="btn btn-outline-light px-4">REINTENTAR</a>
        </div>
    </#if>

</main>

</body>
</html>
