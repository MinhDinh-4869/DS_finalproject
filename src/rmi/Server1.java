package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server1 {
    public static void main(String[] args) {
        try {
            Calculator1 stub = new Calculator1Remote();
            LocateRegistry.createRegistry(3060);
            Naming.rebind("rmi://localhost:3060/Server1", stub);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}