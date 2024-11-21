package Utilidades;

import com.example.sanchezvictor_u2.Model.Explorador;

import java.util.ArrayList;
import java.util.List;

public class Utilidades {
    private static List<Explorador> exploradores = new ArrayList<>();

    public static List<Explorador> getExploradores() {return exploradores;}
    public static void setExploradores(List<Explorador> exploradores) {Utilidades.exploradores = exploradores;}
}
