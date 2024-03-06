/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import constants.ServerConstants;
import domain.Worker;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Veljko
 */
public class ServerThread extends Thread {
    
    private ServerSocket ss;
    private List<HandleClientRequests> clients;

    public ServerThread() throws IOException {
        Properties p =new Properties();
        p.load(new FileInputStream(ServerConstants.SERVER_CONFIG_FILE_PATH));
        String port = p.getProperty(ServerConstants.SERVER_CONFIG_PORT);
        ss=new ServerSocket(Integer.parseInt(port));
        clients=new ArrayList<>();
    }
    
    

    @Override
    public void run() {
        try {
            System.out.println("Server je pokrenut!");
            while (!ss.isClosed()) {
                Socket socket = ss.accept();
                System.out.println("Novi klijent je prisutan!");
                handleClientRequests(socket);                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stopAllClients();
    }
    
    private void handleClientRequests(Socket socket) {
        HandleClientRequests handleClientRequests = new HandleClientRequests(socket);
        handleClientRequests.start();
        clients.add(handleClientRequests);
    }
    
    public void closeServer(){
        try {
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServerSocket getServerSocket() {
        return ss;
    }

    public List<Worker> getAllCurrentWorkers() {
        List<Worker> workers = new ArrayList<>();
        for (HandleClientRequests client : clients) {
            workers.add(client.getCurrentWorker());
        }
        return workers;
    }
    
    public void logoutWorker(HandleClientRequests client) throws IOException{
        client.getSocket().close();
        clients.remove(client);
    }

    public List<HandleClientRequests> getClients() {
        return clients;
    }

    private void stopAllClients() {
        for (HandleClientRequests client : clients) {
            try {
                client.getSocket().close();
                clients.remove(client);
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
