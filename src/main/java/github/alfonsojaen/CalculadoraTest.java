package github.alfonsojaen;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CalculadoraTest  {

        // Definimos el objeto para usarlo en todos los tests
        static Calculadora miCalculadora;

        @BeforeAll
        public static void setUpClass(){
            miCalculadora = new Calculadora();
        }

        @Test
        @DisplayName("Multiplica dos números")
        void testMultiplicar() {
            assertEquals(6.0, miCalculadora.multiplica(2.0, 3.0));
            assertEquals(0.0, miCalculadora.multiplica(5.0, 0.0));
            assertEquals(16.0, miCalculadora.multiplica(4.0, 4.0));
            assertEquals(-5.0, miCalculadora.multiplica(-5.0, 1.0));
        }

        @Test
        @DisplayName("Divisiones enteras y reales")
        void testDivisionesEnterasYReales() throws Exception {
            assertEquals(2.0, miCalculadora.divide(4.0, 2.0));
            assertEquals(2.5, miCalculadora.divide(10.0, 4.0));
            assertEquals(4.0, miCalculadora.divide(10.0, 2.5));
            assertEquals(3.2, miCalculadora.divide(8.0, 2.5));
            assertEquals(0.5, miCalculadora.divide(2.0, 4.0));
        }

        @Test
        @DisplayName("Divisiones positivos y negativos")
        void testDivisionesPositivosYNegativos() throws Exception {
            assertTrue(miCalculadora.divide(4.0, 2.0) > 0);
            assertTrue(miCalculadora.divide(4.0, -2.0) < 0);
            assertTrue(miCalculadora.divide(-4.0, 2.0) < 0);
            assertTrue(miCalculadora.divide(-4.0, -2.0) > 0);
        }

        @Test
        @DisplayName("División por cero causa excepción")
        void testDivisionPorCero() {
            Exception thrown = assertThrows(Exception.class, () -> {
                miCalculadora.divide(5.0, 0.0);
            });

            assertEquals("El divisor es 0", thrown.getMessage());
        }
        @Test
        void testRaizCuadradaDe1() {
        assertEquals(1.0, Calculadora.raizCuadrada(1), 0.0001);
        }

     @Test
    void testRaizCuadradaDe0() {
        assertEquals(0.0, Calculadora.raizCuadrada(0), 0.0001);
    }

    @Test
    void testRaizCuadradaDe4() {
        assertEquals(2.0, Calculadora.raizCuadrada(4), 0.0001);
    }

    @Test
    void testRaizCuadradaDeNumeroNegativo() {
        assertThrows(OperacionInvalidaException.class, () -> {
            Calculadora.raizCuadrada(-1);
        });
    }
}
