package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server2 {
    public static void main(String[] args) {
        try {
            Calculator2 stub = new Calculator2Remote();
            LocateRegistry.createRegistry(3061);
            Naming.rebind("rmi://localhost:3061/Server2", stub);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}