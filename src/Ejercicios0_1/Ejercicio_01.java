package Ejercicios0_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio_01 {
    public static void main(String[] args) {
       //solicigtar al usuario el directorio
        String directorioUsuario="C:\\Users\\manana.A2E31\\Desktop\\DAVID_01_JAVA";
        //crear el objeto file
        File directorio=new File(directorioUsuario);
        //crear directorio si no exixte
        if (!directorio.exists()){
            if (directorio.mkdirs()){
                System.out.println("Directorio creado: "+directorio.getPath());
            }else {
                System.out.println("error al crear elñ directorio");
                return;
            }

        }
        //crear el archivo example.txt
        File archivo = new File(directorio, "example.txt");
        try {
            if(archivo.createNewFile()){
                System.out.println("Archivo creado: "+archivo.getAbsolutePath());
            }
            else {
                System.out.println("El archivo ya existe "+archivo.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archvio");
        }
        //verificar si es archivo o directorio
        if (archivo.isFile()){
            System.out.println("Es un archivo");
        }else if(archivo.isDirectory()){
            System.out.println("Es Directorio");

        }
    }
}

