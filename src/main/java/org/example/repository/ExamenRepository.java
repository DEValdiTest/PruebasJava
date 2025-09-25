package org.example.repository;

import org.example.model.Examen;
import java.util.List;

public interface ExamenRepository {

    List<Examen> findAll();
    Examen guardar(Examen examen);

}
