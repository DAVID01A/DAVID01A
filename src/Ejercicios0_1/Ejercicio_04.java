package Ejercicios0_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio_04 {
    public static void main(String[] args) {
        try {
            //creaando el socket conm el sevidor puerto 5000
            ServerSocket sS = new ServerSocket(5000);
            System.out.println("Servidor escuchando en el puerto 5000...");
            //esperar cocneccion de un cliente
            Socket cS = sS.accept();
            System.out.println("Cliente conectado desde "+cS.getInetAddress());
            //flujo entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cS.getInputStream()));
            PrintWriter salida= new PrintWriter(cS.getOutputStream(), true);
            //leer el mensaje del cliente
            String mensajeCliente= entrada.readLine();
            System.out.println("mensje del cliente: "+mensajeCliente);
            //respuesta de confirmacion al cliente
            String mensajeRespuesta= "Mensje recibido gracias por conectarte !!!!!!!!!!";
            System.out.println(mensajeRespuesta);
            //cerrando conexiones
            entrada.close();
            salida.close();
            cS.close();
            sS.close();
        } catch (IOException e) {
            System.out.println("Error al conectar con el puerto 5000 "+e.getMessage());
        }
    }
}
