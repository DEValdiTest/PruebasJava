package org.example;

import org.example.service.DiscountService;
import org.example.service.DiscountServiceMonedero;
import org.example.service.DiscountServiceTalon;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DiscountService discount = new DiscountServiceTalon();
        discount.obtenerDescuento();

        discount = new DiscountServiceMonedero();
        discount.obtenerDescuento();
    }
}