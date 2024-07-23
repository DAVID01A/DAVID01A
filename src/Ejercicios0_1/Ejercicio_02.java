package Ejercicios0_1;

import java.io.*;
import java.util.Scanner;

public class Ejercicio_02 {
    public static void main(String[] args) {
        //solicitar una cadena de caracteres
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca una cadena de texto: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String cadena= sc.nextLine();

        //escribir la cadena en un archivo llamado texFile.txt
        try (BufferedWriter writer= new BufferedWriter(new FileWriter("texFile.txt"))){;
            writer.write(cadena);
            System.out.println("Cadena escrita en el archivo texFile.txt ");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo "+e.getMessage());
        }
        //leer el archivo he imprimir en consola
        try (BufferedReader filereader= new BufferedReader(new FileReader("texFile.txt")) ){
            String contenidio= filereader.readLine();
            System.out.println("contenido en el archivo\n "+contenidio);
        } catch (Exception e) {
            System.out.println("Error al leer el contenido "+e.getMessage());
        }
        }catch (IOException e) {
            System.out.println("Error al leer la entrada del usuario "+e.getMessage());
        }
    }}

