package com.everis.calculadorasimples;

import com.everis.introJUnit.Test;

import static org.junit.jupiter.api.Assertions.fail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculadoraTest {
    static Calculadora calculadora;

    @Test
    public void testaSomaMenosIngenuo() {
        Calculadora myCalc = new Calculadora();

        boolean temErro = false;
        if (myCalc.soma(2, 2) != 4) {
            temErro = true;
        }
        if (myCalc.soma(2, -2) != 0) {
            temErro = true;
        }
        if (myCalc.soma(-2, 2) != 0) {
            temErro = true;
        }
        if (myCalc.soma(-2, -2) != -4) {
            temErro = true;
        }
        if (myCalc.soma(0, 0) != 0) {
            temErro = true;
        }
        if (temErro) {
            fail("Houve um erro na validação da soma.");
        }
    }

    @Test
    public void deveResultarQuatroAoSomarDoisEDois() {
        assertEquals(4.0, calculadora.soma(2, 2));
    }

    @Test
    public void deveResultarZeroAoSomarDoisEMenosDois() {
        assertEquals(0.0, calculadora.soma(2, -2));
    }

    @BeforeAll
    public staic

    void setup() {
        calculadora = new Calculadora();
    }

    //Outros :@BeforeEach,@AfterEach,@AfterAll
    @DisplayName("Valida múltiplas somas com informações em CSV")
    @ParameterizedTest
    @CsvSorce({"1.0, 1.0, 2.0", "2.0, 3.0, 5.0", "3.0, 4.0, 7.0", "4.0, 4.0, 8.0"})
    void validaMultiplasSomasCSV(double parcela1, double parcela2, double resultadoEsperado) {
        assertEquals(resultadoEsperado, calculadora.soma(parcela1, parcela2));
    }

    @DisplayName("Valida múltiplas somas com informações em arquivo CSV")
    @ParameterizedTest
    @CSVFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void validaMultiplasSomasArqCSV(double parcela1, double parcela2, double resultadoEsperando) {
        assertEquals(resultadoEsperado, calculadora.soma(parcela1, parcela2));
    }

    @Test
    public void divisaoPorZeroGeraExcecao() {
        assertThrows(ArithmeticException.class, () ->) {
            int resultado = calculadora.restoDivisãoInteira(4, 0);
            System.out.println(resultado);
        });
    }
}