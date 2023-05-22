package org.hmis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class CocheTest {
	private static Coche[] coches() {
		String ruta = "data/coches.json";
		Coche[] coches = JsonReader.leerCochesJSON(ruta);
		return coches;
	}

	@ParameterizedTest
	@MethodSource("coches")
	void testEquals(Coche coche) {
		Coche coche2 = new Coche();
		coche2.setAño(coche.getAño() + 1);
		assertEquals(coche, coche, "Los coches deberían ser iguales");
		assertNotEquals(coche, coche2, "Los coches no deberían ser iguales");
		coche.equals("Otro obj");
	}

	@ParameterizedTest
	@MethodSource("coches")
	void testToString(Coche coche) {
		String expected = "Coche [marca=" + coche.getMarca() + ", modelo=" + coche.getModelo() + ", año="
				+ coche.getAño() + ", precio=" + coche.getPrecio() + "]";
		assertEquals(expected, coche.toString());

	}

	// test getters
	@ParameterizedTest
	@CsvSource({ "Audi, A6, 25000, 2022" })
	void testGetters(String marca, String modelo, String precio, String year) {
		Coche coche = new Coche();
		coche.setMarca(marca);
		coche.setModelo(modelo);
		coche.setAño(Integer.valueOf(year));
		coche.setPrecio(Integer.valueOf(precio));
		assertEquals(marca, coche.getMarca());
		assertEquals(modelo, coche.getModelo());
		assertEquals(precio, String.valueOf(coche.getPrecio()));
		assertEquals(year, String.valueOf(coche.getAño()));
	}

}
