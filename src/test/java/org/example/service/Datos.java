package org.example.service;

import org.example.model.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {

    public static final List<Examen> EXAMENES =
            Arrays.asList(new Examen(5L, "Matematicas"), new Examen(6L,"Lenguaje"), new Examen(7L,"Historia"));

    public final static List<String> PREGUNTAS = Arrays.asList("Aritmética", "Integrales", "Derivadas", "Trigonometría", "Geometría");

    public final static Examen EXAMEN = new Examen(null, "Física");
}
