package Ejercicios0_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Ejercicio_05 {
    public static void main(String[] args) {
         String SERVIDOR_IP = "localhost";
         int PUERTO = 5000;
        try {
            // Conexión al servidor
            Socket socket = new Socket(SERVIDOR_IP, PUERTO);
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            // Solicitar al usuario que introduzca un mensaje
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce un mensaje: ");
            String mensajeOriginal = scanner.nextLine();
            System.out.println(mensajeOriginal);

            // Cifrar el mensaje sumando 3 al código ASCII de cada letra
            StringBuilder mensajeCifrado = new StringBuilder();
            for (char letra : mensajeOriginal.toCharArray()) {
                int codigoAsciiCifrado = letra + 3;
                mensajeCifrado.append((char) codigoAsciiCifrado);
                System.out.println(codigoAsciiCifrado);
            }

            // Enviar el mensaje cifrado al servidor
            salida.writeUTF(mensajeCifrado.toString());

            // Recibir y mostrar la respuesta del servidor (mensaje descifrado)
            String respuestaServidor = entrada.readUTF();
            System.out.println("Respuesta del servidor: " + entrada.readUTF());

            // Cerrar conexiones
            entrada.close();
            salida.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
