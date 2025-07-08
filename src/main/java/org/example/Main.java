package org.example;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        /*Optional<String> nombre = Optional.of("");
        nombre.ifPresent(x->System.out.println("Resultado : " + x));
        System.out.println("Hello world!");*/
        example4();
    }

    public static void example1(){
        Optional<String> nombre = Optional.of("Diego");
        nombre.ifPresent(x->System.out.println("Resultado : " + x));
    }

    public static void example2(){
        String nombre = null;
        String valor = Optional.ofNullable(nombre).orElse("Danny");
        System.out.println("Resultado 2 : " + valor);
    }

    public static void example3(){
        Optional<String> nombre = Optional.of("diego");
        Optional<String> nombreLower = nombre.map(x->x.toUpperCase());
        nombreLower.ifPresent(x->System.out.println("Resultado 3 : " + x));

    }

    public static void example4(){
        Optional<String> emailOp = Optional.of("diego@hotmail.com");

        if(emailOp.filter(x->x.endsWith("@hotmail.com")).isPresent()){
            System.out.println("Resultado 4 : Email valido");
        }else{
            System.out.println("Resultado 4 : Email invalido");
        }
    }

    public static void example5(){
        Optional<String> nombre = Optional.of("Omar");
        Optional<String> saludo = nombre.flatMap(n -> Optional.of("Hola " + n));
        saludo.ifPresent(System.out::println);
    }

    public static void example6(){
        Optional<String> palabra = Optional.of("java");
        String resultado = palabra.map(String::toUpperCase)
                .filter(p -> p.length() > 3)
                .orElse("No válido");
        System.out.println("Resultado: " + resultado);
    }

    public static void example7(){
        List<String> usuarios = List.of("Ana", "Luis", "Omar");

        buscarUsuario("omar", usuarios).ifPresentOrElse(
                u -> System.out.println("Usuario encontrado: " + u),
                () -> System.out.println("Usuario no encontrado")
        );

        buscarUsuario("maria", usuarios).ifPresentOrElse(
                u -> System.out.println("Usuario encontrado: " + u),
                () -> System.out.println("Usuario no encontrado")
        );
    }

    public static Optional<String> buscarUsuario(String nombre, List<String> usuarios) {
        return usuarios.stream()
                .filter(u -> u.equalsIgnoreCase(nombre))
                .map(String::toUpperCase)
                .findFirst();
    }
}