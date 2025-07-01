package org.example;

import org.example.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Crear SessionFactory desde el archivo de configuración
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addResource("Usuario.hbm.xml")
                .buildSessionFactory();

        // Obtener una sesión
        Session session = factory.openSession();

        try {
            // Iniciar transacción
            session.beginTransaction();

            // Crear y guardar un usuario
            Usuario user = new Usuario();
            user.setNombre("Juan Perez");
            session.save(user);

            // Leer el usuario
            Usuario encontrado = session.get(Usuario.class, user.getId());
            System.out.println("Usuario encontrado: " + encontrado.getNombre());

            // Finalizar transacción
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
