package org.hmis;

public class Main {
    public static void main(String[] args) {
    	String ruta = "data/coches.json";
    	
    	Coche[] coches = JsonReader.leerCochesJSON(ruta);
    	
    	// Imprimir los objetos del arreglo
        for (Coche coche : coches) {
            System.out.println(coche);
        }
    }
}

