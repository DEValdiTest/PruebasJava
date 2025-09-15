package org.example.model;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void test(){

        Cuenta cuenta = new Cuenta("Diego", new BigDecimal("30.12"));
       // cuenta.setPersona("Diego");
        String esperado="Diego";
        String real = cuenta.getPersona();
        assertEquals(esperado, real);

    }

    @Test
    void testSaldoCuenta(){

        Cuenta cuenta = new Cuenta("Diego", new BigDecimal("15.22"));
        assertEquals(15.22, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO)<0);
    }

}