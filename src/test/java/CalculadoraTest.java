import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass(){
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2,3));
        assertEquals(0, miCalculadora.multiplica(5,0));
    }

    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws Exception {
        assertEquals(2, miCalculadora.divide(4,2));
        assertEquals(2.5, miCalculadora.divide(10,4));
        assertEquals(4, miCalculadora.divide(10,2.5));
        assertEquals(3.2, miCalculadora.divide(8,2.5));
        assertEquals(0.5, miCalculadora.divide(2,4));
    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws Exception {
        assertTrue(miCalculadora.divide(4,2) > 0);
        assertTrue(miCalculadora.divide(4,-2)< 0);
        assertTrue(miCalculadora.divide(-4,2) < 0);
        assertTrue(miCalculadora.divide(-4,-2) > 0);
    }

    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.divide(5,0);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }

    @Test
    @DisplayName("Sumas numeros positivos, negativos y decimales")
    void testSumas() throws Exception {
        assertEquals(16, miCalculadora.suma(10, 6));
        assertEquals(70, miCalculadora.suma(63.5, 6.5));
        assertEquals(2, miCalculadora.suma(5, -3));
        assertEquals(-2, miCalculadora.suma(-11, 9));
    }

    @Test
    @DisplayName("Restas numeros positivos, negativos y decimales")
    void testRestas() throws Exception {
        assertEquals(4, miCalculadora.resta(10, 6));
        assertEquals(57.5, miCalculadora.resta(63.5, 6));
        assertEquals(8, miCalculadora.resta(5, -3));
        assertEquals(-20, miCalculadora.resta(-11, 9));
    }

    @Test
    @DisplayName("Potencias numeros positivos, negativos y decimales")
    void testPotencias() throws Exception {
        assertEquals(1000000, miCalculadora.potencia(10, 6));
        assertEquals(182.25, miCalculadora.potencia(13.5, 2));
        assertEquals(9, miCalculadora.potencia(-3, 2));
        assertEquals(0.001953125, miCalculadora.potencia(2, -9));
    }

    @Test
    @DisplayName("Raices cuadradas numeros positivos conocidos, cero y uno")
    void testRaizCuadrada() throws Exception {
        assertEquals(2, miCalculadora.raizCuadrada(4));
        assertEquals(8, miCalculadora.raizCuadrada(64));
        assertEquals(1, miCalculadora.raizCuadrada(1));
        assertEquals(0, miCalculadora.raizCuadrada(0));
    }

    @Test
    @DisplayName("Raiz cuadrada de un numero negativo causa excepción")
    void testRaizCuadradaNumeroNegativo() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
            miCalculadora.raizCuadrada(-1);
        });

        assertEquals("El radicando no puede ser negativo", thrown.getMessage());
    }
}