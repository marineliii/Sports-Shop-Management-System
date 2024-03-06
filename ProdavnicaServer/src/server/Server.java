/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import threads.HandleClientRequests;

/**
 *
 * @author Veljko
 */
public class Server {
    public void startServer() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Server je pokrenut!");
            while (true) {
                Socket socket = ss.accept();
                System.out.println("Novi klijent je prisutan!");
                handleClientRequests(socket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleClientRequests(Socket socket) {
        HandleClientRequests handleClientRequests = new HandleClientRequests(socket);
        handleClientRequests.start();
    }
}
