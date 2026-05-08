package edu.masanz.da.javalin;

public class Wordle {

    public static String palabraDelDia;

    public static Letra[] validar(String palabra){

        if(palabraDelDia.length() != palabra.length()){
            return null;
        }

        Letra[] letras = new Letra[palabraDelDia.length()];

        for (int i = 0; i < palabraDelDia.length(); i++) {
            char letraC = palabraDelDia.charAt(i);
            char letraP = palabra.charAt(i);
            Letra letra = new Letra(letraP+"");
            if(letraC == letraP){
                letra.setEstado(2);
            } else {
                if(palabraDelDia.contains(letraP+"")){
                    letra.setEstado(1);
                } else {
                    letra.setEstado(0);
                }
            }
            letras[i] = letra;
        }
        return letras;
    }

}
