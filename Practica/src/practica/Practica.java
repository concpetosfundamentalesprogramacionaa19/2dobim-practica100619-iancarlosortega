/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.io.File;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Salas
 */
public class Practica {
    public static void leerRegistros(){
        
        try
        {
            // LLamar al archivo con los datos a analizar 
            Scanner scan = new Scanner(new File("data/tabula-FWC_2018_"
                    + "Squadlists_4.csv"));
            
            // Declaracion e inicializacion de variables
            double goals = 0;
            double promedio_goals = 0;
            double height = 0;
            double promedio_height = 0;
            double suma_goals = 0;
            double suma_height = 0;
            int contador = 0;
            
            // Uso de bandera automatica para leer todas las lineas del codigo
            while(scan.hasNext()){
                String linea = scan.nextLine();// Almacenar en una cadena
                
                // Separar por partes la cadena llamada linea
                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split("\\|")));
                
                // Transformar de String a double las variables
                double dato_goals = Double.parseDouble(linea_partes.get(11));
                double dato_height = Double.parseDouble(linea_partes.get(9));
                
                // Calculo de los promedios de goles y peso
                suma_goals = suma_goals + dato_goals;
                contador = contador + 1;
                promedio_goals = suma_goals / contador;
                suma_height = suma_height + dato_height;
                promedio_height = suma_height / contador;
            }
            scan.close();// Cerrar el scanner
            
            // Mostrar en pantalla los resultados
            System.out.printf("El promedio de los goles es: %.2f\nEl promedio "
                    + "del peso es: %.2f",promedio_goals,promedio_height);
            
        }
        catch (Exception e) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        }
        
    }
    
}
