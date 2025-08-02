package org.example.liskov;

public class Avestruz extends Ave{

    public void volar() throws Exception {
        throw new Exception("No puede volar");
    }
}
