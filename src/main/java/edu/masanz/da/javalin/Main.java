package edu.masanz.da.javalin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.rendering.template.JavalinFreemarker;
import org.jetbrains.annotations.NotNull;

public class Main {

    public static List<Letra[]> intentos;

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public");
            config.fileRenderer(new JavalinFreemarker());
        }).start(4567);

        Wordle.palabraDelDia = "AVION";
        intentos = new ArrayList<>();

        app.get("/", Main::wordle);
        app.post("/probar", Main::probar);
    }

    private static void wordle(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();

        model.put("intentos", intentos);
        model.put("palabraVacia", new Letra[Wordle.palabraDelDia.length()]);

        context.render("/templates/index.ftl", model);
    }

    private static void probar(Context ctx) {
        String palabra = ctx.formParam("palabra");
        Map<String, Object> model = new HashMap<>();
        Letra[] intento = Wordle.validar(palabra.toUpperCase());
        if(intento != null){
            intentos.add(intento);
        }
        ctx.redirect("/");
    }

}