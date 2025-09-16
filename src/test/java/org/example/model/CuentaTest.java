package org.example.model;

//import org.junit.jupiter.api.Assertions;
import org.example.exception.DineroInsuficienteException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testNombreCuenta(){

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

    @Test
    void testReferenciaCuenta() {
        Cuenta cuenta = new Cuenta("Diego", new BigDecimal("15.22"));
        Cuenta cuenta2 = new Cuenta("Diego", new BigDecimal("15.22"));

        assertEquals(cuenta, cuenta2);
    }

    @Test
    void testDebitoCuenta(){
        Cuenta cuenta = new Cuenta("Diego", new BigDecimal("15.22"));
        cuenta.debito(new BigDecimal("10"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(5, cuenta.getSaldo().intValue());
        assertEquals("5.22", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta(){
        Cuenta cuenta = new Cuenta("Diego", new BigDecimal("15.22"));
        cuenta.credito(new BigDecimal("10"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(25, cuenta.getSaldo().intValue());
        assertEquals("25.22", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testDineroInsuficienteExceptionCuenta(){
        Cuenta cuenta = new Cuenta("Diego", new BigDecimal("15.22"));
        Exception exception = assertThrows(DineroInsuficienteException.class, ()-> cuenta.debito(new BigDecimal("16")));
        String actual = exception.getMessage();
        String esperado = "Dinero insuficiente";
        assertEquals(esperado, actual);

    }

}