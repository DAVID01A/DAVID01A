package Ejercicios0_1;

import java.io.*;

public class Ejercicio_03 {
    public static void main(String[] args) {
        //solicitar una cadena de texto
        System.out.println("Introduzca una frase: ");
        try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))) {
            String cadena= reader.readLine();
            //covertin la cadena en un arrays de bytes
            byte[] bytes=cadena.getBytes();
            //escribitr los bytes en un archivo llamdo byteFile.bin
            try(FileOutputStream fos= new FileOutputStream("byteFile.bin")) {
                fos.write(bytes);
                System.out.println("bytes escritos correctamente en el archivo byteFile.bin");
            }catch (IOException e){
                System.out.println("Error al escribir bytes en el archivo byteFile.bin" +e.getMessage());
            }
            //leer los bytes del archivos y convertirlos de nuevo a una cadena
            try (FileInputStream fis=new FileInputStream("byteFile.bin")){
                byte[] readBytes=fis.readAllBytes();
                String resultado=new String(readBytes);
                System.out.println("contenido del archivo : "+fis.readAllBytes()+" ( frase original : "+cadena+")");
            }catch (IOException e){
                System.out.println("Error al leer el contenido "+e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error al leer la entrada del usuario "+e.getMessage());
        }
    }
}
