package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Usuario;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Implementacion JPA + HIBERNATE
        System.out.println( "Hello World1!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = new Usuario();
        usuario.setNombre("Tablos");
        //usuario.setCorreo("omar@correo.com");

        em.persist(usuario);
        em.getTransaction().commit();

        // Consultar
        Usuario encontrado = em.find(Usuario.class, usuario.getId());
        System.out.println("Usuario encontrado: " + encontrado.getNombre());

        em.close();
        emf.close();
    }
}
