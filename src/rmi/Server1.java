package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server1 {
    public static void main(String[] args) {
        try {
            Calculator1 stub = new Calculator1Remote();
            System.setProperty("java.rmi.server.hostname", "192.168.1.17");//server's ip
            int port = 8080;
            Registry reg = LocateRegistry.createRegistry(port);
            reg.rebind("Server1", stub);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}